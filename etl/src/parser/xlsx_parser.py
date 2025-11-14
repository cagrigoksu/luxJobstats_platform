import pandas as pd

FRENCH_TO_ENGLISH_COLS = {
    "Date de référence": "reference_date",
    "Pays résidence": "country_residence",
    "Continent nationalité": "continent",
    "Nationalité": "nationality",
    "Nombre de salariés": "employee_count",
    "Secteur d'activité": "sector",
    "Genre": "gender",
    "Résidence - nationalité": "residence_nationality",
    "Age": "age",
    "Statut": "status",
}

def load_xlsx_to_df(filepath: str):
    # xlsx to df

    try:
        df = pd.read_excel(filepath, sheet_name="Données source")
        print(f"[PARSER] Loaded '{filepath}' -> {df.shape[0]} rows")

        # eename fields to English
        df.rename(columns=FRENCH_TO_ENGLISH_COLS, inplace=True)

        # Keep only columns we recognize
        df = df[[col for col in df.columns if col in FRENCH_TO_ENGLISH_COLS.values()]]

        return df

    except Exception as e:
        print(f"[ERROR] Failed parsing Excel file: {filepath}")
        raise e