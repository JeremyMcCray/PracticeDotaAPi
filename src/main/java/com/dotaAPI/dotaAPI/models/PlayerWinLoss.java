package com.dotaAPI.dotaAPI.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerWinLoss {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int win;
    private int lose;

    public PlayerWinLoss(int win, int loss){
        this.win = win;
        this.lose = loss;
    }

    public PlayerWinLoss(){}

    public int getWin() {
        return win;
    }

    public int getLoss() {
        return lose;
    }
}
