package it.home.base.base.web.baseWeb.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.HttpMultipartMode;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {

    private RestClient() {}

    public static <T> T post(String url, Map<String, String> headers, Map<String, String> queryParameters, Object body, TypeReference<T> typeReference) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(getURI(url, queryParameters));
        request.addHeader("content-type", "application/json");
        setCustomHeaders(request, headers);
        if(body != null) request.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(body)));
        CloseableHttpResponse response = httpClient.execute(request);
        return new ObjectMapper().readValue(response.getEntity().getContent(), typeReference);
    }
    public static <T> T multipartPost(String url, Map<String, String> headers, Map<String, String> queryParameters, HttpEntity body, TypeReference<T> typeReference) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(getURI(url, queryParameters));
        setCustomHeaders(request, headers);
        if(body != null) request.setEntity(body);
        CloseableHttpResponse response = httpClient.execute(request);
        return new ObjectMapper().readValue(response.getEntity().getContent(), typeReference);
    }

    public static <T> T get(String url, Map<String, String> headers, Map<String, String> queryParameters, TypeReference<T> typeReference) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(getURI(url, queryParameters));
        request.addHeader("content-type", "application/json");
        setCustomHeaders(request, headers);
        CloseableHttpResponse response = httpClient.execute(request);
        return new ObjectMapper().readValue(response.getEntity().getContent(), typeReference);
    }


    private static URI getURI(String baseUrl, Map<String, String> queryParameters) throws URISyntaxException {
        URIBuilder uri = new URIBuilder(baseUrl);
        if(queryParameters != null) {
            for(Entry<String, String> entry : queryParameters.entrySet()) {
                uri.addParameter(entry.getKey(), entry.getValue());
            }
        }
        return uri.build();
    }

    private static void setCustomHeaders(HttpRequest request, Map<String, String> headers) {
        if(headers != null) {
            for(Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(),entry.getValue());
            }
        }
    }

    public static HttpEntity getMultipartHttpEntity(Map<String, String> map) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.LEGACY);
        if(map != null)
            for(Entry<String, String> entry : map.entrySet()) {
                builder.addTextBody(entry.getKey(), entry.getValue());
            }
        return builder.build();
    }
}
