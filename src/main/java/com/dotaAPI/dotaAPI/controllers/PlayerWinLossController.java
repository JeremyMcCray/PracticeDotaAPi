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

  String url ="https://api.opendota.com/api/matches/271145478?api_key=695fec48-5c98-4981-bf7a-2c92b125f9e3";

    private static PlayerWinLossServices serv;



    @Autowired
    public PlayerWinLossController(PlayerWinLossServices se){ serv = se;}




    @GetMapping("/getWL/{id}")
    public ResponseEntity<PlayerWinLoss> getWinLoss(Long id ){

      return new ResponseEntity<>(serv.findById(id) , HttpStatus.OK);
    }





//    @GetMapping("https://api.opendota.com/api/players/{account_id}/wl")
//    public PlayerWinLoss getWinLoss(@PathVariable int account_id){
//        return null;
//    }
}
