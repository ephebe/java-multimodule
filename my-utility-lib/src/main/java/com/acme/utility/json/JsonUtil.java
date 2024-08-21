package com.acme.utility.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class JsonUtil {
    private static ObjectMapper mapper;

    public JsonUtil() {
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        JsonUtil.mapper = mapper;
    }

    /**
     * 將物件轉成JSon String
     * @param value
     * @return
     */
    public static String toJSONString(Object value)
    {
        try
        {
            return mapper.writeValueAsString(value);
        }
        catch (JsonProcessingException e)
        {
            log.info("toJSONString fail, Object=" + value, e);
            return null;
        }
    }

    /**
     * 將JSon String轉成物件
     * @param jsonString
     * @param object
     * @return
     */
    public static <T> T fromJSONString(String jsonString, Class<T> object)
    {
        if (jsonString == null || object == null)
        {
            log.warn("fromJSONString format error");
            return null;
        }

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(jsonString, object);
        }
        catch (JsonProcessingException e)
        {
            log.info("fromJSONString fail, jsonString=" + jsonString + ", object=" + object, e);
            return null;
        }
    }

    /**
     * 將Map<String, Object>轉成JSon String
     *
     */
    public static String readMapToJSON(Map<String, Object> map)
    {
        if (map == null || map.isEmpty() )
        {
            log.warn("readMaptoJSON format error");
            return null;
        }

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(map);
        }
        catch (JsonProcessingException e)
        {
            log.info("readMaptoJSON fail, map= " + map, e);
            return null;
        }
    }

    /**
     * 將JSon String轉成Map<String, Object>
     *
     */
    public static Map<String, Object> readJSONtoMap(String jsonString)
    {
        if (jsonString == null || jsonString.trim().length() == 0)
        {
            log.warn("readJSONtoMap format error");
            return null;
        }

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>(){};
            return mapper.readValue(jsonString, typeRef);
        }
        catch (JsonProcessingException e)
        {
            log.info("readJSONtoMap fail, jsonString=" + jsonString, e);
            return null;
        }
    }


    /**
     * 將List<Object>轉成JSon String
     *
     */
    public static String readListToJSON(List<Object> list)
    {
        if (list == null || list.isEmpty() )
        {
            log.warn("readListToJSON format error");
            return null;
        }

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(list);
        }
        catch (JsonProcessingException e)
        {
            log.info("readListToJSON fail, list=" + list, e);
            return null;
        }
    }

    /**
     * 將JSon String轉成 List<Object>
     *
     */
    public static List< Object> readJSONtoList(String jsonString)
    {
        if (jsonString == null || jsonString.trim().length() == 0)
        {
            log.warn("readJSONtoList format error");
            return null;
        }

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List< Object>> typeRef = new TypeReference<List< Object>>(){};
            return mapper.readValue(jsonString, typeRef);
        }
        catch (JsonProcessingException e)
        {
            log.info("readJSONtoList fail, jsonString=" + jsonString, e);
            return null;
        }
    }
}
