package by.atmm.java.http_client_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ShortLink {

    public static final String URI_STRING = "https://goo.su/api/links/create";


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String linkStr = "https://ryanharrison.co.uk/2018/06/15/make-http-requests-kotlin.html";
        ShortLink sl = new ShortLink();
        Map<String,String> jsonData = new HashMap<>();
        jsonData.put("url", linkStr);

        String shortLink = sl.getShortLink(new URI(URI_STRING), jsonData);
        System.out.println(shortLink);
    }

    public String getShortLink(URI uri, Map<String, String> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Short link: data to work is not correct " + map.toString());
        }

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("x-goo-api-token", "qMMJkTBBbMLUi5IAgYLm8jbF2y8iD2nULA0xc1UcQ7oxtDL4htbJTeR56JWm")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new IllegalArgumentException("Short link: data to work is not correct " + map.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<String, String> responseMap = new HashMap<>();
        try {
             responseMap =objectMapper.readValue(response.body().toString(), Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() == 200) {
            return responseMap.get("short_url").toString();
        } else {
            return "";
        }
    }
}
