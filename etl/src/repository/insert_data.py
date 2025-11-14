from pandas import DataFrame

def insert_dataframe(df, table_name: str, engine):
    # insert df to postgres table

    try:
        df.to_sql(table_name, engine, if_exists="append", index=False)
        print(f"[DB] Inserted {len(df)} rows into '{table_name}'")
        
    except Exception as e:
        print(f"[ERROR] Failed to insert into table: {table_name}")
        raise e
