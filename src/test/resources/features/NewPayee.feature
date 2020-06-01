@addNew
Feature: Add new payee under pay bills
  Background:
    Given user is on the login page
    When user logs in with valid credentials

  Scenario: Add a new payee
    Given User navigate to Pay Bills
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name     | The Offices of Burhan Kaya              |
      |Payee Address  | 100 Find ST, Boston, MA 02115           |
      |Account        | Checking                                |
      |Payee details  | Kaya's account                          |
    And click add button
    Then message The new payee The Offices of Burhan Kaya was successfully created.
