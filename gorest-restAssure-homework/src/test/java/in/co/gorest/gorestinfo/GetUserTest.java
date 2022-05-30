package in.co.gorest.gorestinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest extends TestBase {
    @Test
    public void GetListOfUser() {
        Response response = given().log().all()
                .header("page",1)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
