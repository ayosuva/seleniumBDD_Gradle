@google
Feature: Test Google

  Scenario: Search something in google
    Given Navigate to google home page
    When A User enters a something
    And A User clicks on search button
    Then Application shows that the search result