Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initalize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/"
And click on login link in home page to land in sign in page
When User enters <username> and <Password> and logs in
Then verify that user is successfully logged in
And Close browser

Examples:
|username 			|Password   |
|test99@gmail.com 	|123456		|
|test12@gmail.com	|1234		|