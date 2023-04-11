package com.orion.core.document.json;

import com.google.gson.Gson;
import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.map.type.OrionHashMap;
import com.orion.core.document.json.tasks.ConvertJSONObjectToMapTask;
import com.orion.core.document.json.tasks.ConvertJSONObjectToStringTask;
import com.orion.core.exception.Assert;
import java.util.Map;

public class JSONService extends OrionService
{
    public static String convertObjectToJSON(Object objectToConvert)
    {
        Assert.notNull(objectToConvert, "The given objectToConvert is null.");
        return new Gson().toJson(objectToConvert);
    }


    public static Object convertJSONToObject(String JSONData, Object objectToConvertTo)
    {
        Assert.notEmpty(JSONData, "The given JSONData is null/empty.");
        Assert.notNull(objectToConvertTo, "The given objectToConvertTo is null.");
        return new Gson().fromJson(JSONData, objectToConvertTo.getClass());
    }


    public static Object convertJSONToObject(String JSONData, Class<?> classToConvertTo)
    {
        Assert.notEmpty(JSONData, "The given JSONData is null/empty.");
        Assert.notNull(classToConvertTo, "The given classToConvertTo is null.");
        return new Gson().fromJson(JSONData, classToConvertTo);
    }


    @SuppressWarnings("unchecked")
    public static Map<Object, Object> convertJSONToMap(String JSONData)
    {
        return (Map<Object, Object>)convertJSONToObject(JSONData, OrionHashMap.class);
    }


    public static String convertJSONMapToString(Map<?, ?> JSONMap)
    {
        Assert.notEmpty(JSONMap, "The given JSONMap is null/empty.");
        return new Gson().toJson(JSONMap);
    }


    public static JSONObject convertJSONMapToJSONObject(Map<?, ?> JSONMap)
    {
        Assert.notEmpty(JSONMap, "The given JSONMap is null/empty.");
        String JSONString = convertJSONMapToString(JSONMap);
        return new JSONObject(JSONMap, JSONString);
    }


    public static Object convertJSONMapToObject(Map<?, ?> JSONMap, Object objectToConvertTo)
    {
        return convertJSONToObject(convertJSONMapToJSONObject(JSONMap).getJSONStringData(), objectToConvertTo);
    }


    public static Object convertJSONMapToObject(Map<?, ?> JSONMap, Class<?> classToConvertTo)
    {
        return convertJSONToObject(convertJSONMapToJSONObject(JSONMap).getJSONStringData(), classToConvertTo);
    }


    public static String convertJSONObjectToString(JSONObject jsonObject)
    {
        return ConvertJSONObjectToStringTask.run(jsonObject);
    }


    public static Map<?, ?> convertJSONObjectToMap(JSONObject jsonObject)
    {
        return ConvertJSONObjectToMapTask.run(jsonObject);
    }


    public static Object convertJSONObjectToObject(JSONObject jsonObject, Object objectToConvertTo)
    {
        return convertJSONToObject(jsonObject.getJSONStringData(), objectToConvertTo);
    }


    public static Object convertJSONObjectToObject(JSONObject jsonObject, Class<?> classToConvertTo)
    {
        return convertJSONToObject(jsonObject.getJSONStringData(), classToConvertTo);
    }


    @SuppressWarnings("unchecked")
    public static JSONObject convertJSONToJSONObject(String JSONData)
    {
        Assert.notEmpty(JSONData, "The given JSONData is null/empty.");
        Map<Object, Object> JSONMap = (Map<Object, Object>)convertJSONToObject(JSONData, OrionHashMap.class);
        return new JSONObject(JSONMap, JSONData);
    }


    public static Map<?, ?> convertObjectToMap(Object objectToConvert)
    {
        Assert.notNull(objectToConvert, "The given objectToConvert is null.");
        String JSONString = convertObjectToJSON(objectToConvert);
        return convertJSONToMap(JSONString);
    }


    public static JSONObject convertObjectToJSONObject(Object objectToConvert)
    {
        Assert.notNull(objectToConvert, "The given objectToConvert is null.");
        String JSONString = convertObjectToJSON(objectToConvert);
        Map<Object, Object> JSONMap = convertJSONToMap(JSONString);
        return new JSONObject(JSONMap, JSONString);
    }
}