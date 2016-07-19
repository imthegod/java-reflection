package com.imthe.god.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.imthe.god.base.Configurations;
import com.imthe.god.base.Constants;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class ConfigReader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map configs = new HashMap();

    public static Map readFile() {
        String result = "";
        try {
            //Get file from resources folder
            File folder = new File(ConfigReader.class.getResource(Constants.CONFIG_LOCATION).getFile());
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String fileName = listOfFiles[i].getName();
                    System.out.println("Processing File " + fileName);

                    InputStream in = ConfigReader.class.getClass().getResourceAsStream(Constants.CONFIG_LOCATION + "/" + fileName);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        line = br.readLine();
                    }
                    result = sb.toString();

                    readConfig(result);

                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return configs;
    }

    private static void readConfig(String json) {

        try {
            Configurations configurations = mapper.readValue(json, Configurations.class);
            Map<String, String> details = configurations.getDetails();
            String key = details.get(Constants.TENANT) + Constants.SEPARATOR + details.get(Constants.CHANNEL)
                    + Constants.SEPARATOR + details.get(Constants.STATION);

            configs.put(key, configurations);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
