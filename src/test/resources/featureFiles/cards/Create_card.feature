@cleanDataApi
Feature: Cards context.

  Background: Create a board and a list
    Given I authenticate as "user1"
    And I create a board with:
      | name | GUI |
    And I create a list with:
      | name    | Tasks      |
      | idBoard | {board.id} |

  Scenario: Create a card
    Given I log in with my Trello account as "user1"
    And I select "GUI" board
    When I create a card on "Tasks" list with:
      | name | First task |
    Then I should have a card on "Tasks" list with:
      | name | First task |
