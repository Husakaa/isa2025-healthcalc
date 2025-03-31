@tag
Feature: Ideal Weight Computation
  As a user I want to compute my ideal weight so that to be aware about my health condition

  @tag1
  Scenario Outline: Computing my ideal weight
    Given I have a health calculator
	And a height of 165 cm
	And a female gender
    When I compute the ideal weight
    Then The system returns 59 kg

    Examples:
      | height |  gender |  Ideal Weight   |
      |  175   |   'M'   |      68.75      |
      |  160   |   'F'   |      56.00      |
      |  180   |   'M'   |      72.50      |
      |  165   |   'F'   |      59.00      |
      |  170   |   'M'   |      66.25      |
      |  155   |   'F'   |      53.00      |


@tag2
  Scenario Outline: Negative height
    Given I have a health calculator
	And a negative height -170 cm
	And a male gender
    When I compute the ideal weight
    Then The system throws an error of invalid parameter


    Examples:
      | height  |  gender | 
      |  -175   |   'M'   |        
      |  -160   |   'F'   |       
      |  -180   |   'M'   |    
      |  -165   |   'F'   |    
      |  -170   |   'M'   | 
      |  -155   |   'F'   |


@tag3
  Scenario Outline: Out of range height
    Given I have a factorial calculator
	And a height of 300 cm
	And a male gender
    When I compute the ideal weight
    Then The system throws an error of invalid parameter


    Examples:
      | height |  gender | 
      |  300   |   'M'   |        
      |  100   |   'M'   |       
      |  300   |   'F'   |    
      |  100   |   'F'   |    
         





