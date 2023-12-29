package net.fpt.utils;

import net.fpt.constant.ErrorConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import javax.json.*;
import javax.json.stream.JsonParsingException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ReadingJsonUtil {

    private String result = null;
    private JsonStructure jsonStructure = null;
    private JsonPointer jsonPointer = null;


    /**
     *
     * @param json
     * Json Example:
     * {"token":"fsjjgsgjskg"}
     * @param keyPath  "/token"
     * @return value
     */
    public String findValueJsonObjectByKeyPathJsonString( String json, String keyPath) {

        JsonReader reader =  readJsonObjectToFindValue(json);
        try {
            jsonStructure = Objects.requireNonNull(reader).read();
            reader.close();
        } catch (JsonParsingException jp) {
            Assert.fail(ErrorConstants.CHECK_JSON_FORMAT);
        }
        if (keyPath.startsWith("/")) {
            jsonPointer = Json.createPointer(keyPath);
        } else {
            Assert.fail(ErrorConstants.CHECK_JSON_POINTER);
        }
        boolean found = jsonPointer.containsValue(jsonStructure);
        if(found) {
            JsonString jsonString = (JsonString) jsonPointer.getValue(jsonStructure);
            result = jsonString.getString();
        }
        else{
            Assert.fail(ErrorConstants.CHECK_KEY_PATH + keyPath);
        }
        return result;
    }
    private JsonReader readJsonObjectToFindValue( String json){

        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileReader(json));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }
    public String getStringUTF8(String jsonPath, String keyPath) {
        JSONParser jsonParser = new JSONParser();
        String jsString  =null;
        try {
            FileInputStream input = new FileInputStream(jsonPath);
            InputStreamReader reader = new InputStreamReader(input, "UTF-8");
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            jsString = (String) jsonObject.get(keyPath);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsString;
    }
    public List docFileJSON(String jsonPath, String array) {
        List<String> result = new ArrayList<String>();

        JSONParser jsonParser = new JSONParser();
        try {
            FileInputStream input =  new FileInputStream(jsonPath);
            InputStreamReader  reader = new InputStreamReader(input,"UTF-8");
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray)jsonObject.get(array);
            for (int i = 0; i < jsonArray.size(); i++) {
                result.add(jsonArray.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }


}
