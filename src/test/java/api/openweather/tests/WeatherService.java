package api.openweather.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherService {

    public static Response getWeatherByCity(String cityName) {
        return RestAssured
                .given()
                .queryParam("q", cityName)
                .filter(new AllureRestAssured())
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .when()
                .get("/weather");
    }

    public static Response getWeatherWithoutParameters() {
        return RestAssured
                .given()
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .when()
                .get("/weather");
    }

    public static Response getWeatherWithInvalidParameters(String invalidCity) {
        return RestAssured
                .given()
                .queryParam("q", invalidCity)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .when()
                .get("/weather");
    }

    public static Response getWeatherByCoordinates(double lat, double lon) {
        return RestAssured
                .given()
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityWithUnits(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityWithInvalidUnits(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("units", "mettrik")
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityEmptyUnit(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("units", "")
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityUnitMissing(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityApiKeyMissing(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .get("/weather");
    }

    public static Response getWeatherByCityApiKeyInvalid(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("appid", "invalidKey")
                .get("/weather");
    }


    public static Response getWeatherByCityCityNumeric(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityCitySpecialCharacters(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityInvalidLang(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("lang", "fsdfds")
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByCityUnitsImperial(String city) {
        return RestAssured
                .given()
                .queryParam("q", city)
                .queryParam("units", "imperial")
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }

    public static Response getWeatherByZip(String zip) {
        return RestAssured
                .given()
                .queryParam("zip", zip)
                .queryParam("appid", ConfigReader.getProperty("apiKey"))
                .get("/weather");
    }
}

