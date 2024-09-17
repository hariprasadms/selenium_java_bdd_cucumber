@KiWelcomePage
Feature: As a user, I am able to create a new quote

  @SmokeTest @RegressionTest
  Scenario Outline: User is able to see his pending quotes
    Given I can launch browser and navigate welcome page
    Then I see welcome page loaded with see my pending quotes and create new quotes
    When I choose create new quote checkbox
    And click on next button
    Then Create new quote page displayed with primary insured fields
    When I choose Primary country
    And Chose Primary Insured
    And Class of business "<businessClass>"
    And click on next button
    Then Details of coverage fields displayed
    When I choose Inception date, AVM value and premium values
    And click on next button
    Then a new quote is created successfully
    Examples:
      | businessClass |
      | Cyber         |
      | Energy        |
      | Property      |






    