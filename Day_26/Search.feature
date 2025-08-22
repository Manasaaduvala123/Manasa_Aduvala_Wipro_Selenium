Feature: Product Search on eBay
@Priority2
Scenario Outline: Search for products
Given eBay homepage is open in browser
When user searches for <product>
Then search results should be displayed for <product>
Examples:
      | product   |
      | laptop    |
      | mobile    |
      | headphones|
