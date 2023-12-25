Feature: To Modify User
  @Tugas
  Scenario Outline: Modify user with valid id and json
    Given Modify user with valid <id> and "<json>"
    When Send request modify user
    Then Status code should be 200
    And Response body name was "<name>" and job was "<job>"
    And Validate modify user json schema "ModifyUserSchema.json"
    Examples:
      | id | json             | name                 | job         |
      | 1  | ModifyUser.json  | Andreas Firdaus Edit |             |
      | 2  | ModifyUser2.json |                      | SQA          |

  @Tugas
  Scenario Outline: Modify user with invalid id and json
    Given Modify user with invalid "<id>" and "<json>"
    When Send request modify user
    Then Status code should be 404
    Examples:
      | id | json            |
      | %  | ModifyUser.json |
