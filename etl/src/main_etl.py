from config import DATA_URLS
from downloader.check_update import extract_last_update_date
from downloader.fetcher import download_xlsx
from cache_manager import get_cached_update, update_cache
from parser.xlsx_parser import load_xlsx_to_df
from database import get_engine

from repository.dw_loader import (
    process_dataset1_df,
    process_dataset2_df
)

def process_dataset(page_url, download_url, dataset_key):
    print(f"\nChecking update for dataset: {dataset_key}")

    latest_update = extract_last_update_date(page_url)
    cached_update = get_cached_update(dataset_key)

    print(f"Latest update on website: {latest_update}")
    print(f"Last processed update:    {cached_update}")

    if cached_update and latest_update <= cached_update:
        print("No new update. Skipping download.\n")
        return

    print("New update detected. Downloading file...")
    filename = download_url.split("/")[-1]
    filepath = download_xlsx(download_url, filename)

    #* load only "Données source" sheet + english column names
    df = load_xlsx_to_df(filepath)
    engine = get_engine()

    print("[ETL] Processing data into warehouse (fact tables + enums)...")

    if dataset_key == "dataset_1":
        # sector / nationality / residence
        process_dataset1_df(df, engine)

    elif dataset_key == "dataset_2":
        # sector / status / gender
        process_dataset2_df(df, engine)

    else:
        raise ValueError(f"Unknown dataset_key '{dataset_key}'")

    print("Updating cache...")
    update_cache(dataset_key, latest_update)
    print("Done.\n")


def run_daily_etl():
    # db 1
    process_dataset(
        page_url=DATA_URLS["DATA_URL_1"],
        download_url=DATA_URLS["DATA_DWNLD_URL_1"],
        dataset_key="dataset_1",
    )

    # db 2
    process_dataset(
        page_url=DATA_URLS["DATA_URL_2"],
        download_url=DATA_URLS["DATA_DWNLD_URL_2"],
        dataset_key="dataset_2",
    )


if __name__ == "__main__":
    run_daily_etl()
