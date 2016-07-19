package com.imthe.god.interfaces.config;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by pardhamavilla on 4/7/16.
 */

public interface IParser {

    Map<String, String> parseRequest(JSONObject i);
}
