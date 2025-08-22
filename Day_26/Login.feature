Feature: Login to eBay
@Priority1
Scenario Outline: check for valid and invalid credentials
Given login page should be open in default browser
When click on login button and enter <username>
And click on continue button
When add <password>
And click on signin button check <status>
Then login successfully and open home page
Examples:
      | username                   | password   | status   |
      | manasaaduvala123@gmail.com | @admin123   | valid    |
