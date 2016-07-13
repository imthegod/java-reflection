package thirdparty;

import interfaces.IParser;


/**
 * Created by pardhamavilla on 4/7/16.
 */
public class ParserImpl implements IParser {

    public void parseRequest(Integer i) {
        System.out.println("Parsing Response "+i);
    }


}
