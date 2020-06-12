@cleanDataApi
Feature: Cards context.

  Background: Create a board with lists and a card
    Given I authenticate as "user1"
    And I create a board with:
      | name | Juan Party |
    And I create a list with:
      | name    | In progress |
      | idBoard | {board.id}  |
    And I create a list with:
      | name    | Tasks      |
      | idBoard | {board.id} |
    And I create a card with:
      | name   | Especial task |
      | idList | {list.id}     |

  Scenario Outline: Drags and drops card
    Given I log in with my Trello account as "user1"
    And I select "Juan Party" board
    When I move "Especial task" card from "<Source>" to "<Target>"
    Then I should have a card on "In progress" list with:
      | name | Especial task |

    Examples:
      | Source | Target      |
      | Tasks  | In progress |
