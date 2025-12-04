from config import DATA_URLS
from downloader.check_update import extract_last_update_date
from downloader.fetcher import download_xlsx
from parser.xlsx_parser import load_xlsx_to_df
from database import get_engine

from repository.dw_loader import process_dataset1_df, process_dataset2_df


def process_dataset(page_url, download_url, dataset_key):
    print(f"\ncheck: {dataset_key}")

    filename = download_url.split("/")[-1]
    filepath = download_xlsx(download_url, filename)

    df = load_xlsx_to_df(filepath)
    engine = get_engine()

    print("[ETL] load into DW...")

    if dataset_key == "dataset_1":
        process_dataset1_df(df, engine)
    elif dataset_key == "dataset_2":
        process_dataset2_df(df, engine)

    print("done.\n")


def run_daily_etl():
    process_dataset(DATA_URLS["DATA_URL_1"], DATA_URLS["DATA_DWNLD_URL_1"], "dataset_1")
    process_dataset(DATA_URLS["DATA_URL_2"], DATA_URLS["DATA_DWNLD_URL_2"], "dataset_2")


if __name__ == "__main__":
    run_daily_etl()
