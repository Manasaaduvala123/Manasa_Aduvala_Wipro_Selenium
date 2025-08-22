Feature:Check user is able to shop By category 
@Priority4
Scenario: Verify Shop by category works
Given home page should be open in default browsers
When click on shop-by-category
And click on a autopart
Then successfully see item by shop-by-category
