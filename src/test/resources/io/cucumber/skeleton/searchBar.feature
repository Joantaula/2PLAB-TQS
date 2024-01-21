Feature: Tests dedicated to search products


  Scenario: Let’s open de search bar
    Given the user is on "https://www.faciway.com"
    When the user selects the "iconfonts icon-sousuo2" button "span" type
    Then the "input-wrapper" window opens

  Scenario: Let’s search a product
    Given the user is on "https://www.faciway.com"
    When the user selects the "iconfonts icon-sousuo2" button "span" type
    And the user search "sudadera"
    Then the user should be in "https://www.faciway.com/search/?words=sudadera"

    Scenario: Let’s see our last searches
      Given the user is on "https://www.faciway.com"
      When the user selects the "iconfonts icon-sousuo2" button "span" type
      And the user checks button "search-input"
      Then the "recent-search-content" window opens



      




