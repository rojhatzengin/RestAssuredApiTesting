package swapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class PeopleTest extends BaseTest {

    @Test
    public void GetPeopleSchema() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/people/schema")
                .then()
                    .statusCode(200)
                    .body("description", CoreMatchers.equalTo("A person within the Star Wars universe"))
                    .body("title", CoreMatchers.equalTo("People"));
    }

    @Test
    public void GetAllPeople() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/people")
                .then()
                    .statusCode(200)
                    .body("count", CoreMatchers.equalTo(87));
    }

    @Test
    public void GetPeopleLuke() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/people/{id}", 1)
                .then()
                    .statusCode(200)
                    .body("name", CoreMatchers.equalTo("Luke Skywalker"))
                    .body("gender", CoreMatchers.equalTo("male"))
                    .body("height", CoreMatchers.equalTo("172"));
    }

}
