package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class GetRequest08 extends JsonPlaceHolderBaseUrl {




    /*
    When
	  		I send GET Request to https://jsonplaceholder.typicode.com/todos/2
	  Then
	  		Status code is 200
	  		And “completed” is false
	  		And “userId” is 1
	  		And “title” is “quis ut nam facilis et officia qui”
	  		And header “Via” is “1.1 Vegur”
	  		And header “Server” is “cloudflare”
     */

    @Test
    public void get01(){
        spec.pathParams("first","todos",
                        "second",2);
        //2) Set the expected data
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("statusCode",200);
        expectedDataMap.put("completed",false);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");

        //3. Send the request

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

       assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),actualDataMap.get("Server"));






    }





}
