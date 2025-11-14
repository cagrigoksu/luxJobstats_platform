from paths import DATA_DIR
import requests

def download_xlsx(url: str, filename: str):
    DATA_DIR.mkdir(exist_ok=True, parents=True)
    filepath = DATA_DIR / filename

    print(f"[DOWNLOAD] Saving to {filepath}")

    r = requests.get(url)
    r.raise_for_status()

    with open(filepath, "wb") as f:
        f.write(r.content)

    return str(filepath)
