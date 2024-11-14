@All
Feature: Register
  @Test1 @positive @register
  Scenario: Valid register
  Given User is on parabank homepage
  When User click register link button
  Then User in register page
  When User input name
  And User input address detail
  And User fill valid username
  And User input password confirmation
  When User click register button
  Then User register successfully



  @Test2 @negative @register
  Scenario: Failed register  - Mismatch password
  Given User is on parabank homepage
  When User click register link button
  Then User in register page
  When User input name
  And User input address detail
  And User fill invalid username and password
  And User input password confirmation
  When User click register button
  Then User get error Password did not match



