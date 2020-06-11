@acceptance
Feature: list interactions

  Background: Set the authentication
    Given I authenticate as "user2"
    And I create a "board" with:
      | name | ShareMobile |
    And I invite a member by setting its type with:
      | user2 | normal |
    And I create a "list" with:
      | name    | toShare    |
      | idBoard | {board.id} |

  @cleanData
  Scenario: updating a list from other account
    Given I log in with my Trello account as "user1"
    And I select "ShareMobile" board
    When I update the "toShare" List with:
      | name | MoBileTest |
    Then I should have a list updated with:
      | name | MoBileTest |
