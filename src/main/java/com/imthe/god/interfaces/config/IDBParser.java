package com.imthe.god.interfaces.config;

import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by mavilla on 15/07/16.
 */
public interface IDBParser {

    Map<String, String> parseResultset(ResultSet resultSet);
}
