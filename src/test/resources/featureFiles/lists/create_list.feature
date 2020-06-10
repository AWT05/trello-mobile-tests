@acceptance
Feature: List

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | TestApp |

  @cleanData
  Scenario: Create a list
    Given I log in with my Trello account as "user1"
    And I navigate to boards menu from header
    And I open the "TestApp" board
    When I create a List with:
      | name | ToDo |
    Then I should have a list created with:
      | name | ToDo |
