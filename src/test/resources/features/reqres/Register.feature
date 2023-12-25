Feature: Register User

  @Tugas
  Scenario: Register successful
    Given Post register successful user with valid json "RegisterSuccessful.json"
    When Send request post register successful
    Then Status code register should be 200
    And Validate post register successful user json schema "RegisterSuccessfulSchema.json"

  @Tugas
  Scenario Outline: Register unsuccessful
    Given Post register user with invalid json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Validate register user json schema "UnregisterSchema.json"
    Examples:
      | json                       |
      | RegisterUnsuccessful2.json |
      | RegisterUnsuccessful3.json |

  @Tugas
  Scenario: Register unsuccessful
    Given Post register successful user with valid json "RegisterUnsuccessful.json"
    When Send request post register unsuccessful
    Then Status code register should be 400
    And Validate post register successful user json schema "RegisterUnsuccessfulSchema.json"
