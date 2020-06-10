@acceptance
Feature: List

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | TestApp |

  @cleanData
  Scenario: Create a list
    Given I log in with my Trello account as "user1"
