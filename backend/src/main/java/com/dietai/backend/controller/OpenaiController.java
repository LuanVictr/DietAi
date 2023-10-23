package com.dietai.backend.controller;

import com.dietai.backend.utils.Refrigerator;
import com.dietai.backend.service.OpenaiService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dietai")
public class OpenaiController {

  private final OpenaiService apiService;

  @Autowired
  public OpenaiController(OpenaiService openaiService) {
    this.apiService = openaiService;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> getFullDiet(@RequestBody Refrigerator refrigerator) {

    try {

      String ingredientsString = Arrays.toString(refrigerator.getFoods());

      String diet = this.apiService.getFullDiet(ingredientsString).body();

      return ResponseEntity.status(200).body(diet);

    } catch (IOException e) {
      return ResponseEntity.status(503).body(e.getMessage());
    } catch (InterruptedException e) {
      return ResponseEntity.status(503).body(e.getMessage());
    } catch (URISyntaxException e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }

  }

}
