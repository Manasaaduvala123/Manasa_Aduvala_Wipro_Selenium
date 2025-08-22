Feature: check user is able to filter the item
Scenario: successful filter item get
Given home page should be open in default  browsers
When click on search bar and search item
And click on the filter buttons
Then filtered results should display matching item
