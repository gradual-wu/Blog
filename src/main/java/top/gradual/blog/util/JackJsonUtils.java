package top.gradual.blog.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

/**
 * @Description: JackJson工具类
 * @Author: gradual
 * @Date: 2018-09-05 10:02
 */
@Component("jackJsonUtils")
public class JackJsonUtils implements JsonUtil {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T jsonToObject(String JsonString, Class<T> clazz) throws IOException {
        T obj = objectMapper.readValue(JsonString, clazz);
        return obj;
    }

    @Override
    public <T> String objectToJson(T obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    @Override
    public <T> String listToJson(List<T> list) throws JsonProcessingException {
        return objectToJson(list);
    }

    @Override
    public <T> List<T> jsonToList(String jsonString, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonString,new TypeReference<List<T>>() {});
    }

    @Override
    public <K, V> String mapToJson(Map<K, V> map) throws JsonProcessingException {
        return objectToJson(map);
    }

    @Override
    public <K, V> Map<K, V> jsonToMap(String jsonString, Class<K> kClazz, Class<V> vClass) throws IOException {
        return objectMapper.readValue(jsonString,new TypeReference<Map<K, V>>() {});
    }
}
