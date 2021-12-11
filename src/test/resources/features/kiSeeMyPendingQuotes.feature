@KiWelcomePage
Feature: As a user, I am able to see my pending quotes

  @SmokeTest @RegressionTest
  Scenario: User is able to see his pending quotes
    Given I can launch browser and navigate welcome page
    Then I see welcome page loaded with see my pending quotes and create new quotes
    Then I can see see my pending quotes checkbox
    And I can see my create new quote checkbox

  @SmokeTest @RegressionTest
  Scenario: User is able to see mandatory fields validation messages
    Given I can launch browser and navigate welcome page
    Then I see welcome page loaded with see my pending quotes and create new quotes
    When I click on next button, i see mandatory validation message