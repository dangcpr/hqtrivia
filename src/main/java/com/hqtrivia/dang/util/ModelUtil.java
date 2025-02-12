package com.hqtrivia.dang.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ModelUtil {
    public static JSONObject toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(object);
            JSONParser parser = new JSONParser();

            try {
                return (JSONObject)parser.parse(jsonString);
            }
            catch (Exception e){
                //The handling for the code
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            //The handling for the code
            throw new RuntimeException(e);
        }
    }
}