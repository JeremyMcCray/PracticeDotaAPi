package com.dotaAPI.dotaAPI.models;

public class PlayerWinLoss {

    private int win;
    private int lose;

    PlayerWinLoss(int win, int loss){
        this.win = win;
        this.lose = loss;
    }

    public int getWin() {
        return win;
    }

    public int getLoss() {
        return lose;
    }
}
