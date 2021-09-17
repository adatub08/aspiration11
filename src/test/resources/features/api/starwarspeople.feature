@SwapiPeopleFeature
Feature: Star Wars

  Scenario: Get all people
    When all people are requested
    Then a status code 200 is returned
    And total 82 peoples are returned
    And total number of people where height is greater than 200 equals to 1
    And "individuals" are returned
