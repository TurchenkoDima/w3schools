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