@acceptance
Feature: list interactions

  Background: Set the authentication
    Given I authenticate as "user2"
    And I create a "board" with:
      | name | ShareMobile |
    And I invite a member by setting its type with:
      | user2 | admin |
    And I create a "list" with:
      | name    | toShare    |
      | idBoard | {board.id} |

  @cleanData
  Scenario: updating a list from other account
  This scenario works when the mobile device uses the step of authentication
  but if it uses Google Play the log in step with the guest user will be skipped.
    Given I log in with my Trello account as "user1"
    And I select "ShareMobile" board
    When I update the "toShare" List with:
      | name | MoBileTest |
    Then I should have a list updated with:
      | name | MoBileTest |
