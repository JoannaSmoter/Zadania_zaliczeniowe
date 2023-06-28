@address
Feature: Create and Verify Address


  Scenario Outline: Create a new address
    Given I'm on the shop authentication page
    When I login using email "cpkidtonkuzewrkewy@bbitq.com" and password "AS12345"
    And I go to Addresses
    Then I click Create new address button
    When I enter new data alias "<alias>", address "<address>", city "<city>", postal code "<postalCode>", country "<country>", phone number "<phoneNumber>"
    And I click Save
    Then I verify that the address is correct
    And I close the browser
Examples:
    |alias|address   |city   |postalCode   |country        |phoneNumber    |
    |Ad1  |Spokojna  |Gaj    |  35-123     |United Kingdom |55555555       |