import json
import os
from datetime import datetime
from paths import CACHE_FILE

def load_cache():
    if not os.path.exists(CACHE_FILE):
        return {}
    with open(CACHE_FILE, "r") as f:
        return json.load(f)

def save_cache(cache_dict):
    os.makedirs(".cache", exist_ok=True)
    with open(CACHE_FILE, "w") as f:
        json.dump(cache_dict, f, indent=4)

def get_cached_update(dataset_key):
    cache = load_cache()
    if dataset_key not in cache:
        return None
    return datetime.fromisoformat(cache[dataset_key])


def update_cache(dataset_key, update_date: datetime):
    cache = load_cache()
    cache[dataset_key] = update_date.isoformat()
    save_cache(cache)
    
