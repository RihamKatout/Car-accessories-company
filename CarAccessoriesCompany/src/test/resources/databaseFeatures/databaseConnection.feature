Feature: Connecting to a given database

  Scenario: Successful connection
    When I want to connect to database
    And I fill in 'port' with '3306'
    And I fill in 'databaseName' with 'caraccessoriescompany'
    And I fill in 'username' with 'root'
    And I fill in 'password' with '12345678password'
    Then he should see "Connected to the database successfully"

  Scenario: Failure connection
    When I want to connect to database
    And I fill in 'port' with '3300'
    And I fill in 'databaseName' with 'invalidName'
    And I fill in 'username' with 'invalidRoot'
    And I fill in 'password' with 'invalidPassword'
    Then he should see "Couldn't connect to the database"