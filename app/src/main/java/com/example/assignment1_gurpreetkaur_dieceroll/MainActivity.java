package com.example.assignment1_gurpreetkaur_dieceroll;
/**
 * @author Gurpreet Kaur
 * Assignment 1
 */

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //initialize variable
    private ImageView computerDice, userDice;
    private Button buttonLower, buttonHigher;
    private ImageView resultView;
    Random random = new Random();
    private int computerRandom, userRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computerDice = findViewById(R.id.computer_dice);
        userDice = findViewById(R.id.user_dice);
        buttonLower = findViewById(R.id.button_lower);
        buttonHigher = findViewById(R.id.button_higher);
        resultView=findViewById(R.id.result_View);

        //When user click on lower button result will be appeared on the screen using imageview
        buttonLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //function call
                generateRandom();
                if(computerRandom < userRandom){
                    resultView.setImageResource(R.drawable.computerwin);
                    resultView.setVisibility(View.VISIBLE);
                }
                else if(computerRandom > userRandom){
                    resultView.setImageResource(R.drawable.userwin);
                    resultView.setVisibility(View.VISIBLE);
                }
                else {
                    resultView.setImageResource(R.drawable.tie);
                    resultView.setVisibility(View.VISIBLE);
                }
            }
        });

        //When user click higher button result will be displayed using imageview
        buttonHigher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandom();
                if(computerRandom > userRandom){
                    resultView.setImageResource(R.drawable.computerwin);
                    resultView.setVisibility(View.VISIBLE);
                }
                else if(computerRandom < userRandom){
                    resultView.setImageResource(R.drawable.userwin);
                    resultView.setVisibility(View.VISIBLE);
                }
                else {
                    resultView.setImageResource(R.drawable.tie);
                    resultView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

//function to create random number from 1 to 6
    private void generateRandom() {
        computerRandom = random.nextInt(6) + 1;
        userRandom = random.nextInt(6) + 1;
        rollDice(computerRandom, userRandom);
    }

//function to roll dice images
    private void rollDice(int compRandom, int playerRandom) {
        char dice1 = (char) (compRandom + '0');
        char dice2 = (char) (playerRandom + '0');
        switch(dice1){
            case '1' :
                computerDice.setImageResource(R.drawable.dice1);
                break;
            case '2' :
                computerDice.setImageResource(R.drawable.dice2);
                break;
            case '3' :
                computerDice.setImageResource(R.drawable.dice3);
                break;
            case '4' :
                computerDice.setImageResource(R.drawable.dice4);
                break;
            case '5' :
                computerDice.setImageResource(R.drawable.dice5);
                break;
            case '6' :
                computerDice.setImageResource(R.drawable.dice6);
                break;
            default:
        }
        switch(dice2){
            case '1' :
                userDice.setImageResource(R.drawable.dice1);
                break;
            case '2' :
                userDice.setImageResource(R.drawable.dice2);
                break;
            case '3' :
                userDice.setImageResource(R.drawable.dice3);
                break;
            case '4' :
                userDice.setImageResource(R.drawable.dice4);
                break;
            case '5' :
                userDice.setImageResource(R.drawable.dice5);
                break;
            case '6' :
                userDice.setImageResource(R.drawable.dice6);
                break;
            default:
        }
    }
}