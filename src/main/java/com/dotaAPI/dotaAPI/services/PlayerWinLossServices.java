package com.dotaAPI.dotaAPI.services;

import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import com.dotaAPI.dotaAPI.repositories.PlayerWinLossRepository;
import kong.unirest.HttpResponse;
import kong.unirest.JsonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class PlayerWinLossServices {

    private final PlayerWinLossRepository repo;

    @Autowired
    public PlayerWinLossServices(PlayerWinLossRepository repos){
    repo = repos;
    }


    public PlayerWinLoss findById( Long steamAccountCode) {
      return saveToDatabaseAndReturn(steamAccountCode);
    }

    public PlayerWinLoss save(PlayerWinLoss wl){
      repo.save(wl);
      return wl;
    }

    //turns fetchedAPIQuery into the actual object
    public PlayerWinLoss makeObject(String json){
      JsonObjectMapper mapper = new JsonObjectMapper();
      PlayerWinLoss PWLObj = mapper.readValue(json, PlayerWinLoss.class);

      return PWLObj;
    }

    //used to send API request  https://api.opendota.com/api/players/48587327/wl <-- this one is for getting the win loss
    public static String fetchApiQuery(String yourQuery){
      HttpResponse<String> response = Unirest.get(yourQuery).asString();

      return response.getBody();
    }

    public PlayerWinLoss saveToDatabaseAndReturn(Long steamAccountCode){
      String jsonOfWL = fetchApiQuery("https://api.opendota.com/api/players/" + steamAccountCode +"/wl");
      PlayerWinLoss PWLObj = makeObject(jsonOfWL);
      PWLObj.setPlayerId(steamAccountCode);
      setWinLossAndPercent(PWLObj);
      return  save(PWLObj);
    }

    public void setWinLossAndPercent(PlayerWinLoss pwl){
        pwl.setTotalGames(pwl.getWin()+pwl.getLoss());
        //i fucked with this for so long to get it to round correctly... just to find out it was the whole time and my math is just bad. Too bad, im leaving it now.
        BigDecimal win = new BigDecimal(pwl.getWin());
        BigDecimal totalGames = new BigDecimal(pwl.getTotalGames());
        pwl.setWinLoss(win.divide(totalGames,5, RoundingMode.CEILING).doubleValue());
    }


}
