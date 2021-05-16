package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    // 1).Create RequestSpecification object
    protected RequestSpecification spec;

    //If you use @Before annotation before the mnethod it means the method will be executed before every test method
    /*
    When writing tests, it is common to find that several tests need similar objects created before they can run.
    Annotating a public void method with @Before causes that method to be run before the Test method.
    The @Before methods of superclasses will be run before those of the current class,
    unless they are overridden in the current class. No other ordering is defined.
     */
    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
