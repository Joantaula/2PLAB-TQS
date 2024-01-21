Feature: Tests dedicated to the main-interface

  Scenario: Let’s sign up wrongly
    Given the user is on "https://www.faciway.com"
    When the user selects the "personalIcon" button "a" type
    Then the user should be in "https://www.faciway.com/account/favourite?tag=2"

    Scenario: Let’s see our order tracking
      Given the user is on "https://www.faciway.com"
      When the user clicks button "Order Tracking"
      Then the user should be in "https://www.faciway.com/customerservices?ccy=USD&locale=en"









