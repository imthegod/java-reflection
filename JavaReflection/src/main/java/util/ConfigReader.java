package util;


import base.Configurations;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class ConfigReader {

    private final ObjectMapper mapper = new ObjectMapper();

    private final JSONParser parser = new JSONParser();

    public Configurations readConfig(){
        Configurations configurations = new Configurations();

        String json =readFile("pluginConfig/config");

        try {
            configurations = mapper.readValue(json, Configurations.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configurations;
    }

    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
