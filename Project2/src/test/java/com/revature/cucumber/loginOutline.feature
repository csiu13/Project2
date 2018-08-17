Feature: login

  Background: 
    User navigates to Assignforce homepage Given
    user is on login page


  Scenario Outline: 
    Given the application is opened
    When valid <username> and <password> are entered
    And the user clicks the login button
    Then the user should be able to gain access to the application
    

    Examples: 
      | username                    | password   |
      | "svp@revature.com"          | "p@$$w0rd" |
      | "test.trainer@revature.com" | "p@$$w0rd" |
