package apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Logger;

/**
 * API test - Verifies the distance between two airports.
 * The test sends a POST request to the distance endpoint and asserts that
 * the calculated distance is greater than a given threshold.
 */
public class DistanceVerificationTest {
    private Response response;
    private double foundDistance;

    @Given("distance endpoint is not null")
    public void baseUriIsNotNull() {
        Logger.info("Validating distance API base URI");
        Assert.assertNotNull(RestAssured.baseURI, "Distance endpoint is null!!");
    }

    @When("send a POST request to the distance endpoint")
    public void sendPostRequestToDistanceEndpoint() {
        Logger.info("Sending distance API request");
        response = RestAssured.given()
                .queryParam("from", ConfigReader.getProperty("from"))
                .queryParam("to", ConfigReader.getProperty("to"))
                .when()
                .post(ConfigReader.getProperty("distanceEndpoint"));

        Assert.assertEquals(response.getStatusCode(), 200, "Distance API request failed!");
    }

    @Then("distance between these airports is greater than {double} km")
    public void distanceBetweenAirportsIsGreaterThanKm(double distance) {
        Logger.info("Validating distance calculation");
        foundDistance = response.jsonPath().getDouble("data.attributes.kilometers");

        Logger.info("Received distance: " + foundDistance + " km");
        Assert.assertTrue(foundDistance > distance, "Distance is less than expected!");
    }
}//Class

