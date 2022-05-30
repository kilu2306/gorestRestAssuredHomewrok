package in.co.gorest.gorestinfo;

import in.co.gorest.model.GoRestPoJoForPacth;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserTest extends TestBase {
    @Test
    public void updateUser() {

        GoRestPoJoForPacth goRestPoJoForPacth = new GoRestPoJoForPacth();
        goRestPoJoForPacth.setName("Allasani Peddana");
        goRestPoJoForPacth.setEmail("allasani.peddana57@gmail.com");
        goRestPoJoForPacth.setStatus("active");


        Response response = given()

                .auth().oauth2("291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 291904970ca833dadf57d74c5eb1af568a47ad82f963a134e0620176673e189e")
                .header("Accept", "application/json")

                .body(goRestPoJoForPacth)
                .patch("/users/2677");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
