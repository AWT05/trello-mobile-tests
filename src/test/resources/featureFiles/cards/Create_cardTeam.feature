@cleanDataApi
Feature: Cards context.

  Background: Create a board and a list
    Given I authenticate as "user2"
    And I create an organization with:
      | displayName | AWT05GUI |
    And I create a board with:
      | name           | Mobile test       |
      | idOrganization | {organization.id} |
    And I create a list with:
      | name    | Tasks      |
      | idBoard | {board.id} |

  Scenario: Create a card
    Given I select "Mobile test" board
    When I create a card on "Tasks" list with:
      | name | First task |
    Then I should have a card on "Tasks" list with:
      | name | First task |



