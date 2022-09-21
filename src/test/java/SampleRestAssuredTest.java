//package mindtickle.test.api.sample;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.lang.String;
import static io.restassured.RestAssured.given;
import com.mindtickle.core.util.JSONFileReader;


public class SampleRestAssuredTest {
    private static String url = new String("https://petstore.swagger.io/v2/");

    //Add a util to get a random Id with a base word passed to it.
    // Here pass "TestUser" and get the time appended to it.
    private static String baseUserName = new String ("TestUser");

    @Test (description = "Create a new user with current timestamp",
    dataProvider = "username-data-provider",
    dataProviderClass = SampleDataProvider.class)

    public static void createUser(String userName){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RequestSpecification request = RestAssured.given();
        request.header("accept","application/json");
        request.header("Content-Type","application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("id",0);
        requestParams.put("username", userName);
        requestParams.put("firstName", "Alan");
        requestParams.put("lastName", "Donald");
        requestParams.put("email", "alandonald@gmail.com");
        requestParams.put("phone", "9900110022");
        requestParams.put("userStatus", 0);

        System.out.println(requestParams.toString());
        request.body(requestParams.toString());

        Response response = request.post("user");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @Test(description = "Get a user with the user name passed to the test",
            dataProvider = "username-data-provider",
            dataProviderClass = SampleDataProvider.class)
    public static void getUser(String userName){
        given().when().get(url+"user/"+userName).then().log()
                .all();

    }
    @Test (description = "Update a  user with the user name passed with user details",
            dataProvider = "username-update-data-provider",
            dataProviderClass = SampleDataProvider.class)
    public static void updateUser(String userName){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RequestSpecification request = RestAssured.given();
        request.header("accept","application/json");
        request.header("Content-Type","application/json");

        JSONObject requestParams = new JSONObject();
        //requestParams.put("id",0);
        requestParams.put("username", userName);
        requestParams.put("firstName", "Alan Updated");
        requestParams.put("lastName", "Donald Updated");
        requestParams.put("email", "alandonald@gmail.com");
        requestParams.put("phone", "9900110022");
        requestParams.put("userStatus", 0);

        System.out.println(requestParams.toString());
        request.body(requestParams.toString());

        Response response = request.put("user/"+userName);
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

    }

    @Test (description = "Delete a user with username passed to the test",
            dataProvider = "username-both-data-provider",
            dataProviderClass = SampleDataProvider.class)
    public static void deleteUser(String userName){
        createUser(userName);
        given().when().delete(url+"user/"+userName).then().log()
                .all();

    }

}
