package com.dotaAPI.dotaAPI.controllers;


import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import com.dotaAPI.dotaAPI.services.PlayerWinLossServices;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;
import java.util.Optional;

@RestController
public class PlayerWinLossController {


    private static PlayerWinLossServices serv;



    @Autowired
    public PlayerWinLossController(PlayerWinLossServices se){ serv = se;}




    @GetMapping("/getWL/{id}")
    public ResponseEntity<PlayerWinLoss> getWinLoss(@PathVariable Long id ){

      return new ResponseEntity<>(serv.findById(id) , HttpStatus.OK);
    }



}
