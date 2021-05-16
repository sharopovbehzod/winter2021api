package get_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class GetRequest06 extends HerokuappBaseUrl {
/*
When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5
	  Then
		  HTTP Status Code should be 200
		  And response content type is “application/JSON”
		  And response body should be like;
		  { “firstname”: “Sally”,
		    “lastname”: “Ericsson”,
		    “totalprice”: 111,
		    “depositpaid”: false,
		    “bookingdates”: { “checkin”: “2017-05-23",
		                      “checkout”:“2019-07-02" }
		  }
 */

@Test
    public void get01(){
    spec.pathParams("first","booking",
                     "second",5);
    //2Set the expected data

    //3 Send the request

    Response response = given().spec(spec).when().get("/{first}/{second}");
   response.prettyPrint();

   //4 Assert the output
    //1.way:
    /*
    response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("firstname", equalTo("Mark"),
                    "lastname",equalTo("Jones"),
                    "totalprice",equalTo(576),
                    "depositpaid", equalTo(false),
                    "bookingdates.checkin",equalTo( "2020-12-21"),
                     "bookingdates.checkout",equalTo("2021-01-27"));
    */

    JsonPath json = response.jsonPath();
//2.way:
    assertEquals("Status code is not matching",200, response.getStatusCode());
   assertEquals("Content type is not Json","application/json; charset=utf-8",response.getContentType());
    //assertEquals("Firstname is not matching", "Sally",json.getString("firstname"));
  // assertTrue("Lastname is not matching", json.getString("lastname").equals("Jackson"));
 // assertTrue("Total price is not matching", json.getInt("totalprice")==530);
  // assertTrue("Deposit paid is not matching ",json.getBoolean("depositpaid")==false);
   //assertEquals("chekinDate is not matching","2016-08-15",json.getShort("bookingdates.checkin"));
  //assertTrue("Checkouit not matching", json.getString("bookingdates.checkout").equals("2021-01-26"));

    //3.way:
    /*
    Soft assertion(Verification):Execution is not stopped in in failure.
    To use soft assertion we have 3 steps.
     1) Create an object from SoftAssert class
      2) By using the object, use assertEquals(), assertTrue, assertFalse()
      3) DO NOT FORGET to use  "assertAll()" at the end.
     */
   //1Step:Create an object from SoftAssert class
    SoftAssert softAssert = new SoftAssert();

  // 2) By using the object, use assertEquals(), assertTrue, assertFalse()
   // softAssert.assertEquals(json.getString("firstname"), "Sally", "firstname is not matching");
    //softAssert.assertEquals(json.getString("lastname"), "Jones", "lastname is not matching");
   // softAssert.assertEquals(json.getInt("totalprice"), 666, "totalprice is not matching");
    softAssert.assertEquals(json.getString("bookingdates.checkout"), "2021-01-22", "checkout is not matching");
    // 3) DO NOT FORGET to use  "assertAll()" at the end.
    softAssert.assertAll();
//it seems like everyone is learning API))


}





}
