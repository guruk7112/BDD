Feature: RFQ event details section

Background:
Given Buyer successfully loggedin
And clicks on CreateButton
And select the rfq from the options
When buyer clicks on create from blank
Then the event details section should be displayed


Scenario: verify urgent event
Given when the buyer scroll to event settings section
When buyer clicks on urgent event checkbox
Then the urgen event should be checked   
And uncheck the urgent event checkbox
And the urgent event should be unchecked 


Scenario: verify unmasking owner checkbox
Given when the buyer scroll to event settings section
When buyer clicks on unmasking owner checkbox
Then the unmasking owner should be checked



Scenario: verify unmasking buyer
Given when the buyer scroll to event settings section
When buyer clicks on unmasking owner checkbox
Then input field should be enabled
And buyer can enter the unmasking owner name "intel"
And select the option from the dropdown
And the unmasking owner should be displayed in the input field
And uncheck the unmasking owner checkbox
And input field should be disabled

@Exampls
Scenario Outline: verify unmask error message
Given when the buyer scroll to event settings section
When buyer clicks on unmasking owner checkbox
And the unmasking owner should be checked "<action>"
And click on next button at the bottom of the page
Then it should display as "<message>"
Examples:
| action | message |
| true  |  This is a required field |
| false | |



