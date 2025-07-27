Feature: Login functionality
  @login
  Scenario: Verify the presence of login screen
    Given The user is on the HomeScreen
    When Click the view menu option
    And Click the login button
    Then Verify the presence of LoginScreen




    