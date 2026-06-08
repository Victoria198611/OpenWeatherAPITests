package api.openweather.tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

@Epic("Weather API")
@Feature("Negative Scenarios")
public class WeatherNegativeTests extends BaseTest {


    @Test
    @Story("Get weather with invalid city")
    @Description("Verify that the API returns error response when an invalid city is provided.")
    @Severity(SeverityLevel.NORMAL)
    public void getWeatherTestInvalidCity() {

        //SEND post request
        Response response = WeatherService.getWeatherByCity("Lowendon");

        //Validate status code
        response.then().statusCode(404);
        response.then().body("message", equalTo("city not found"));
    }

    @Test
    public void getWeatherByCityApiKeyMissing() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityApiKeyMissing("London");
        //Validate status code
        response.then().statusCode(401);
        response.then().body("message", equalTo("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
    }

    @Test
    public void getWeatherTestWithoutParameters() {

        //SEND post request
        Response response = WeatherService.getWeatherWithoutParameters();

        //Validate status code
        response.then().statusCode(400);
        response.then().body("message", equalTo("Nothing to geocode"));
    }

    @Test
    public void getWeatherTestWithInvalidParameters() {

        //SEND post request
        Response response = WeatherService.getWeatherWithInvalidParameters("L0nd0n");

        //Validate status code
        response.then().statusCode(404);
        response.then().body("message", equalTo("city not found"));
    }

    @Test
    public void getWeatherByCityApiKeyInvalid() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityApiKeyInvalid("London");

        //Validate status code
        response.then().statusCode(401);
        response.then().body("message", equalTo("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."));
    }


    @Test
    public void getWeatherByCityCityNumeric() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityCityNumeric("99999");

        //Validate status code
        response.then().statusCode(404);
        response.then().body("message", equalTo("city not found"));
    }

    @Test
    public void etWeatherByCityCitySpecialCharacters() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityCitySpecialCharacters("@#$%^&*");

        //Validate status code
        response.then().statusCode(404);
        response.then().body("message", equalTo("city not found"));
    }
}