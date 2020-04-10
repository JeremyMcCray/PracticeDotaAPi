package com.dotaAPI.dotaAPI.repositories;

import com.dotaAPI.dotaAPI.models.PlayerWinLoss;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerWinLossRepository extends JpaRepository<PlayerWinLoss,Long>{
}
