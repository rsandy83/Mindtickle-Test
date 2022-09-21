package com.mindtickle.core.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader {

    public static String filePath;
    public JSONFileReader(String filePath){
        JSONFileReader.filePath = filePath;
    }
     public JSONObject jsonParse() {
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(new FileReader(filePath));
                return (JSONObject) obj;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
         return null;
     }
}
