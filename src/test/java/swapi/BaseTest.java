package swapi;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    @Before
    public void Setup() {
        RestAssured.baseURI = "https://swapi.co/api";
    }

    @After
    public void Teardown() {
        RestAssured.baseURI = "";
    }
}
