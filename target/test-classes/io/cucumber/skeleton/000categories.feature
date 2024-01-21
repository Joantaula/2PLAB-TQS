Feature: Tests dedicated to inspect categories
  As a not logged in user
  we are going to filter our search by different measures

  Scenario: Let's search by color
    Given the user is on "https://www.faciway.com/collections/street-tees-114238/"
    When the user selects the "is--color is--blue" button "span" type
    Then the user should be in "https://www.faciway.com/collections/street-tees-114238/?orderBy=SELL30&filters=color:blue"

  Scenario: Let's Filter by category
    Given the user is on "https://www.faciway.com"
    When the user clicks button "T-SHIRTS"
    Then the user should be in "https://www.faciway.com/collections/t-shirts-113892/"

  Scenario: Let’s filter by size
    Given the user is on "https://www.faciway.com/collections/hoodies-116402/"
    When the user selects option : "L"
    Then the user should be in "https://www.faciway.com/collections/hoodies-116402/?orderBy=SELL30&filters=size:l"









