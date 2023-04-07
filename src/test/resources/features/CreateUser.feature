
Feature: To create a new employee

  @createNewEmployee
  Scenario Outline: To create new employee
    Given user is valid user and has access to endpoint
    When user creates a employee by calling endpoint "/Users"
     |createddate   | firstname   | lastname   | phone   | email   | city   | state   | gender   | hiredate  | Onleave|
     |<createddate> | <firstname> | <lastname> | <phone> | <email> | <city> | <state> | <gender> | <hiredate>| <Onleave>|
    Then user should get the status code 201
    And the response should be as per schema "createEmployeeSchema.json"
    And validate the JSON Response
    

    Examples: 
     |createddate | firstname | lastname | phone        | email         | city  | state  | gender |hiredate 				|Onleave|
     |4/6/2023    | John      | Doe      | 264-783-9453 | John@test.com | city1 | state1 | Male   |2025-10-31T16:35:45.426Z |true |
     
     @GetEmployee
  Scenario Outline: To get the employee details
    Given user is valid user and has access to endpoint
    When user wants to get employee id "358" by calling endpoint "/Users"     
    Then user should get the status code as 200
    And the response should be same as schema "getEmployeeSchema.json"
    And validate the JSON Response has expected data
    |createddate   | firstname   | lastname   | phone   | email   | city   | state   | gender   | hiredate  | Onleave|
    |<createddate> | <firstname> | <lastname> | <phone> | <email> | <city> | <state> | <gender> | <hiredate>| <Onleave>|
    

    Examples: 
     |createddate | firstname | lastname | phone        | email         | city  | state  | gender |hiredate 				|Onleave|
     |4/6/2023    | John      | Doe      | 264-783-9453 | John@test.com | city1 | state1 | Male   |2025-10-31T16:35:45.426Z |true |
     

   
     
     