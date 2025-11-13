from sqlalchemy import create_engine
from config import POSTGRES

def get_engine():
    url = (
        f"postgresql://{POSTGRES['user']}:{POSTGRES['password']}"
        f"@{POSTGRES['host']}:{POSTGRES['port']}/{POSTGRES['db']}"
    )
    
    return create_engine(url)
