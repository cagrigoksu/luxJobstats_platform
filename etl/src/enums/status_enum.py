STATUS_ENUM = {
    "Fonctionnaires": 0,
    "Salariés non-fonctionnaires": 1,
}

STATUS_LABELS_EN = {
    0: "Civil Servants",
    1: "Private Employees",
}

def translate_status(fr: str) -> int:
    return STATUS_ENUM.get(fr)