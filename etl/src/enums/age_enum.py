
AGE_ENUM_MAP = {
    "< 25 ans": 0,
    "25 - 39 ans": 1,
    "40 - 54 ans": 2,
    "55 ans et plus": 3
}

AGE_LABELS_EN = {
    0: "Under 25",
    1: "25–39",
    2: "40–54",
    3: "55+",
}

def translate_age(fr: str) -> int:

    if not isinstance(fr, str):
        return None
    return AGE_ENUM_MAP.get(fr.strip())
