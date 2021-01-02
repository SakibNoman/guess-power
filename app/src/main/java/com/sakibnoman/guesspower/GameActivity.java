package com.sakibnoman.guesspower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    EditText userInput;
    Button buttonSub,restartBut;
    ImageView anim;
    TextView textView,textView1;
    String guessPerStr,guessPerStr2;
    Random rand=new Random();
    Double appNumber;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        appNumber = Double.valueOf(rand.nextInt(20)+1);

        userInput = findViewById(R.id.editText);
        buttonSub = findViewById(R.id.submitBtn);
        textView = findViewById(R.id.output);
        textView1 = findViewById(R.id.output1);
        restartBut = findViewById(R.id.restartbtn);
        anim = findViewById(R.id.victory);


        restartBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appNumber = Double.valueOf(rand.nextInt(20)+1);

            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String userStr = userInput.getText().toString().trim();

                    Double userNumber = Double.parseDouble(userStr);
                    Double diff;
                    if (userNumber < 1 || userNumber > 20) {
                        textView.setText("Error!");
                    } else {
                        if (appNumber == userNumber)
                            diff = 20.00;
                        else if (appNumber > userNumber)
                            diff = appNumber - userNumber;
                        else
                            diff = userNumber - appNumber;
                        Double guessPer = diff * 4.9;
                        if(guessPer>=50)
                            a=1;
                        guessPerStr2 = String.valueOf(guessPer);
                        if (guessPerStr2.length() > 4) {
                            guessPerStr = guessPerStr2.substring(0, 5);
                        } else
                            guessPerStr = guessPerStr2;
                        textView1.setText("Your guessing power is: ");
                        textView.setText(guessPerStr + "%");
                        if(a==1){
                            anim.animate().alpha(1f);
                            anim.animate().translationY(-1500f).setDuration(4500).setStartDelay(500);
                        }
                    }
                }
                catch (Exception e){
                    textView.setText("Error!");
                }


            }
        });
    }


    public void gotoListView(View view) {
        Intent gotoActivity = new Intent(GameActivity.this,listviewactivity.class);
        startActivity(gotoActivity);
    }
}