@KiWelcomePage
Feature: As a user, I am able to see my pending quotes

  @SmokeTest @RegressionTest
  Scenario: User is able to see his pending quotes
    Given I can launch browser and navigate welcome page
    Then I see welcome page loaded with see my pending quotes and create new quotes
    When I can select see my pending quotes checkbox
    And click on next button
    Then I can see pending quotes page displayed
    And I can see quote details
