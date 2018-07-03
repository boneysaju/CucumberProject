#each feature contains one feature 
#feature files contain one language 
Feature: Test the login functionality on sdet university 

#A feature may have given different specific scenarios
#Scenarios use given when then structure

Scenario: The user should be able to log in with correct username and password 
Given user is on the log in page
When user enter correct username and correct password 
Then user gets confirmation 


Scenario Outline: the user should be able to login 
Given user is on the log in page 
When user enters email <username> 
And user enters password <passwords>  
Then user gets confirmation 

Examples: 
| username | passwords |
|tim@testemail.com | trpass |
|rw@testemail.com | rwpass |
|jv@testemail.com | jvpass |
