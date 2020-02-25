Feature: Login

  As an individual person
  I want to login UBS account

  Scenario: Invalid Login
    Given I open UBS site
    When I navigate to login as "UBS Quotes"
    And I enter contact number as "invalid"
    Then I should see error message

  Scenario: Protection from invalid mobile
    Given I open UBS site
    When I navigate to login as "Investment Bank Client Portal"
    And I login with email "adjfd@dkdsf.com"
    And I try activation with three digit of phone as "123"
    Then I should see error as details not matched

