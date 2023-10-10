package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.team35.R;
import com.google.android.material.textfield.TextInputEditText;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Button restartButton = findViewById(R.id.restartButton);

        restartButton.setOnClickListener(v -> {
            // Start the game activity
            Intent intent = new Intent(EndActivity.this,
                    WelcomeActivity.class);
            startActivity(intent);
        });

        TextView score = findViewById(R.id.Score);
        score.setText("Recent Score");

        TextView leaderBoard1 = findViewById(R.id.Leaderboard1);
        TextView leaderBoard2 = findViewById(R.id.Leaderboard2);
        TextView leaderBoard3 = findViewById(R.id.Leaderboard3);
        TextView leaderBoard4 = findViewById(R.id.Leaderboard4);
        TextView leaderBoard5 = findViewById(R.id.Leaderboard5);
        TextView leaderBoard6 = findViewById(R.id.Leaderboard6);
        TextView leaderBoard7 = findViewById(R.id.Leaderboard7);

        leaderBoard1.setText("1");
        leaderBoard2.setText("2");
        leaderBoard3.setText("3");
        leaderBoard4.setText("4");
        leaderBoard5.setText("5");
        leaderBoard6.setText("6");
        leaderBoard7.setText("7");



    }

}