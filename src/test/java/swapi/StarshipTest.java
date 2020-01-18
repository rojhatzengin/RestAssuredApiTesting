package swapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class StarshipTest extends BaseTest {

    @Test
    public void GetPlanetSchema() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/starships/schema")
                .then()
                    .statusCode(200)
                    .body("description", CoreMatchers.equalTo("A Starship"))
                    .body("title", CoreMatchers.equalTo("Starship"));
    }

    @Test
    public void GetAllStarships() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/starships")
                .then()
                    .statusCode(200)
                    .body("count", CoreMatchers.equalTo(37));
    }

    @Test
    public void GetStarshipCorvette() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/starships/{id}", 2)
                .then()
                    .statusCode(200)
                    .body("name", CoreMatchers.equalTo("CR90 corvette"))
                    .body("manufacturer", CoreMatchers.equalTo("Corellian Engineering Corporation"))
                    .body("MGLT", CoreMatchers.equalTo("60"));
    }

}
