package com.simonlegosu.tictactoe;


public class Joueur {

    private String play1;
    private String play2;
    private int player1Score;
    private int player2Score;

    public Joueur(String player1, String player2) {
        this.play1 = player1;
        this.play2 = player2;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public String getPlay1() {
        return play1;
    }

    public String getPlay2() {
        return play2;
    }

    public int getPlay1Score() {
        return player1Score;
    }

    public void setPlay1Score() {
        this.player1Score++;
    }

    public int getPlay2Score() {
        return player2Score;
    }

    public void setPlay2Score() {
        this.player2Score++;
    }




}

