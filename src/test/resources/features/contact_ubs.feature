Feature: Get in touch

  As an individual person
  I want to contact UBS with my query

  Scenario: Get in touch with a request
    Given I open UBS site
    And I specify below information:
      | domicile | country | language |
      | EU       | Austria | EN       |
    When I clicked on contact menu
    And I select contact us option from the list
    And I fill request using option number with request as "sample req":
      | How can we help you? | My investible assets |
      | 1                    | 2                    |
    And I enter my details:
      | title | First name | Last name | City  | Email         | Country   |
      | Mr    | First      | Last      | Dubai | asdf@sdfj.com | Australia |
    And I confirm terms and conditions
    And I submit the request
    Then I should see the confirmation screen
    And I should see successful submission message
    And I close the browser

