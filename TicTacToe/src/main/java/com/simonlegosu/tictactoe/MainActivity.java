package com.simonlegosu.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
//saisie des noms d'utilisateur
    private EditText txtPlayer1Name;
    private EditText txtPlayer2Name;
    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPlayer1Name = (EditText)findViewById(R.id.txtPlayer1Name);
        txtPlayer2Name = (EditText)findViewById(R.id.txtPlayer2Name);
        btnStart  = (Button)findViewById(R.id.btnStart);
    }

    public void startGame(View view)
    {
        if (txtPlayer1Name.getText().toString().isEmpty() || txtPlayer2Name.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Vous devez entrer un username pour les deux joueurs!", Toast.LENGTH_LONG).show();
        }
        else {
            SharedPreferences sharedPrefs = getSharedPreferences("ACTIVE_PLAYERS", Context.MODE_PRIVATE);
            SharedPreferences.Editor editeur = sharedPrefs.edit();
            editeur.putString("player1", txtPlayer1Name.getText().toString());
            editeur.putString("player2", txtPlayer2Name.getText().toString());
            editeur.commit();
            txtPlayer1Name.setText("");
            txtPlayer2Name.setText("");
            Intent intent = new Intent(this, jeu.class);
            startActivity(intent);
        }
    }

}
