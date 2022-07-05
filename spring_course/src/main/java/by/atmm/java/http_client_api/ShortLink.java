package by.atmm.java.http_client_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Log
public class ShortLink {

    public static final String URI_STRING = "https://goo.su/api/links/create";


    public static void main(String[] args) {
        String linkStr = "https://ryanharrison.co.uk/2018/06/15/make-http-requests-kotlin.html";
        ShortLink sl = new ShortLink();
        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("url", linkStr);

        String shortLink = sl.getShortLink(URI_STRING, jsonData);
        System.out.println(shortLink);
    }

    public String getShortLink(String uri, Map<String, String> map) {
        Map<String, Object> responseMap = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
            HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                    .header("Content-Type", "application/json")
                    .header("x-goo-api-token", "qMMJkTBBbMLUi5IAgYLm8jbF2y8iD2nULA0xc1UcQ7oxtDL4htbJTeR56JWm")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            responseMap = objectMapper.readValue(response.body(), Map.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Short link: data to work is not correct " + map.toString());
        }

        if (responseMap.get("message").equals("Link successfully created")) {
            return responseMap.get("short_url").toString();
        } else {
            return "";
        }
    }
}
