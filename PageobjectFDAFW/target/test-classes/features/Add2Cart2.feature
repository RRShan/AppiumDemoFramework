Feature: Add an item to cart2

In Order to add an item
As a user
I want to Enter details

Scenario Outline: Add an item from kitchen department

Given user is in the department page
When user select <checkbox> checkbox and select an item
And click on add2cart button
Then an should be sucessfully added to cart
Examples:
|checkbox|
|furniture|
|movie|
|automative|

#Scenario: Add an item from movie department
#Given user is in the department page
#When user select "movie" checkbox and select an item
#And click on add2cart button
#Then an should be sucessfully added to cart
#
#Scenario: Add an item from toys department
#Given user is in the department page
#When user select "automative" checkbox and select an item
#And click on add2cart button
#Then an should be sucessfully added to cart