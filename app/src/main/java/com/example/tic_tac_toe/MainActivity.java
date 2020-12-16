package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //     0-X
    //     1-O
    boolean gameAct = true;
    int activeP = 0;
    int[] gameS = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // state mean
    // 0 - X
    // 1 - O
    // 2 - blank

    int[][] winP = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tapImg = Integer.parseInt(img.getTag().toString());
        if (!gameAct){
            reset(view);
            TextView status = findViewById(R.id.status);
            status.setText("X's turn - Tap to play");
            return;
        }
        if (gameS[tapImg] == 2) {
            gameS[tapImg] = activeP;
            img.setTranslationY(-1000f);
            if (activeP == 0) {
                activeP = 1;
                img.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activeP = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }


        // check if any player has won
        for (int[] winpos : winP) {
            if (gameS[winpos[0]] == gameS[winpos[1]] && gameS[winpos[1]] == gameS[winpos[2]] && gameS[winpos[0]] != 2) {
                // somebody won - find who
                gameAct = false;
                String winner;
                if(gameS[winpos[0]] == 0){
                    winner = "X has Won";
                }
                else
                {
                    winner = "O has Won";
                }
                // announce winner with status bar
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }

    }

    public  void reset(View view){
        gameAct= true;
        activeP = 0 ;
        for (int i=0; i<gameS.length;i++){
            gameS[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}