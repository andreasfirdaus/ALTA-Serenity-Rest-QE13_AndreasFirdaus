Feature: Get Single User
  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get single user with valid <id>
    When Send request get single user
    Then Status code should be 200
    And Response body id should be <id>
    And Validate get single users json schema "SingleUserSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Get single user with not found id
    Given Get single user with not found <id>
    When Send request get single user
    Then Status code should be 404
    Examples:
      | id  |
      | 100 |
      | 120 |

  @Tugas
  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid "<id>"
    When Send request get single user
    Then Status code should be 404
    Examples:
      | id |
      | %  |
      | !  |

