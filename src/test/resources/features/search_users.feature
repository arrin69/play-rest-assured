Feature: This feature is written to tests related to endpoint:
  /api/users
  and will also validate the results


  Scenario: Perform get on users endpoint and ensure is not empty or null
    Given I search for users
    Then I must receive more than 90 user