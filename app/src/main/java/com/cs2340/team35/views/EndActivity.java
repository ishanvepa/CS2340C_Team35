package com.cs2340.team35.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.cs2340.team35.R;
import com.cs2340.team35.models.GameModel;
import com.cs2340.team35.models.LeaderboardModel;
import com.cs2340.team35.models.PlayerModel;
import com.cs2340.team35.models.ScoreModel;

import java.util.ArrayList;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_end);

        TextView winLoseText = findViewById(R.id.winLoseText);
        PlayerModel playerModel = PlayerModel.getInstance();

        if (playerModel.getHealth() <= 0) {
            winLoseText.setText("You Lost!");
            winLoseText.setTextColor(Color.RED); // Set text color to red for losing
        } else {
            winLoseText.setText("You Won!");
            winLoseText.setTextColor(Color.GREEN); // Set text color to green for winning
        }


        Button restartButton = findViewById(R.id.restartButton);

        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(EndActivity.this,
                    WelcomeActivity.class);
            startActivity(intent);
        });

        TextView score = findViewById(R.id.Score);

        //PlayerModel playerModel = PlayerModel.getInstance();
        LeaderboardModel leaderboardModel = LeaderboardModel.getInstance();

        score.setText(String.format("Most recent score: %d",
                playerModel.getScore().getCurrentScore()));

        TextView[] leaderBoards = new TextView[] {
            findViewById(R.id.Leaderboard1), findViewById(R.id.Leaderboard2),
                findViewById(R.id.Leaderboard3), findViewById(R.id.Leaderboard4),
                findViewById(R.id.Leaderboard5), findViewById(R.id.Leaderboard6),
                findViewById(R.id.Leaderboard7)
        };

        ArrayList<ScoreModel> scoreData = leaderboardModel.getScores();

        for (int i = 0; i < scoreData.size(); i++) {
            if (i >= 7) {
                break;
            }

            leaderBoards[i].setText(
                    String.format("Score %d: %d", i + 1,
                            scoreData.get(scoreData.size() - i - 1).getCurrentScore()));
        }
    }

}