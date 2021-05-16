package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    // 1).Create RequestSpecification object
    protected RequestSpecification spec;


    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();
    }

}
