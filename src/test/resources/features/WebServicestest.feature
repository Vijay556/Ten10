Feature: Test one's WebServices automation skills

  In order to demonstrate my web services automation skills
  As a job seeker
  I need to write a robust web Services tests to prove

  @API_skills
  Scenario: Verify WebServices skills.
    Given my endpoint is "http://www.webservicex.net/uklocation.asmx"
    When I invoke it
    Then I should see the success response