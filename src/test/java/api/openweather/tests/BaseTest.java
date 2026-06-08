package api.openweather.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {

        String baseUrl = ConfigReader.getProperty("baseUrl");
        String apiKey = ConfigReader.getProperty("apiKey");

        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
        RestAssured.filters(new AllureRestAssured());
    }
}


