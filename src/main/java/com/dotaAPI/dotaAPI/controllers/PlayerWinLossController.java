package com.dotaAPI.dotaAPI.controllers;


import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import com.dotaAPI.dotaAPI.services.PlayerWinLossServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlayerWinLossController {

    private static PlayerWinLossServices serv;

    @Autowired
    public PlayerWinLossController(PlayerWinLossServices se){ serv = se;}

    @GetMapping("https://api.opendota.com/api/players/{account_id}/wl")
    public PlayerWinLoss getWinLoss(@PathVariable int account_id){

//        Optional<PlayerWinLoss> wl = serv.findById(account_id);

        return null;
    }
}
