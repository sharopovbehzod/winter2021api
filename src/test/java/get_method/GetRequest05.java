package get_method;
import static io.restassured.RestAssured.*;
import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetRequest05 extends HerokuappBaseUrl {
    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  		Among the data there should be someone whose first name is “Mark” and last name is “Ericsson”
     */

    @Test
    public void get01(){

        spec.
                pathParam("first","booking").
                queryParams("firstname","Eric",
                       "lastname", "Brown");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

/*
 path parameters starts with /
	query parameter starts with ?

	2. path parameters ==> don't use key value structure
	the query parameter uses key value structure

	3. multiple path parameters uses  /
	but in query parameters uses =

	4) when you use base URL it means you have huge data
	path parameter makes the data smaller
	query parameter specializes the data inside the path parameter (to filter the recourses)
 */
    response.then().assertThat().statusCode(200);
    assertTrue(response.asString().contains("bookingid"));

    }



}
