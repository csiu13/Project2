Feature: login

  Scenario Outline: 
    Given the user navigates to the batch tab
    When the user inputs <core>, <start date>, <trainer>, <co-trainer>, <location>, <building>, and <room>
    And the user clicks the cancel button
    Then the program should clear all fields

    Examples: 
      | core   | start date | trainer  | co-trainer | location      | building  | room |
      | "Java" | "today"    | "August" | "Yuvi"     | "Revature"    | "HQ"      |  214 |
      | "Java" | "today"    | "Yuvi"   | "Peter"    | "Capital One" | "Chicago" |  208 |
      | "Net"  | "today"    | "Yuvi"   | "Yuvi"     | "Capital One" | "HQ"      |  208 |
      | "Net"  | "today"    | "Peter"  | "Peter"    | "Revature"    | "HQ"      |  214 |
      | "Net"  | "today"    | "Yuvi"   | "August"   | "Capital One" | "Chicago" |  208 |
