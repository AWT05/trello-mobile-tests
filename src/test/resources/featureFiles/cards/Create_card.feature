@cleanDataApi
Feature: Cards context.

  Background: Create a board and a list

  Scenario: Create a card
    Given I authenticate as "user1"
    And I create a board with:
      | name | GUI |
    And I create a list with:
      | name    | to do      |
      | idBoard | {board.id} |

  Scenario: Create a card into a Team
    Given I authenticate as "user1"
    And I create an organization with:
      | displayName | AWT05GUI |
    And I create a board with:
      | name           | GUI               |
      | idOrganization | {organization.id} |
    And I create a list with:
      | name    | Members tasks |
      | idBoard | {board.id}    |