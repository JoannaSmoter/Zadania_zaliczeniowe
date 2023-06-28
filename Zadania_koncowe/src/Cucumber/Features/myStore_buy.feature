@shopping

Feature: Product purchase

  Scenario: Product selection and purchase
    Given I'm on the authentication page
    When I login using  my email "iytyvrqwcxzyhcukfs@tpwlb.com" and password "AS12345"
    And I go to main paige
    Then I choose the Hummingbird Printed Sweater with a 20% discount
    And I check discount
    And I select size "M"
    And I add 5 items
    And I add to the cart
    And I proceed to checkout
    And I confirm the address
    And I choose delivery method
    And I choose the payment option
    And I choose I agree to the terms of service and will adhere to them unconditionally.
    Then I approve and am on the order page
    And I will take a screenshot of the order confirmation and amount.



