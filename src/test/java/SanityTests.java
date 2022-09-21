import com.mindtickle.core.dataprovider.UserDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SanityTests implements IRestAssuredTest{

    public static String baseURI = new String();
    public static long timestamp = 0;

    @BeforeSuite
    public static void setup()
    {
        baseURI = "https://petstore.swagger.io/v2/";
        timestamp = System.currentTimeMillis();
    }

    @AfterSuite
    public static void teardown()
    {

    }


    @Test (description = "Create a new user with current timestamp",
            dataProvider = "user-data-provider",
            dataProviderClass = UserDataProvider.class)

    public static void createUser(Object user){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RequestSpecification request = RestAssured.given();
        request.header("accept","application/json");
        request.header("Content-Type","application/json");

        System.out.println(user.toString());
        request.body(((JSONObject)(user)).toString());

        Response response = request.post("user");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @AfterSuite
    public static void breakdown()
    {
        //delete the users/pets created
    }


}
