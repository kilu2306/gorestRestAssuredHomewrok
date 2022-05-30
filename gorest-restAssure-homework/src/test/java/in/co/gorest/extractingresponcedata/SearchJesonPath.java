package in.co.gorest.extractingresponcedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJesonPath {
    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given().log().all()
                .header("page",1)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    @Test
    public void verifyTotalRecord() {

        int ids=response.extract().path("body.size()");
       System.out.println("all recrod "+ids);
    }
    @Test
    //2] to verify id  3261 has name =Sukanya Varma
    public void verifyUserName(){

        String  name =response.extract().path("find{it.id==3261}.name");
        System.out.println("Id 3269 has name:"+ name);

    }
    @Test
    //3].to verify id 3268has email =jain_girika@littel.co"
    public void  verifyEmail(){


        String  email=response.extract().path("find{it.id==3268}.email");
        System.out.println("id 3268 has :" +email);

    }
@Test
//4]All ID has status = active
    public void findStatus(){

 List<String> allStatus=response.extract().path("findAll{it.status=='active'}");
    System.out.println(" record of active status :"+ allStatus);
}
//5].id 3259 has gender = female
    @Test
    public void verifyGender(){

        String gender=response.extract().path("find{it.id==3261}.gender");
        System.out.println("id 3266 has :"+ gender);
    }

}
