Feature: Login user

  @Tugas
    Scenario: Post login successful user with valid json
    Given Post login successful user with valid json "LoginSuccessful.json"
    When Send request post login successful
    Then Status code login successful should be 200
    And Validate post login successful user json schema "LoginSuccessfulSchema.json"

  @Tugas
  Scenario: Post login unsuccessful user with invalid json
    Given Post login unsuccessful user with invalid json "LoginUnsuccessful.json"
    When Send request post login unsucessful
    Then Status code login unsuccessful should be 400
    And Validate post login unsuccessful user json schema "LoginUnsuccessfulSchema.json"