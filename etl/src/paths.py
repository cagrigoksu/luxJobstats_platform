from pathlib import Path

# root --> src folder's parent
PROJECT_ROOT = Path(__file__).resolve().parent.parent

DATA_DIR = PROJECT_ROOT / "data"
LOCAL_DATA_DIR = PROJECT_ROOT / "local_data"
CACHE_FILE = PROJECT_ROOT / "update_cache/last_update.json"
