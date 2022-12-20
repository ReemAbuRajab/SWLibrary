Feature: Return Book
Actors: user 

Scenario: Successful return Book
Given that the user with id "3" is regestered 
And  the user borrowed the book with title "XP Programming Book "
When the user return the book with title "XP Programming Book "
Then the user not borrowed the book with title "XP Programming Book "


Scenario: Fail return Book
Given that the user with id "3" is regestered 
And the user is not borrowed the book with title "XP Programming Book "
When the user return the book with title "XP Programming Book "
Then error message "this book is not borrowed by you"  should be display