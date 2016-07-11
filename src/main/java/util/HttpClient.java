package util;

import base.Metadata;
import com.google.common.base.Strings;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pardhamavilla on 11/7/16.
 */
public class HttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClient.class);

    public final HttpResponse executeHttpPostRequest(String request, Metadata metadata, String contentType) throws IOException {
        HttpPost httpPost = new HttpPost(metadata.getAPI());
        httpPost.addHeader("Content-Type", contentType);

        String userName = metadata.getUserName();
        String metadataAuthToken = metadata.getAuthToken();
        boolean isAuthTokenPresent = !Strings.isNullOrEmpty(metadataAuthToken) || !Strings.isNullOrEmpty(userName);
        if (isAuthTokenPresent) {
            String effectiveAuthToken = metadataAuthToken != null ? metadataAuthToken : "Basic " + new Base64().encodeToString((userName + ":" + metadata.getPassword()).getBytes());
            httpPost.addHeader("Authorization", effectiveAuthToken);
        }

        // add extra parameters in headers
        Map<String, String> extraHeaderParameters = metadata.getHeaderParameters();
        if (extraHeaderParameters != null && !extraHeaderParameters.isEmpty()) {
            for (String headerKey : extraHeaderParameters.keySet()) {
                String headerValue = extraHeaderParameters.get(headerKey);
                httpPost.addHeader(headerKey, headerValue);
            }
        }

        if (!Strings.isNullOrEmpty(metadata.getParameterName())) {
            List<NameValuePair> nameValuePairs = new ArrayList();
            nameValuePairs.add(new BasicNameValuePair(metadata.getParameterName(), request));

            // add extra parameters in request or payload
            Map<String, String> requestParameters = metadata.getRequestParameters();
            if (requestParameters != null) {
                for (String key : requestParameters.keySet()) {
                    nameValuePairs.add(new BasicNameValuePair(key, requestParameters.get(key)));
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } else {
            StringEntity params = new StringEntity(request);
            httpPost.setEntity(params);
        }

        String authorizationHeader = !isAuthTokenPresent ? "null" : httpPost.getFirstHeader("Authorization").getValue();
        return HttpClientBuilder.create().build().execute(httpPost);
    }
}
