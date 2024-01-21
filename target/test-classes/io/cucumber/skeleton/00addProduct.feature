Feature: Adding products tests
  We are going to test adding products to
  our shopping cart, then delete it
  Scenario: We are going to add a product to the cart
    Given the user is on "https://www.faciway.com/products/sun-moon-star-ocean-oversize-tee-7547894.html?navId=113892&from=collections&variant=100731888"
    When the user selects the "button-text" button "span" type
    Then the "cart-sidebar mz-cart-sidebar" window opens

  Scenario: Now we are change to the cart slide
    Given the user is on "https://www.faciway.com/products/sun-moon-star-ocean-oversize-tee-7547894.html?navId=113892&from=collections&variant=100731888"
    When the user selects the "mz-headcart iconfonts icon-gouwuche3" button "div" type
    Then the user should be in "https://www.faciway.com/cart"

  Scenario: Afterall we are going to delete everything of the cart
    Given the user is on "https://www.faciway.com/cart"
    When the user selects the "remove remove-cart-js" button "button" type
    Then the "cart-item-content" delete




