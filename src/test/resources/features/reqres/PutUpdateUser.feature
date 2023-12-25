Feature: Update User

@Tugas
Scenario Outline: Update user with valid id and invalid json
Given Update user with valid id <id> and invalid name json "<json>"
When Send request update user
Then Status code should be 404
And Response body name was "<name>"
And Validate update user json schema "UpdateUserSchema2.json"
Examples:
|id| json             |name                  |
|1 | UpdateUser3.json |1                     |
