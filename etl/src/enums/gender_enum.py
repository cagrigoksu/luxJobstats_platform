GENDER_ENUM = {
    "Hommes": 0,
    "Femmes": 1,
}

GENDER_LABELS_EN = {
    0: "Male",
    1: "Female",
}

def translate_gender(fr: str) -> int:
    return GENDER_ENUM.get(fr)
