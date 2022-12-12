@SmokeTest
@SelectProduct
Feature: Test that user is able to select product by group, sub-group, brand, sort results and add selected product to chart.

  Scenario: Open 1a.lv select 'Skaistumam un veselibai', select sub-group: 'Lokskeres' and choose brand Remington.
  Sort search result by price and select the most expensive item and add it to chart.
  Validate that product name and price in chart match with expected.

    Given Open 1a.lv
    And Cookies are closed
    When Select group Skaistumam un veselibai
    And Select subgroup Sievietes skaistumam
    And Select sub-group Lokskeres
    And Choose brand Remington
    And Sort result by price_desc
    And Select first item in the list
    And Add product to chart
    Then Product name in chart match with expected
    And Product price in chart match with expected




