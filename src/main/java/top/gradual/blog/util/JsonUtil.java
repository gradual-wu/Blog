package top.gradual.blog.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @Description: JSON操作类接口
 * @Author: gradual
 * @Date: 2018-09-05 9:56
 */
public interface JsonUtil {

    <T> T jsonToObject(String JsonString, Class<T> clazz) throws Exception;

    <T> String objectToJson(T obj) throws Exception;

    <T> String listToJson(List<T> list) throws Exception;

    <T> List<T> jsonToList(String jsonString, Class<T> clazz) throws Exception;

    <K, V> String mapToJson(Map<K, V> map) throws JsonProcessingException;

    <K, V> Map<K, V> jsonToMap(String jsonString, Class<K> kClazz, Class<V> vClass) throws Exception;
}
