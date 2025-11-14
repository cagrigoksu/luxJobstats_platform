import requests
from bs4 import BeautifulSoup
from datetime import datetime

def extract_last_update_date(page_url: str) -> datetime:
    # request the website of the xlsx file, and checks the last update date
    response = requests.get(page_url)
    response.raise_for_status()
    soup = BeautifulSoup(response.text, "lxml")

    # find <h3> containing "Latest update"
    header = soup.find("h3", string=lambda t: t and "Latest update" in t)
    if not header:
        raise Exception("Could not find the <h3> Latest update section.")

    # The last updated date is inside the next <p> tag
    date_paragraph = header.find_next("p")
    if not date_paragraph:
        raise Exception("Could not find the date <p> tag following the header.")

    date_text = date_paragraph.text.strip()

    try: 
        # EN date
        parsed_date = datetime.strptime(date_text, "%B %d, %Y")

    except ValueError as e:

        raise ValueError(
            f"Date parsing failed. Please check if the page is in EN language."
            f"Expected English format like 'October 18, 2025'. "
            f"Original error: {e}"
        )

    return parsed_date

#extract_last_update_date("https://..."))
# Output: for October 18, 2025 --> datetime.datetime(2025, 10, 18, 0, 0) 
