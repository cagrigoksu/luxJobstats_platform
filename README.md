# Luxembourg Job Stats Platform

## LuxJobStats-API
TO-DO fill this part

## ETL Module

This project includes an ETL pipeline that automatically processes the Luxembourg job-market datasets used throughout the platform. The ETL runs inside a dedicated Docker container and performs the following steps:

### Extract

* Reads the official `.xlsx` datasets (employment, salaries, sectors, nationalities, etc.).

* Uses pandas to load and validate data.

### Transform

* Cleans and standardizes fields (dates, numbers, naming).

* Builds dimension tables (country, nationality, sector, gender, status…).

* Automatically translates French labels into English using the **DeepL API**.
Only missing translations are processed (*_en IS NULL_) to avoid unnecessary API calls.

### Load

* Inserts/updates data into a **PostgreSQL** database.

### Infrastructure

* Runs as a Dockerized service with its own environment.
* Runs _**daily**_ dataset source check.
* Logs all operations to `/var/log/etl.log`.