package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

/*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        And Content type is “application/JSON”
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
           for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English ""wordpress.jpg"" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */
@Test
    public void get02(){

    String url="https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";

    Response response = given().
            accept("application/json").
            when().
            get(url);

    response.prettyPrint();

    response.
            then().
            assertThat().
            statusCode(200).
            contentType("application/json");
           /* id("608bb976c9e4a800151ab367").
            code("WP100").
            image("wordpress.jpg").
            title("Wordpress").
            shortDescription("Wordpress in nasıl kullanılacağını öğreneceğiz");
*/

}





}
//what do you think what would be the reason of the test to run without completion after running ?