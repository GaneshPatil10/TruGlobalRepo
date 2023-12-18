Feature: Search and Filter Phones on Amazon

  Scenario: Search for Phones, Apply Filters, and Validate Results
    Given the user is on the Amazon homepage
    When the user searches for phone as "Phone"
    Then product list of search results is displayed
    When the user applies filters for brand, operating system, etc.
    Then the filtered product list is displayed
    
    
