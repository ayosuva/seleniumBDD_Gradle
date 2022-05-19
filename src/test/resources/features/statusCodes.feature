@statuscodes
Feature: HTTP status codes
  Scenario Outline: Check '<someText>' status HTTP status codes
    Given A User Navigates to StatusCodes Page
    When A User Clicks on status Code <input>
    Then Application displays the message <outputCode>
    And Application displays the mess '<someText>'
    Examples:
      | input | outputCode |someText  |
      | 200   | 200        |Admin     |
      | 301   | 301        |Manager   |
      | 404   | 404        |User      |

