Feature: Test one's programming skills

  In order to demonstrate my programming skills
  As a job seeker
  I need to write an effective program for the task given

  @programming_skills
  Scenario Outline: Calculate the length of the longest ordered array in an onordered array
    Given I have unordered array <Array>
    When I calculate length of the longest ordered array
    Then the result should be <Result>
    Examples:
      | Array                              | Result |
      | 1, 4, 1, 4, 2, 1, 3, 5, 6, 2, 3, 7 | 4      |
      | 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5    | 3      |
      | 2, 7, 1, 8, 2, 8, 1                | 2      |