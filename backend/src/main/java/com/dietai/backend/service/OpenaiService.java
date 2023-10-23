package com.dietai.backend.service;

import com.dietai.backend.utils.Message;
import com.dietai.backend.utils.Payload;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenaiService {
  @Value("${openai.api.key}")
  private String API_KEY;

  @Value("${openai.api.url}")
  private String apiEndpoint;

  public HttpResponse<String> getFullDiet(String userFoodInfos)
      throws IOException, InterruptedException, URISyntaxException {

    Payload payload = new Payload();
    Message systemConfig = new Message();
    Message userRequest = new Message();
    Gson gson = new Gson();

    systemConfig.setRole("system");
    systemConfig.setContent("You're a nutricionist bot that is talking with people, be humanized");

    userRequest.setRole("user");
    userRequest.setContent("Me monte uma dieta saudável com variação de pratos para uma semana"
        + "utilizando esses ingredientes" + userFoodInfos);

    payload.setModel("gpt-3.5-turbo");
    payload.setMessages(List.of(systemConfig, userRequest));
    payload.setTemperature(0.7f);

    String jsonRequest = gson.toJson(payload);

    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest httpRequest = HttpRequest.newBuilder()
        .uri(new URI(apiEndpoint))
        .header("Authorization", "Bearer " + API_KEY)
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(jsonRequest))
        .build();

    HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

    return response;

  }

}
