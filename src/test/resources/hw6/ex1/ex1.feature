Feature: Exercise1

  @run
  Scenario: Home page and Different elements pages test
    Given I am on the JDI Index Page
    Then Browser title shoul be 'Home Page'
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    And Home page should have 4 pictures
    # TODO Could you please introduce full step here?
    # TODO This step could be used in the another scenarios and now it is not clear where should be these text
    And 4 texts under them
        # TODO Could you please introduce full step here?
        # TODO This step could be used in the another scenarios and now it is not clear where should be these text
    And two texts above
    When I click on Service subcategory
    Then Left side menu should have
      | Support | Dates | Complex Table | Simple Table | Table with pages | Different elements |
    When I navigate to Differnt elements page
    Then Differnt elements page should have 4 checkboxes
    And Differnt elements page should have 4 radios
    And Differnt elements page should have dropdown
    And Differnt elements page should have button
    And Differnt elements page should have default button
    And Differnt elements page should have right section
    And Differnt elements page should have left section
    When I select chechboxes
      | Water | Wind |
    # TODO What do you mean under the correct log?
    Then There is an correct log for selected checkboxes
      | Water | Wind |
    When I select 'Selen' radio
    # TODO What do you mean under the correct log?
    Then There is corect log for 'Selen' radio
    When I select 'Yellow' color from dropdown
    # TODO What do you mean under the correct log?
    Then There is correct log for selected 'Yellow' color
    When I unselected checkboxes
      | Water | Wind |
    # TODO What do you mean under the correct log?
    Then There is an correct log for unselected checkboxes
      | Water | Wind |