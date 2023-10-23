package com.dietai.backend.exceptions;

public class PersonNotFoundException extends Exception{

  private final int httpStatusCode = 404;

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

  public int getHttpStatusCode() {
    return httpStatusCode;
  }
}
