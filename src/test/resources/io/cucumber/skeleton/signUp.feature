Feature: Tests dedicated to create an account

  Scenario: Let’s sign up wrongly
    Given the user is on "https://www.faciway.com/account/login"
    When the user signs up with credentials: user="estoesunaprueba.com" and password = "estoesunaprueba"
    Then the user should be in "https://www.faciway.com/account/login"


  Scenario: Let’s recover our password
    Given the user is on "https://www.faciway.com/account/login"
    When the user clicks button "¿Olvidó su contraseña?"
    Then the user should be in "https://www.faciway.com/account/recover"
    And  the user inputs her mail "prueba12@correo.es"
    Then the user should be in "https://www.faciway.com/account/recover"


  Scenario: Let’s sign up
    Given the user is on "https://www.faciway.com/account/login"
    When the user signs up with credentials: user="uabprueba-12apocas2333@klkququ.es" and password = "prueba01"
    Then the user should be in "https://www.faciway.com/account/register/ok"









