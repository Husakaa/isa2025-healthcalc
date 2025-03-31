@tag
Feature: Basal metabolic ratio computation
  As a user I want to compute my basal metabolic ratio to know how many calories my body needs at rest and thus better manage my diet and physical condition.


@tag1
Scenario Outline: Basal metabolic ratio computation
  Given I have a health calculator
      And a weight of 70 kg
      And a height of 175 cm
      And an age of 30 years
      And a male gender
  When I compute the basal metabolic rate
  Then The system returns 1695.36 kcal/day

  Examples:
    | weight | height | age | gender | BMR (kcal/day) |
    |   70   |  175   | 30  |   'M'  |     1695.36    |
    |   60   |  160   | 25  |   'F'  |     1388.10    |
    |   80   |  180   | 40  |   'M'  |     1796.36    |
    |   50   |  155   | 20  |   'F'  |     1302.10    |


@tag2
Scenario Outline: Out of range weight
  Given I have a health calculator
      And a weight of 300 kg
      And a height of 175 cm
      And an age of 30 years
      And a male gender
  When I compute the basal metabolic rate
  Then The system throws an error of invalid parameter 

  Examples:
    | weight | height | age | gender |
    |   300  |  175   | 30  |   'M'  |
    |    3   |  160   | 25  |   'F'  |

@tag3
Scenario Outline: Out of range height 
  Given I have a health calculator
      And a weight of 70 kg
      And a height of 100 cm
      And an age of 30 years
      And a male gender
  When I compute the basal metabolic rate
  Then The system throws an error of invalid parameter

  Examples:
    | weight | height | age | gender |
    |   70   |   100  | 30  |   'M'  |
    |   55   |   250  | 22  |   'F'  |


@tag4
Scenario Outline: Out of range age 
  Given I have a health calculator
      And a weight of 70 kg
      And a height of 175 cm
      And an age of 120 years
      And a male gender
  When I compute the basal metabolic rate
  Then The system throws an error of invalid parameter

  Examples:
    | weight | height | age | gender |
    |   70   |  175   |  1  |   'M'  |
    |   60   |  160   | 120 |   'F'  |
    |   80   |  180   | -5  |   'M'  |

@tag5
Scenario Outline: Unknown gender
  Given I have a health calculator
      And a weight of 70 kg
      And a height of 175 cm
      And an age of 30 years
      And an unknown gender
  When I compute the basal metabolic rate
  Then The system throws an error of invalid parameter

  Examples:
    | weight | height | age | gender |
    |   70   |  175   | 30  |   'X'  |
    |   65   |  160   | 28  |   'W'  |
    |   80   |  180   | 35  |   'Y'  |








