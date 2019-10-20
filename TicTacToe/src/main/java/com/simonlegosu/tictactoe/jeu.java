package com.simonlegosu.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Handler;


public class jeu extends AppCompatActivity {

    GestionnaireJeu ges;
    ImageView carre1;
    ImageView carre2;
    ImageView carre3;
    ImageView carre4;
    ImageView carre5;
    ImageView carre6;
    ImageView carre7;
    ImageView carre8;
    ImageView carre9;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;

    TextView txtPlayer1;
    TextView txtPlayer2;
    TextView txtScorePlayer1;
    TextView txtScorePlayer2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu_activity);

        txtPlayer1 = (TextView) findViewById(R.id.txtPlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtPlayer2);
        txtScorePlayer1 = (TextView) findViewById(R.id.txtscorePlayer1);
        txtScorePlayer2 = (TextView) findViewById(R.id.txtscorePlayer2);

        carre1 = (ImageView) findViewById(R.id.carre1);
        carre2 = (ImageView) findViewById(R.id.carre2);
        carre3 = (ImageView) findViewById(R.id.carre3);
        carre4 = (ImageView) findViewById(R.id.carre4);
        carre5 = (ImageView) findViewById(R.id.carre5);
        carre6 = (ImageView) findViewById(R.id.carre6);
        carre7 = (ImageView) findViewById(R.id.carre7);
        carre8 = (ImageView) findViewById(R.id.carre8);
        carre9 = (ImageView) findViewById(R.id.carre9);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        t9 = (TextView) findViewById(R.id.t9);

        SharedPreferences sharedPrefs = getSharedPreferences("ACTIVE_PLAYERS", Context.MODE_PRIVATE);
        String player1 = sharedPrefs.getString("player1", " ");
        String player2 = sharedPrefs.getString("player2", " ");
        txtPlayer1.setText(player1);
        txtPlayer2.setText(player2);
        //envoyer nom des joueurs au constructor
        ges = new GestionnaireJeu(player1, player2);
        txtPlayer1.setTextSize(28);
    }

    public void clickReturn(View v) {
        //retour a lécran principalesds
        finish();
    }


    public void clickCarre1(View v) {
        gestionClick(carre1 , 1, ges.getJoueurActif());
    }

    public void clickCarre2(View v) {
        gestionClick(carre2 , 2, ges.getJoueurActif());
    }

    public void clickCarre3(View v) {
        gestionClick(carre3 , 3, ges.getJoueurActif());
    }

    public void clickCarre4(View v) {
        gestionClick(carre4 , 4, ges.getJoueurActif());
    }

    public void clickCarre5(View v) {
        gestionClick(carre5 , 5, ges.getJoueurActif());
    }

    public void clickCarre6(View v) {
        gestionClick(carre6 , 6, ges.getJoueurActif());
    }

    public void clickCarre7(View v) {
        gestionClick(carre7 , 7, ges.getJoueurActif());
    }

    public void clickCarre8(View v) {
        gestionClick(carre8 , 8, ges.getJoueurActif());
    }

    public void clickCarre9(View v) {
        gestionClick(carre9 , 9, ges.getJoueurActif());
    }

    public void clickReset(View v) {
        resetGame(1);
    }


    public void gestionClick(ImageView carre, int id, final String j) {
        //checker si le carre a deja été cliqué
        Log.d("TOUR1", (String.valueOf(ges.getTour())));
        Log.d("JOUR3", j);

            int tour = ges.getTour();
            if (ges.checkCarre(id)) {
                ges.setCarre(id, j);
                if (j == ges.getPlay2()) {
                    ges.setTour(j);
                    txtPlayer2.setTextSize(22);
                    txtPlayer1.setTextSize(28);
                    carre.setImageResource(R.drawable.circle);
                    manageTour(tour);
                } else if (j == ges.getPlay1()) {
                    ges.setTour(j);
                    txtPlayer1.setTextSize(22);
                    txtPlayer2.setTextSize(28);
                    carre.setImageResource(R.drawable.cross);
                    manageTour(tour);
                }
                //aller vérifier si il y a un gagnant
                if (ges.checkGame()) {
                    gameWon(j);
                    Toast.makeText(this, "Partie Terminée! " + j + " est victorieux! Préparez-vous pour la prochaine manche, le perdant commence!", Toast.LENGTH_LONG).show();

                }
                tour = ges.getTour();

                if (tour == 9 && (!ges.checkGame())) {
                    Toast.makeText(this, "Partie Nulle! La partie est réinitialisé.", Toast.LENGTH_LONG).show();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //inclure un petit délai avant de tout reset!!
                            resetGame(0);
                        }
                    }, 2000);
                }
            } else {
                Toast.makeText(this, "Veuillez clicker dans une case vide!", Toast.LENGTH_LONG).show();
                Log.d("TOUR1", (String.valueOf(ges.getTour())));
            }




        //derniere instruction a realiser a la fin du click

    }
    public void resetGame(int i)
    {
        ges.resetAll();
        carre1.setImageResource(R.drawable.border);
        carre2.setImageResource(R.drawable.border);
        carre3.setImageResource(R.drawable.border);
        carre4.setImageResource(R.drawable.border);
        carre5.setImageResource(R.drawable.border);
        carre6.setImageResource(R.drawable.border);
        carre7.setImageResource(R.drawable.border);
        carre8.setImageResource(R.drawable.border);
        carre9.setImageResource(R.drawable.border);
        t1.setTextColor(Color.BLACK);
        t2.setTextColor(Color.BLACK);
        t3.setTextColor(Color.BLACK);
        t4.setTextColor(Color.BLACK);
        t5.setTextColor(Color.BLACK);
        t6.setTextColor(Color.BLACK);
        t7.setTextColor(Color.BLACK);
        t8.setTextColor(Color.BLACK);
        t9.setTextColor(Color.BLACK);
        if (i == 0) {
            if (ges.getPremier() == ges.getPlay1()) {
                txtPlayer2.setTextSize(28);
                txtPlayer1.setTextSize(22);
                ges.setPremier(ges.getPlay2());

            } else {
                txtPlayer1.setTextSize(28);
                txtPlayer2.setTextSize(22);
                ges.setPremier(ges.getPlay1());
            }
        }

        if (i == 1) {
            if (ges.getJoueurActif() == ges.getPlay1()) {
                txtPlayer2.setTextSize(22);
                txtPlayer1.setTextSize(28);
            } else {
                txtPlayer1.setTextSize(22);
                txtPlayer2.setTextSize(28);
            }
        }

    }
    public void manageTour(int i)
    {
        switch (i) {
            case 0:
                t1.setTextColor(Color.RED);
                break;
            case 1:
                t2.setTextColor(Color.BLUE);
                break;
            case 2:
                t3.setTextColor(Color.RED);
                break;
            case 3:
                t4.setTextColor(Color.BLUE);
                break;
            case 4:
                t5.setTextColor(Color.RED);
                break;
            case 5:
                t6.setTextColor(Color.BLUE);
                break;

            case 6:
                t7.setTextColor(Color.RED);
                break;
            case 7:
                t8.setTextColor(Color.BLUE);
                break;
            case 8:
                t9.setTextColor(Color.RED);
                break;
            default:
                break;
        }
    }
    public void gameWon(String winner)
    {
        Log.d("WINNER", winner);
        ges.setScore(winner);
        txtScorePlayer1.setText(String.valueOf(ges.getPlay1Score()));
        txtScorePlayer2.setText(String.valueOf(ges.getPlay2Score()));
        ges.resetAll();
        ges.setJoueurActifWin(winner);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                carre1.setImageResource(R.drawable.border);
                carre2.setImageResource(R.drawable.border);
                carre3.setImageResource(R.drawable.border);
                carre4.setImageResource(R.drawable.border);
                carre5.setImageResource(R.drawable.border);
                carre6.setImageResource(R.drawable.border);
                carre7.setImageResource(R.drawable.border);
                carre8.setImageResource(R.drawable.border);
                carre9.setImageResource(R.drawable.border);
                t1.setTextColor(Color.BLACK);
                t2.setTextColor(Color.BLACK);
                t3.setTextColor(Color.BLACK);
                t4.setTextColor(Color.BLACK);
                t5.setTextColor(Color.BLACK);
                t6.setTextColor(Color.BLACK);
                t7.setTextColor(Color.BLACK);
                t8.setTextColor(Color.BLACK);
                t9.setTextColor(Color.BLACK);

            }
        }, 500);


    }
}
