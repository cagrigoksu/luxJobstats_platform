import pandas as pd

# fr → en names
FR2EN = {
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
    # read correct sheet
    df = pd.read_excel(filepath, sheet_name="Données source")

    # rename cols
    df.rename(columns=FR2EN, inplace=True)

    # keep known cols only
    df = df[[c for c in df.columns if c in FR2EN.values()]]

    # trim all str values
    for col in df.columns:
        if df[col].dtype == object:
            df[col] = df[col].astype(str).str.strip()

    # fix numbers
    if "employee_count" in df.columns:
        df["employee_count"] = (
            df["employee_count"].astype(str)
            .str.replace(" ", "")
            .str.replace(",", ".")
        )
        df["employee_count"] = pd.to_numeric(df["employee_count"], errors="coerce").fillna(0).astype(int)

    # fix dates
    if "reference_date" in df.columns:
        df["reference_date"] = pd.to_datetime(df["reference_date"], errors="coerce").dt.date

    return df
