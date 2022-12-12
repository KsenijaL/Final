@SmokeTest
@BuyProduct

Feature: Test that user is able to buy product

  Scenario: Select specific product, add it to chart.
  Buy as unregistered user, select delivery type - pick up at office and pay by cash.

    Given Open 1a.lv
    And Cookies are closed
    And Select product Remington PROluxe CI9132, 32 mm
    And Add product to chart
    When Continue buying as not registered user
    And Select delivery type Pick up from office
    And Specify pick-up office city Daugavpils and street Krauja
    And Fill in user details
    And Submit filled in details
    And Select payment type cash
    Then Validate that user name in payment page match with expected
    And Validate that user phone in payment page match with expected
    And Validate that product price in payment page match with expected
