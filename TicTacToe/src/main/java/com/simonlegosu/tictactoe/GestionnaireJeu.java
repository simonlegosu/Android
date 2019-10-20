package com.simonlegosu.tictactoe;
import android.util.Log;


public class GestionnaireJeu extends Joueur {
    private int tourp1;
    private int tourp2;
    private String joueurActif;
    private String premier;

    private Boolean carre1 = false;
    private Boolean carre2 = false;
    private Boolean carre3 = false;
    private Boolean carre4 = false;
    private Boolean carre5 = false;
    private Boolean carre6 = false;
    private Boolean carre7 = false;
    private Boolean carre8 = false;
    private Boolean carre9 = false;

    private String playerCarre1;
    private String playerCarre2;
    private String playerCarre3;
    private String playerCarre4;
    private String playerCarre5;
    private String playerCarre6;
    private String playerCarre7;
    private String playerCarre8;
    private String playerCarre9;


    public GestionnaireJeu(String player1, String player2) {
        super(player1, player2);
        this.premier = player1;
        this.joueurActif = player1;
    }
    public void setPremier(String p)
    {
        Log.d("yayaya", p);
        this.premier = p;
    }

    public String getPremier(){
        return this.premier;
    }
    public int getTour() {
        int tourCnt = tourp1 + tourp2;
        return tourCnt;
    }

    public void setTour(String j) {

        if (j == super.getPlay1()){
            this.tourp1++;
            this.joueurActif = super.getPlay2();
        }
        else if (j == super.getPlay2()){
            this.tourp2++;
            this.joueurActif = super.getPlay1();
        }

    }
    public void setScore(String winner) {
        if (winner == super.getPlay1()){
            super.setPlay1Score();
        }else if (winner == super.getPlay2()){
            super.setPlay2Score();
        }
    }
    public String getJoueurActif() {
        return this.joueurActif;
    }

    public void setJoueurActifWin(String j) {
        if (j == this.getPlay1()){
            this.joueurActif = this.getPlay2();
            this.premier = this.getPlay2();
        }
        if (j == this.getPlay2()){
            this.joueurActif = this.getPlay1();
            this.premier = this.getPlay1();
        }
    }

    public Boolean checkCarre(int id) {
        switch (id) {
            case 1:
                if (!carre1) {
                    return true;
                } else return false;

            case 2:
                if (!carre2) {
                    return true;
                } else return false;

            case 3:
                if (!carre3) {
                    return true;
                } else return false;

            case 4:
                if (!carre4) {
                    return true;
                } else return false;

            case 5:
                if (!carre5) {
                    return true;
                } else return false;

            case 6:
                if (!carre6) {
                    return true;
                } else return false;

            case 7:
                if (!carre7) {
                    return true;
                } else return false;

            case 8:
                if (!carre8) {
                    return true;
                } else return false;

            case 9:
                if (!carre9) {
                    return true;
                } else return false;

            default:
                return false;


        }
    }

    public void setCarre(int id, String j) {
        switch (id) {
            case 1:
                this.carre1 = true;
                this.playerCarre1 = j;
                break;
            case 2:
                this.carre2 = true;
                this.playerCarre2 = j;
                break;
            case 3:
                this.carre3 = true;
                this.playerCarre3 = j;
                break;
            case 4:
                this.carre4 = true;
                this.playerCarre4 = j;
                break;
            case 5:
                this.carre5 = true;
                this.playerCarre5 = j;
                break;
            case 6:
                this.carre6 = true;
                this.playerCarre6 = j;
                break;
            case 7:
                this.carre7 = true;
                this.playerCarre7 = j;
                break;
            case 8:
                this.carre8 = true;
                this.playerCarre8 = j;
                break;
            case 9:
                this.carre9 = true;
                this.playerCarre9 = j;
                break;
            default:
                break;
        }
    }

    public void resetAll() {
        this.carre1 = false;
        this.carre2 = false;
        this.carre3 = false;
        this.carre4 = false;
        this.carre5 = false;
        this.carre6 = false;
        this.carre7 = false;
        this.carre8 = false;
        this.carre9 = false;
        this.playerCarre1 = null;
        this.playerCarre2 = null;
        this.playerCarre3 = null;
        this.playerCarre4 = null;
        this.playerCarre5 = null;
        this.playerCarre6 = null;
        this.playerCarre7 = null;
        this.playerCarre8 = null;
        this.playerCarre9 = null;
        this.tourp1 = 0;
        this.tourp2 = 0;

    }

    public Boolean checkGame() {

        if (playerCarre1 == playerCarre2 && playerCarre1 == playerCarre3 && playerCarre1 != null) {
            return true;

        } else if (playerCarre4 == playerCarre5 && playerCarre4 == playerCarre6 && playerCarre4 != null) {
            return true;
        } else if (playerCarre7 == playerCarre8 && playerCarre7 == playerCarre9 && playerCarre7 != null) {
            return true;
        } else if (playerCarre1 == playerCarre4 && playerCarre1 == playerCarre7 && playerCarre1 != null) {
            return true;
        } else if (playerCarre2 == playerCarre5 && playerCarre2 == playerCarre8 && playerCarre2 != null) {
            return true;
        } else if (playerCarre3 == playerCarre6 && playerCarre3 == playerCarre9 && playerCarre3 != null) {
            return true;
        } else if (playerCarre7 == playerCarre5 && playerCarre7 == playerCarre3 && playerCarre7 != null){
            return true;
        } else if (playerCarre1 == playerCarre5 && playerCarre1 == playerCarre9 && playerCarre1 != null){
            return true;
        } else return false;
    }
}

