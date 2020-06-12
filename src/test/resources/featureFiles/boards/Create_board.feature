@acceptance
Feature: Board context.

  Background: Login in the page
    Given I log in with my Trello account as "user1"

  @cleanDataApi
  Scenario: Create a simple personal board from header.
    When I create a board from addButton with the following data
      | title | NOT wild |
    Then "NOT wild" board page should be visible
    And I navigate to boards home page
    * I select "NOT wild" board
    Then "NOT wild" board page should be visible
