package com.mindtickle.core.dataprovider;

import com.mindtickle.core.util.JSONFileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    public static JSONObject batters;

    @DataProvider(name = "user-data-provider")
    public Object[] parseUserJsonObject() {
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        JSONFileReader reader = new JSONFileReader( currentDir +"/src/test/resources/UserFile.json");
        JSONObject json = reader.jsonParse();

        JSONObject users = (JSONObject) json.get("users");

        // loop array
        JSONArray user = (JSONArray) users.get("user");
        return user.toArray();
    }
}
