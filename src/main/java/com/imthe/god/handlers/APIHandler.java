package com.imthe.god.handlers;


import com.imthe.god.base.APIConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mavilla on 18/07/16.
 */
public class APIHandler {

    public static final String requestObject = "RequestObject";

    public static final String parserObject = "ParserObject";

    private static Map<String, Map<String, Object>> configsMap = new HashMap();

    public static Map<String, String> getDataFromAPI(APIConfig apiConfig, Map<String, String> paramMap) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        Map<String, String> datafromAPI = new HashMap<String, String>();

        Map<String, Object> config = configsMap.get(apiConfig.getName());

        if (null == config) {
            createObject(apiConfig);

            config = configsMap.get(apiConfig.getName());
        }

        Object object = config.get(requestObject);

        Method method = object.getClass().getMethod(apiConfig.getRequestMethod());

        method.invoke(object);


        return datafromAPI;
    }

    private static void createObject(APIConfig apiConfig) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {

        Class requestBuilderClass = Class.forName(apiConfig.getRequestClass());

        Object requestBuilderObject = requestBuilderClass.newInstance();

        Class parserClass = Class.forName(apiConfig.getParserClass());

        Object requestParserObject = parserClass.newInstance();

        Map<String, Object> objects = new HashMap<String, Object>();

        objects.put(requestObject, requestBuilderObject);

        objects.put(parserObject, requestParserObject);

        configsMap.put(apiConfig.getName(), objects);

    }
}
