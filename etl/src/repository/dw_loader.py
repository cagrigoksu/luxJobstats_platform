import pandas as pd
from repository.insert_data import insert_dataframe
import json

from enums.gender_enum import translate_gender
from enums.continent_enum import translate_continent
from enums.status_enum import translate_status
from enums.country_enum import translate_country
from enums.residence_enum import translate_residence_nationality
from enums.age_enum import translate_age

from paths import LOCAL_DATA_DIR

NATIONALITY_JSON = LOCAL_DATA_DIR / "nationality_mapping_en.json"
SECTOR_JSON = LOCAL_DATA_DIR / "sector_mapping_en.json"

def load_sector_map(): 
    with open(SECTOR_JSON, "r", encoding="utf-8") as f: 
        return json.load(f) 
    
def translate_sector(fr: str) -> str: 
    sector_map = load_sector_map() 
    return sector_map.get(fr, fr)

def load_nationality_map(): 
    with open(NATIONALITY_JSON, "r", encoding="utf-8") as f: 
        return json.load(f) 
    
def translate_nationality(fr: str) -> str: 
    nationality_map = load_nationality_map() 
    return nationality_map.get(fr, fr)


def process_dataset1_df(df: pd.DataFrame, engine):

    if df.empty:
        print("[ETL] Dataset1 is empty — skipping.")
        return

    fact_df = pd.DataFrame()

    fact_df["reference_date"] = df["reference_date"]
    fact_df["country_id"] = df["country_residence"].apply(translate_country)
    fact_df["continent_id"] = df["continent"].apply(translate_continent)
    fact_df["nationality_id"] = df["nationality"].apply(translate_nationality)
    fact_df["sector_id"] = df["sector"].apply(translate_sector)
    fact_df["employee_count"] = df["employee_count"]

    _validate_missing_ids(
        df, fact_df, ["country_id", "continent_id", "nationality_id", "sector_id"],
        dataset_name="Dataset1"
    )

    print(f"[ETL] Inserting {len(fact_df)} rows into fact_salaries_by_nationality...")
    insert_dataframe(fact_df, "fact_salaries_by_nationality", engine)


def process_dataset2_df(df: pd.DataFrame, engine):

    if df.empty:
        print("[ETL] Dataset2 is empty — skipping.")
        return

    fact_df = pd.DataFrame()

    fact_df["reference_date"] = df["reference_date"]
    fact_df["gender_id"] = df["gender"].apply(translate_gender)
    fact_df["residence_nationality_id"] = df["residence_nationality"].apply(translate_residence_nationality)
    fact_df["age_id"] = df["age"].apply(translate_age)
    fact_df["sector_id"] = df["sector"].apply(translate_sector)
    fact_df["status_id"] = df["status"].apply(translate_status)
    fact_df["employee_count"] = df["employee_count"]

    _validate_missing_ids(
        df, fact_df,
        ["gender_id", "residence_nationality_id", "age_id", "sector_id", "status_id"],
        dataset_name="Dataset2"
    )

    print(f"[ETL] Inserting {len(fact_df)} rows into fact_salaries_by_characteristics...")
    insert_dataframe(fact_df, "fact_salaries_by_characteristics", engine)


def _validate_missing_ids(df: pd.DataFrame, fact_df: pd.DataFrame, enum_cols: list, dataset_name: str):

    for col in enum_cols:
        if fact_df[col].isna().any():
            print(f"\n[WARNING] Missing enum mapping in {dataset_name} for column: {col}")
            missing_rows = df[fact_df[col].isna()]
            print("Unique unmapped values:")
            print(missing_rows.nunique())
            print(missing_rows.head())
            print("Fix the mapping in the corresponding enum file.\n")
