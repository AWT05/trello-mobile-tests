@acceptance
Feature: List

  Background: Set the authentication and crate a list
    Given I authenticate as "user1"
    And I create a board with:
      | name | WorldNewsApp |
    And I create a list with:
      | name    | testLines  |
      | idBoard | {board.id} |

  @cleanDataApi
  Scenario: Update a list name
    Given I log in with my Trello account as "user1"
    And I select "WorldNewsApp" board
    When I update the "testLines" List with:
      | name | reviewed |
    Then I should have a list updated with:
      | name | reviewed |
