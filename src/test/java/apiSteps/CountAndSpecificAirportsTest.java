package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * API test - This class covers two scenarios:
 * 1. Fetches the list of airports and verifies the total count.
 * 2. Checks if specific airports exist within the retrieved list.
 */
public class CountAndSpecificAirportsTest {
    private Response response;
    private List<String> airports = new ArrayList<>();

    @Given("airports URI is set")
    public void AirportsURIIsSet() {
        Logger.info("Validating Airports URI");
        Assert.assertNotNull(RestAssured.baseURI, "Base URI is null!!!");
    }

    @When("airports end point is approached")
    public void AirportsEndPointIsApproached() {
        Logger.info("Sending airport request");
        response = RestAssured
                .given()
                .when().get(ConfigReader.getProperty("airportsEndPoint"));

        Assert.assertEquals(response.getStatusCode(), 200, "API request failed!");

        airports = response.getBody().path("data.attributes.name");
    }

    @Then("the response contains exactly {int} airports")
    public void theResponseContainsExactlyXAirports(int expectedNumber) {
        Logger.info("Validating number of airports");
        Assert.assertEquals(airports.size(), expectedNumber,
                "Number of airports does not match! expected: " + expectedNumber + ", actual: " + airports.size() );
    }

    @Then("specific airports will be present")
    public void SpecificAirportsWillBePresent(List<String> expectedAirports) {
        Logger.info("Checking for expected airports: " + expectedAirports);
        Assert.assertTrue(airports.containsAll(expectedAirports),
                "Expected airports not found! expected: " + expectedAirports + ", actual: " + airports);
    }
}//Class