package com.dotaAPI.dotaAPI.services;

import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import com.dotaAPI.dotaAPI.repositories.PlayerWinLossRepository;
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


    public Optional<PlayerWinLoss> findById(Long id){
        return repo.findById(id);
    }
}
