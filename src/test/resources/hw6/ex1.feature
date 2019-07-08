Feature: Exercise1

  @ex1
  Scenario: Home page and Different elements pages test
    Given I am on the JDI Index Page
    Then Browser title shoul be 'Home Page'
    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    And Home page should have 4 pictures
    # TODO Could you please introduce full step here? (fixed)
    # TODO This step could be used in the another scenarios and now it is not clear where should be these text
    And Home page should hame 4 texts under pictures
        # TODO Could you please introduce full step here? (fixed)
        # TODO This step could be used in the another scenarios and now it is not clear where should be these text
    And Home page should hame two texts above pictures
    When I click on Service subcategory
    Then Left side menu should have
      | Support | Dates | Complex Table | Simple Table | Table with pages | Different elements |
    When I navigate to Differnt elements page
    Then Different elements page should have 4 checkboxes
    And Different elements page should have 4 radios
    And Different elements page should have dropdown
    And Different elements page should have button
    And Different elements page should have default button
    And Different elements page should have right section
    And Different elements page should have left section
    When I select chechboxes
      | Water | Wind |
    # TODO What do you mean under the correct log? (fixed)
    Then Log rows are displayed, checkbox name and its status is corresponding to selected
      | Water | Wind |
    When I select 'Selen' radio
    # TODO What do you mean under the correct log? (fixed)
    Then 'Selen' log row is displayed, radiobutton name and its status is corresponding to selected
    When I select 'Yellow' color from dropdown
    # TODO What do you mean under the correct log? (fixed)
    Then Log row is displayed, dropdown name and selected value 'Yellow' is corresponding to selected
    When I unselected checkboxes
      | Water | Wind |
    # TODO What do you mean under the correct log? (fixed)
    Then Log rows are displayed, checkbox name and its status is corresponding to unselected
      | Water | Wind |