Feature: Test one's Web front end automation skills

  In order to demonstrate my web from end automation skills
  As a job seeker
  I need to write a robust and maintainable tests to prove

  @browser_skills
  Scenario Outline: Verify WikiPedia search functionality.
    Given I navigate to "http://www.wikipedia.org/"
    When I search for "<SearchTerm>" in "<Language>" language
    Then I should see first heading "<SearchTerm>" in results page
    And the language should be "<Language>"
    And a link to English language is included

    Examples:
      | SearchTerm | Language |
      | Berlin     | Deutsch  |
      | Paris      | Français |