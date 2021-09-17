package utilities.helper.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ObjectConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonObjectToJavaObject(String jsonObject, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(jsonObject, clazz);
    }

    public static <T> List<T> convertJsonArrayToListOfObjects(String jsonArray, Class<T[]> clazz) throws JsonProcessingException {
        return Arrays.asList(objectMapper.readValue(jsonArray, clazz));
    }

}
