Feature: Delete User

@Tugas
Scenario: Delete user with invalid id
Given Delete user with invalid "dua"
When Send request delete user
Then Status code should be 400
