Feature: Scenarios 1 & 4

  Scenario: Validate correct products are ordered or not
    Given User Launch Chrome browser
    When User opens Sauce Website
    And User enters Username and Password
    And Click on LOGIN
    And Add the product to the cart
    Then Click on cart link
    And Click on Checkout the product
    And Enter First name as "Rushi" Last name as "Patil" and Zip code as "411033" on Checkout page
    Then Click on Checkout button
    And Validate the ordered product details
    Then Close browser
    
   Scenario:  Validate error message after invalid username and password
    Given User Launch Chrome browser
    When User opens Sauce Website
    And User enters Username as "user1" and Password as "pass"
    Then Validate error message
    Then Close browser
