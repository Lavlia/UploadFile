Feature: Check the functionality of the upload feature
  As an user
  I want to upload a file on the site
  So that i can store it

  Background:
    Given User is on Website demo.guru99.com
    When User clicks on “Selenium” field from main menu
    And User selects “File Upload” from the drop down

  Scenario: Check the response on uploading a file with valid size and all the required field are filed
    When User choose a file from his/her device
    And User checks the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should see the success message

  Scenario: Check the response on uploading a file with valid size and the required field are not filed
    When User choose a file from his/her device
    And User did not check the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should not see the success message

  Scenario: Check the response on uploading a file with invalid size and the required fields are filed
    When User choose a file from his/her device with invalid size
    And User checks the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should not see the success message

  Scenario: Check the response on uploading a file with invalid size and the required fields are not filed
    When User choose a file from his/her device with invalid size
    And User did not check the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should not see the success message

  Scenario: Check the response on uploading a file where user did not choose a file from his/her device and the required fields are filed
    When User did not choose a file from his/her device
    And User checks the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should not see the success message

  Scenario: Check the response on uploading a file where user did not choose a file from his/her device and the required fields are not filed
    When User did not choose a file from his/her device
    And User did not check the checkbox for “I accept terms of service”
    And User press the “Submit File” button
    Then User should not see the success message