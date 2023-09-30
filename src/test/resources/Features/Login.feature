#Author: your.email@your.domain.com
#Keywords Summary :
Feature: Login Functionality
  As a user
  I want to log in to the application
  So that I can access my account
  Scenario: Successful Login
    Given I am on the login page
    When I enter valid credentials
    And I click on the login button
    Then I should be logged in successfully


