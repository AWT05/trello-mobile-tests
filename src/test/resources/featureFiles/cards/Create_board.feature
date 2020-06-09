@cleanData
Feature: Board context.

  Background: Login in the page
#    Given I log in with my Trello account as "user1"

  Scenario: Create a simple personal board from header.
    When I create a board from addButton with the following data
      | title | Trello |
    Then "Trello" board page should be visible
    And I navigate to boards home page
    * I select "Trello" board
    * "Trello" board page should be visible
    Then "Trello" board page should be visible