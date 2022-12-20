Feature: Late Book
Scenario: Late book after 21 days
Given that the user with id "3" has borrowed a book with title "XP Programming Book" 
And 21 days have passed 
And the fine for one late book is 30 NIS 
Then the user with id "3" has Late books 
And the user with id "3" has to pay a fine of 30 NIS