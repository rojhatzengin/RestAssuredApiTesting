package swapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class PlanetTest extends BaseTest {

    @Test
    public void GetPlanetSchema() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/planets/schema")
                .then()
                    .statusCode(200)
                    .body("description", CoreMatchers.equalTo("A planet."))
                    .body("title", CoreMatchers.equalTo("Planet"));
    }

    @Test
    public void GetAllPlanets() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/planets")
                .then()
                    .statusCode(200)
                    .body("count", CoreMatchers.equalTo(61));
    }

    @Test
    public void GetPlanetTatooine() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/planets/{id}", 1)
                .then()
                    .statusCode(200)
                    .body("name", CoreMatchers.equalTo("Tatooine"))
                    .body("terrain", CoreMatchers.equalTo("desert"))
                    .body("population", CoreMatchers.equalTo("200000"));
    }

}
