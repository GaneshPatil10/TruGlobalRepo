Feature: User Registration on Amazon

  Scenario: Validate Registration page
    Given the user is on the Amazon registration page
   	Then registration page title is displayed as "Amazon Registration" 
   	And your name field is displayed
   	And Mobile number field is displayed
   	And Email field is displayed
   	And Password field is displayed
   	And Verify Mobile Number button is displayed
   	
  Scenario: Register a new user on Amazon 	
  	Given the user is on the Amazon registration page
  	When user enters First and Last name as "Ganesh Patil"
  	And user enters mobile number
  	And user enters Email
  	And user enters password 
  	And click on Verify Mobile Number button
  	And wait until puzzle solve
  	#Solve Puzzle manually
  	And user enters OTP
  	#Enter OTP Manually
  	And click on Create your Amazon account option
   	
   	
