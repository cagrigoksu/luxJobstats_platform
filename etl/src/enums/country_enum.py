
#* country_residence

COUNTRY_ENUM = {
    "Résidents (Luxembourg)": 0,
    "Frontaliers résidant en France": 1,
    "Frontaliers résidant en Belgique": 2,
    "Frontaliers résidant en Allemagne": 3,
    "Autres pays (hors L, A, B, F)": 4,
    "Non déterminé": 5,
}

COUNTRY_LABELS_EN = {
    0: "Luxembourg",
    1: "France",
    2: "Belgium",
    3: "Germany",
    4: "Other countries (excluding LU, DE, BE, FR)",
    5: "Not-Determined",
}

def translate_country(fr: str) -> int:
    return COUNTRY_ENUM.get(fr)