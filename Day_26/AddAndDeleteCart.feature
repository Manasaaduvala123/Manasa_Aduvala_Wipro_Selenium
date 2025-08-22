Feature: check user is able to add product to cart
@Priority3
Scenario: successful add product to cart
Given product page should be open in default browsers
When click on the add to cart buttton
And click on see on cart button 
And click on remove from cart button 
Then item is add and remove successfully
