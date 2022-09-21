import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public interface IRestAssuredTest {



    @BeforeSuite
    public static void setup() {};

    @AfterSuite
    public static void teardown() {}



}
