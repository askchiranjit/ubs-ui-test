Feature: Get in touch

  As an individual person
  I want to contact UBS with my query

  Scenario: Get in touch with a request
    Given I open UBS site
    And I specify below information:
      | domicile | country | language |
      | EU       | Austria | EN       |
    When I navigate to contact us from contact menu
    And I fill request using option number with request:
      | How can we help you? | My investible assets |
      | 1                    | 2                    |
    And I enter my details:
      | Title | First name | Last name | City  | Email         | Country   |
      | Mr    | First      | Last      | Dubai | asdf@sdfj.com | Australia |
    And I confirm terms and conditions
    And I submit the request
    Then I should see the confirmation screen

