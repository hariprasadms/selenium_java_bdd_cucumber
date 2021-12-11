@KiWelcomePage
Feature: As a user, I am able to create a new quote

  @SmokeTest @RegressionTest
  Scenario: User is able to see his pending quotes
    Given I can launch browser and navigate welcome page
    Then I see welcome page loaded with see my pending quotes and create new quotes
    