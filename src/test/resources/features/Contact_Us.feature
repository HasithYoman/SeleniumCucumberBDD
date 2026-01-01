@contact_us
Feature: WebDriver University - Contact Us Page

  Background:
    Given I access the webdriver university contact us page



  Scenario: Validate Successful Submission - Unique data   //use gerking to map out the test scenario
    When I enter unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submision message


  Scenario: Validate Successful Submission - Specific data
    When I enter a specific first name joe
    And I enter a specific last name blog
    And I enter a specific email address joe_blogs@Gmail.com
    And I enter a specific comment "How are you"
    And I click on the submit button
    Then I should be presented with a successful contact us submision message