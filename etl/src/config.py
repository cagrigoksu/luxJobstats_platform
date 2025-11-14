from dotenv import load_dotenv
import os

load_dotenv()

POSTGRES = {
    "host": os.getenv("POSTGRES_HOST"),
    "port": os.getenv("POSTGRES_PORT"),
    "db": os.getenv("POSTGRES_DB"),
    "user": os.getenv("POSTGRES_USER"),
    "password": os.getenv("POSTGRES_PASSWORD")
}

DATA_URLS = {
    "DATA_URL_1": os.getenv("DATA_URL_1"),
    "DATA_DWNLD_URL_1": os.getenv("DATA_DWNLD_URL_1"),

    "DATA_URL_2": os.getenv("DATA_URL_2"),
    "DATA_DWNLD_URL_2": os.getenv("DATA_DWNLD_URL_2")
}

