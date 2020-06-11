@acceptance
Feature: List

  Background: Set the authentication
    Given I authenticate as "user1"
    And I create a "board" with:
      | name | TestApp |

  @cleanData
  Scenario: Create a list
    Given I log in with my Trello account as "user1"
    And I select "TestApp" board
    When I create a List with:
      | name | ReviewSubjects |
    Then I should have a list created with:
      | name | ReviewSubjects |
