Feature: Tests dedicated to modify a product before selection
  As a user we are going to check if you can modify
  the details of the product you are looking for

  Scenario: Let’s know more about sizes
    Given the user is on "https://www.faciway.com/products/mens-vintage-print-oversized-t-shirt-7426612.html?navId=113892&from=collections"
    When the user selects the "size-model" button "span" type
    Then the "size-form_head" window opens

  Scenario: Let’s change the country size
    Given the user is on "https://www.faciway.com/products/mens-vintage-print-oversized-t-shirt-7426612.html?navId=113892&from=collections"
    When the user selects the "size-zone-select" button "select" type
    And the user selects "Size (US)" option
    Then the users sees "US4/6" icon

    Scenario: Let’s select a size
      Given the user is on "https://www.faciway.com/products/mens-vintage-print-oversized-t-shirt-7426612.html?navId=113892&from=collections"
      When the user selects "2XL" size
      Then the user sees message type="span" class="label-size" text="2XL"




