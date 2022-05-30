package in.co.gorest.gorestinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletUserTest extends TestBase {
    @Test
    public void deletUser() {
        Response response = given()
                .auth().oauth2("291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Accept", "application/json")
                .when()
                .delete("/users/2674");

        response.then().statusCode(204);
        response.prettyPrint();

    }
}