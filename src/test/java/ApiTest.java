import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    void test1(){
        Response response = RestAssured.get("https://swapi.dev/api/people/10/");

        System.out.println("Response: " + response.asString());
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        System.out.println("Time Elapsed: " + response.getTime());
        System.out.println("Header: " + response.getHeader("content-type"));


//assert with TestNG
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    void  test2(){
        RestAssured.given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }

    @Test
    void  test3(){
        RestAssured.given().
                get("https://reqres.in/api/users?page=3").
                then().
                statusCode(200);
    }
}
