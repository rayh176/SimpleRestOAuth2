package com.wallstreet.auth;

import com.wallstreet.service.RiskMeasureCache;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Connect to Auth site and obtain token access, cache the results
 */
public interface RiskMeasureAuthenticator {
    String ACCESS_TOKEN = "ACCESS_TOKEN_LOCALHOST";

    String redirectUri = "http://localhost:8080";
    String environment = "https://staging-auth.wallstreetdocs.com";

    String GRAND_TYPE = "client_credentials";

    // clientId is 'Consumer Key' in the Remote Access UI
    String CLIENT_ID = "coding_test";

    // clientSecret is 'Consumer Secret' in the Remote Access UI
    String CLIENT_SECRET = "bwZm5XC6HTlr3fcdzRnD";

    default void authenticateCallback(HttpServletRequest request, RiskMeasureCache riskMeasureCache) throws ServletException, IOException {


        String accessToken = (String) request.getSession().getAttribute(ACCESS_TOKEN);

        if(accessToken == null) {

            HttpEntity entity2 = null;

            String tokenUrl = environment + "/oauth/token";

            String code = request.getParameter("code");
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(tokenUrl);
            List<BasicNameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("code", code));
            nvps.add(new BasicNameValuePair("grant_type", GRAND_TYPE));
            nvps.add(new BasicNameValuePair("client_id", CLIENT_ID));
            nvps.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
            nvps.add(new BasicNameValuePair("redirect_uri", redirectUri));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);

            try {
                entity2 = response2.getEntity();

                String stringResponse = IOUtils.toString(entity2.getContent());

                JSONObject authResponse = new JSONObject(new JSONTokener( stringResponse));

                accessToken = authResponse.getString("access_token");

            } catch (JSONException e) {
                throw new ServletException(e);
            } finally {
                EntityUtils.consume(entity2);
                response2.close();
                httpPost.releaseConnection();
                httpclient.close();
            }

            riskMeasureCache.addTokenToCache(ACCESS_TOKEN, accessToken);

            // add it to the session
            request.getSession().setAttribute(ACCESS_TOKEN, accessToken);
        }
    }

}
