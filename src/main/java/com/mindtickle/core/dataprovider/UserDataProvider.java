package com.mindtickle.core.dataprovider;

import com.mindtickle.core.util.JSONFileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    public static JSONObject batters;

    @DataProvider(name = "user-data-provider")
    public Object[] parseUserJsonObject() {

        JSONFileReader reader = new JSONFileReader("C://Users/rsand/file.json");
        JSONObject json = reader.jsonParse();

        JSONObject users = (JSONObject) json.get("users");

        // loop array
        JSONArray user = (JSONArray) users.get("user");
//        Iterator<JSONObject> iterator = user.iterator();

        //      while (iterator.hasNext()) {
        //        System.out.println(iterator.next().toString());
        //  }

        //return new Object[] {  "UserName1" , "UserName2", "UserName1Updated" , "UserName2Updated" };return new Object [0][] = {
        return user.toArray();
    }
}
