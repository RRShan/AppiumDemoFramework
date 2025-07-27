Feature: validate GoogleMap API

Scenario: verify if place is being sucessfully adding using AddplaceAPI

Given Add place payLoad
When user calls AddplaceAPI with POST http request
Then the API call got sucessful with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"