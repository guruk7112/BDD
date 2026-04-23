@login
Feature: login to the application
#ash to add comments in python and javascript and cucumber
Scenario: buyer login to the application successfully
Given i am on the login page
When i enter valid username and password
| 1CLOUDHUB@PH.COM | 1Cloud@1233 |
And clicking on the login button
Then user should be successfully logged in