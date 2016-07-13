package tests;

import base.APIConfig;
import base.Configurations;
import util.ConfigReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by pardhamavilla on 4/7/16.
 */
public class ConfigReaderTest {

    public static void main(String[] args) {

        ConfigReader configReader = new ConfigReader();

        Configurations configurations =configReader.readConfig();

        int i =1;

        try {
            for (APIConfig config : configurations.getApiConfigs()) {

                Class myClass = Class.forName(config.getRequestClass());

                Class myClass1 = Class.forName(config.getParserClass());

                Object obj = myClass.newInstance();

                Object obj1 = myClass1.newInstance();

                Method method = obj.getClass().getMethod(config.getRequestMethod(),Integer.class);

                Method method1 = obj1.getClass().getMethod(config.getParserMethod(),Integer.class);

                method.invoke(obj,i);

                method1.invoke(obj1,i++);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
