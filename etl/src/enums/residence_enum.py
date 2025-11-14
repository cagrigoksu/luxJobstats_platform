
#* résidence_nationalité

RESIDENCE_ENUM = {
    "Résidents luxembourgeois": 0,
    "Résidents non-luxembourgeois": 1,
    "Frontaliers résidant en France": 2,
    "Frontaliers résidant en Belgique": 3,
    "Frontaliers résidant en Allemagne": 4,
    "Autres pays (hors L, A, B, F)": 5,
    "Non déterminé": 6,
}

RESIDENCE_LABELS_EN = {
    0: "Luxembourgish Resident",
    1: "Non-Luxembourgish Resident",
    2: "France",
    3: "Belgium",
    4: "Germany",
    5: "Other countries (excluding LU, DE, BE, FR)",
    6: "Not-Determined"
}

def translate_residence_nationality(fr: str) -> int:
    return RESIDENCE_ENUM.get(fr)