Feature: Amazon Product Search and Purchase

  Scenario: Search, Select, and Add iPhone to Cart on Amazon
    Given the user is on the Amazon home page
    When the user searches for "iphone"
    Then a list of search results is displayed
    When the user selects product from the list
    Then the user is on the product details page
    When the user retrieves the price of the iPhone and stores it in a variable
    And the user adds the iPhone to the cart
    Then the iPhone should be added to the cart successfully
	
	