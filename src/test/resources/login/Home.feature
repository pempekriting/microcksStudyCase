@Home

Feature: Home Page

  Scenario: Login with valid credentials
    Given the user is already on the Microcks page
    When the user search "CLI" in the documentation
    And the user click "NATS Mocking and Testing" documentation on the list
    Then the user should navigate to the "NATS Mocking and Testing" documentation page
    And the URL should be correct