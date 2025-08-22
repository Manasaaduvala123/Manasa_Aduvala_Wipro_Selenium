Feature: Check user is able to get product description by right-clicking on product image
@Priority5
Scenario: Successfully get description by right-clicking on a specific product image
Given the home page should be open in default browser
When the user searches for a specific product
And the user right-clicks on the product image
Then the description of the selected product should be displayed
