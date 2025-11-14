CONTINENT_ENUM = {
    "Afrique": 0,
    "Amérique": 1,
    "Asie": 2,
    "Europe UE-27": 3,
    "Europe Non UE-27": 4,
    "Océanie": 5,
    "Non déterminé": 6,
}

CONTINENT_LABELS_EN = {
    0: "Africa",
    1: "America",
    2: "Asia",
    3: "EU-27",
    4: "Non-EU-27",
    5: "Oceania",
    6: "Not-Determined",
}

def translate_continent(fr: str) -> int:
    return CONTINENT_ENUM.get(fr)