package com.mindtickle.core.dataprovider;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
public class JSONFileReader {

    public static String id, name, city, filePath;
    public static JSONObject batters;

    public JSONFileReader(String filePath){
        JSONFileReader.filePath = filePath;
    }
     public static void jsonParse() {

            JSONParser parser = new JSONParser();

            try {
                Object obj = parser.parse(new FileReader(filePath));

                JSONObject jsonObject =  (JSONObject) obj;

                JSONFileReader.id = (String) jsonObject.get("id");
                System.out.println(id);

                JSONFileReader.city = (String) jsonObject.get("type");
                System.out.println(city);

                JSONFileReader.name = (String) jsonObject.get("name");
                System.out.println(name);

                // loop array
                JSONFileReader.batters = (JSONObject) jsonObject.get("batters");
                JSONArray batter = (JSONArray) batters.get("batter");
                Iterator<JSONObject> iterator = batter.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next().toString());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    /*
        @DataProvider(name = "username-data-provider")
        public static Object[] userData()
        {
            return new Object[] {  "UserName1" , "UserName2" };
        }

        @DataProvider(name = "username-update-data-provider")
        public static Object[] updateUserData()
        {
            return new Object[] {  "UserName1Updated" , "UserName2Updated" };
        }

        @DataProvider(name = "username-both-data-provider")
        public static Object[] bothUserData()
        {
            return new Object[] {  "UserName1" , "UserName2", "UserName1Updated" , "UserName2Updated" };
        }*/
}
