package thirdparty;

import interfaces.IRequestBuilder;
import org.json.JSONObject;

/**
 * Created by pardhamavilla on 4/7/16.
 */
public class RequestBuilderImpl implements IRequestBuilder {


    public JSONObject buildRequest(Integer i) {
            System.out.println("Building Request "+i);
        return new JSONObject();
        }
}
