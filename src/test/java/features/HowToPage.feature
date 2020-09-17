Feature: w3schools/howto page

  Scenario: Login modal window

    Given I open https://www.w3schools.com/howto
    When I choose 'Login Form'
    And I press 'Login' button
    Then login pop-up form is opened
    When I enter username
    And I enter password
    And I do not opt-in 'Remember me' check-box
    And I press 'Login' button in pop-up
    Then login pop-up form is closed

  Scenario Outline: Checkout Form

    Given I open https://www.w3schools.com/howto
    When I choose ‘Checkout Form’
    Then I see shopping cart that contains 4 items
    And I see total amount as $30
    When I fill in 'Billing Address' form with my '<personal>' information
    And I fill in 'Payment' form with my '<payment>' information
    And I press 'Continue to checkout' button
    Then nothing happens
    Examples:
      | personal  | payment          |
      | Turchenka | 1111222233334444 |