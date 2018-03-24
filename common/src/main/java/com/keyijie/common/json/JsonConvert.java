package com.keyijie.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Json转换工具类
 */
public class JsonConvert {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Json反序列化
     *
     * @param json json String
     * @return Object
     */
    public static <T> T DeserializeObject(String json, Class<T> valueType) throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T t = mapper.readValue(json, valueType);
        return t;
    }

    /**
     * Json序列化
     *
     * @param obj Object
     * @return String
     */
    public static String SerializeObject(Object obj) throws JsonProcessingException {
        String json = mapper.writeValueAsString(obj);
        return json;
    }
}
