CREATE TABLE IF NOT EXISTS dim_country (
    id SERIAL PRIMARY KEY,
    country_name_fr TEXT UNIQUE,
    country_name_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_continent (
    id SERIAL PRIMARY KEY,
    continent_name_fr TEXT UNIQUE,
    continent_name_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_nationality (
    id SERIAL PRIMARY KEY,
    nationality_fr TEXT UNIQUE,
    nationality_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_sector (
    id SERIAL PRIMARY KEY,
    sector_name_fr TEXT UNIQUE,
    sector_name_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_gender (
    id SERIAL PRIMARY KEY,
    gender_fr TEXT UNIQUE,
    gender_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_status (
    id SERIAL PRIMARY KEY,
    status_fr TEXT UNIQUE,
    status_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_residence_nationality (
    id SERIAL PRIMARY KEY,
    label_fr TEXT UNIQUE,
    label_en TEXT
);

CREATE TABLE IF NOT EXISTS dim_age (
    id SERIAL PRIMARY KEY,
    age_label_fr TEXT UNIQUE,
    age_label_en TEXT
);


CREATE TABLE IF NOT EXISTS fact_salaries_by_nationality (
    id SERIAL PRIMARY KEY,
    reference_date DATE,
    country_id INT REFERENCES dim_country(id),
    continent_id INT REFERENCES dim_continent(id),
    nationality_id INT REFERENCES dim_nationality(id),
    sector_id INT REFERENCES dim_sector(id),
    employee_count INT
);

CREATE TABLE IF NOT EXISTS fact_salaries_by_characteristics (
    id SERIAL PRIMARY KEY,
    reference_date DATE,
    gender_id INT REFERENCES dim_gender(id),
    residence_nationality_id INT REFERENCES dim_residence_nationality(id),
    age_id INT REFERENCES dim_age(id),
    sector_id INT REFERENCES dim_sector(id),
    status_id INT REFERENCES dim_status(id),
    employee_count INT
);
