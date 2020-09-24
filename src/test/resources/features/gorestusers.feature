Feature: Gorest Users

  @getAllUsers
  Scenario: Get all users
    When all users are requested
    Then a status code 200 is returned
    And 20 users are returned


  # TASK: Create scenarios to create a user, get user details and delete a user

  @createUser
  Scenario: Create user
    When the following user is created
      | name     | email              | status | gender |
      | John Doe | john.doe3@gmail.com | Active | Male   |
    Then a status code 200 is returned
    And the following user is returned
      | name     | email              | status | gender |
      | John Doe | john.doe3@gmail.com | Active | Male   |

