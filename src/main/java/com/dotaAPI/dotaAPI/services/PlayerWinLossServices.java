package com.dotaAPI.dotaAPI.services;

import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import com.dotaAPI.dotaAPI.repositories.PlayerWinLossRepository;
import kong.unirest.HttpResponse;
import kong.unirest.JsonObjectMapper;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerWinLossServices {

    private final PlayerWinLossRepository repo;

    @Autowired
    public PlayerWinLossServices(PlayerWinLossRepository repos){
    repo = repos;
    }


    public PlayerWinLoss findById(Long id){
      return repo.findById(id).orElseThrow(RuntimeException :: new);
    }

    public PlayerWinLoss save(PlayerWinLoss wl){
      repo.save(wl);
      return wl;
    }

    public PlayerWinLoss makeObject(String json){
      JsonObjectMapper mapper = new JsonObjectMapper();
     PlayerWinLoss PWLObj = mapper.readValue(json, PlayerWinLoss.class);

     return PWLObj;
    }

  public static String fetchApiQuery(String yourQuery){
    HttpResponse<String> response = Unirest.get(yourQuery).asString();
    System.out.println(response.getBody());
    return response.getBody();
  }

}
