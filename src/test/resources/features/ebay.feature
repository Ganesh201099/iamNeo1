Feature: BDD FRAMEWORK QUESTION CREATION
  @test
  Scenario: Hovering and button clicks
    Given Launch the application
    And Wait until application is loaded completely
    Then Validate the page title
    When Hover on the Electronics section
    And Navigate to Smart home category
    Then Validate that Smart home category screen is displayed
    And Validate the number of results available

    And Navigate to profile screen

    @test
  Scenario Outline: Hovering, entering values in a input box and Button clicks
    Given Navigate to home page
    And Wait until application is loaded completely
    Then Validate the page title
    When Hover on the Electronics section
    And Navigate to Smartphones category
    Then Validate that Smartphones category screen is displayed
    And Enter "<Brands>" in search box
    And Click on Search button
    Examples:
      | Brands |
      | Samsung |
      | Apple   |
      | Redmi   |


  Scenario Outline: Hovering, Tab switching and button clicks
    Given Navigate to home page
    And Wait until application is loaded completely
    Then Validate the page title
    When Hover on the Electronics section
    And Navigate to Smartphones category
    Then Validate that Smartphones category screen is displayed
    And Enter "<Brands>" in search box
    And Click on Search button
    And Switch to New tab

    Examples:
      | Brands |
      | Motorola |
      | Apple   |