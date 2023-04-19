Feature: As user i want to see detail of user

  @User
  Scenario: as user i want to get detail user by id
    Given user has endpoint
    When user get detail by id
    Then user get status code 200
    And user validate response body