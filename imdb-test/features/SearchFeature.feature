Feature: Search Series 
Scenario Outline: Search Series and Get Details 
	Given Navigate to Imdb Home Page 
	When Search '<series>' 
	And Click first result 
	Then Check actual name is equal to '<series>' 
	And Actual year are equal to '<year>' 
	
	Examples: 
		| series | year |
		|The Originals|2013-2018| 
		|Loki|2021-|
		|Gotham|2014-2019|