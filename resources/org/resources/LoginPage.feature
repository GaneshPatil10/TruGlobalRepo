Feature: Login Page Feature

Scenario: Validate login page
Given User is on login page
Then Username field is displayed
And Password field is displayed
And Login field is displayed
And Keep me login check box is displayed
And Actitime logo is displayed
And Login page is displayed as "actiTIfhME - Login"
And Login page URL is displayed as "http://localhost:90/login.do"

Scenario: Login successfully
Given User is on login page
When User enters username  
And User enters password
And Clicks on login button
Then Dashboard page title is displayed as "actiTIME - Enter Time-Track"
And Dashboard URL is displayed as "http://localhost:90/ user/submit_tt.do"