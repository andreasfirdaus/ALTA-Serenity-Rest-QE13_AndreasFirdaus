Feature: Delayed User

@Tugas
Scenario Outline:  Get user delayed response with valid param delay
Given Get user delayed response with delay <delay>
When Send request get user delayed response
Then Status code should be 200
Examples:
|delay|
|3    |