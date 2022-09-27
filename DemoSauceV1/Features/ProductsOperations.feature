Feature: Scenarios 2 & 3

  Scenario: Validate provided Product is available or not
    Given User Launch Chrome browser
    When User opens Sauce Website
    And User enters Username and Password
    And Click on LOGIN
    Then Check product "Sauce Labs Bolt T-Shirt" is available or not
    Then Close browser
   
  Scenario: Validate all products price with all product individual page
    Given User Launch Chrome browser
    When User opens Sauce Website
    And User enters Username and Password
    And Click on LOGIN
    Then Validate price with product individual page
    Then Close browser
     
   
