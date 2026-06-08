package api.openweather.tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Epic("Weather API")
@Feature("Positive Scenarios")
public class WeatherPositiveTests extends BaseTest {

    @Test
    @Story("Get current weather by valid city")
    @Description("Verify that the API returns correct weather data when a valid city is provided.")
    @Severity(SeverityLevel.CRITICAL)
    public void getWeatherTest() {

        //SEND post request
        Response response = WeatherService.getWeatherByCity("London");

        //Validate status code
        response.then().statusCode(201);
        response.then().body("name", equalTo("London"));
    }

    @Test
    public void getWeatherByCityWithInvalidUnits() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityWithInvalidUnits("London");

        //Validate status code
        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }

    @Test
    public void getWeatherByCoordinates() {
        Response response = WeatherService.getWeatherByCoordinates(51.51, -0.13);

        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
    }

    @Test
    public void getWeatherByCityUnitMissing() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityUnitMissing("London");

        //Validate status code
        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }
    @Test
    public void getWeatherByCityEmptyUnit() {

        //SEND post request
        Response response = WeatherService.getWeatherByCityEmptyUnit("London");

        //Validate status code
        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }

    @Test
    public void getWeatherByCityWithUnits() {
        Response response = WeatherService.getWeatherByCityWithUnits("London");

        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }

    @Test
    public void getWeatherByCityInvalidLang() {
        Response response = WeatherService.getWeatherByCityInvalidLang("London");

        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }

    @Test
    public void getWeatherByCityUnitsImperial() {
        Response response = WeatherService.getWeatherByCityUnitsImperial("London");

        response.then().statusCode(200);
        response.then().body("name", equalTo("London"));
        response.then().body("main.temp", notNullValue());
    }


    @Test
    public void getWeatherByZip() {
        Response response = WeatherService.getWeatherByZip("94040");

        response.then().statusCode(200);
        response.then().body("name", equalTo("Mountain View"));
        response.then().body("main.temp", notNullValue());
    }
}