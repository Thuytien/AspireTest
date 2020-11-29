#Author: Thuytien Vo
@test
Feature: Registration feature

  Scenario: Verify that user can registers successfully with valid info
    Given Browse to URL "https://feature-qa.customer-frontend.staging.aspireapp.com/sg/" 
    And Go to Register page
    When User fills in Register Personal form
    And User moves to next step
    When User enters OTP code "1234"
    And User moves to next step
    When User continues with registered business in Singapore
    And User moves to Standard Registration
    And User gets start
    When User fills in Personal Details form
    And User moves to next step
    
    
