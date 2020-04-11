package com.dotaAPI.dotaAPI;

import com.dotaAPI.dotaAPI.controllers.PlayerWinLossController;
import com.dotaAPI.dotaAPI.services.PlayerWinLossServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotaApiApplication{

  public static void main(String[] args) {
    SpringApplication.run(DotaApiApplication.class, args);

  }
}
