@API
Feature: Airport Gap API Testing

Scenario: Verify Airport Count
Given airports URI is set
When airports end point is approached
Then the response contains exactly 30 airports

Scenario: Verify Specific Airports
Given airports URI is set
When airports end point is approached
Then specific airports will be present
      | Akureyri Airport     |
      | St. Anthony Airport  |
      | CFB Bagotville       |

Scenario: Verify Distance Between Airports
Given distance endpoint is not null
When send a POST request to the distance endpoint
Then distance between these airports is greater than 400 km
