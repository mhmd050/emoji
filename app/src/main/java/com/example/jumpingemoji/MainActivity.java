package com.example.jumpingemoji;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private float x,y;
    Thread thread;
    int levelSpeed=500;
    private Button easy,medium,hard;
    private TextView score,difficulty;
    private int s=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        image=findViewById(R.id.imageView);
        easy=findViewById(R.id.buttonEasy);
        medium=findViewById(R.id.buttonMedium);
        hard=findViewById(R.id.buttonHard);
        score=findViewById(R.id.textViewScore);
        difficulty=findViewById(R.id.textViewDifficulty);

        thread=new Thread(()->{
            try{
                while(true){
                    startMoveImage();
                    Thread.sleep(levelSpeed);
                }
            }
            catch (Exception e){

            }
        });
        thread.start();
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSpeed=1500;
                difficulty.setText("easy");
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSpeed=1000;
                difficulty.setText("medium");
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelSpeed=500;
                difficulty.setText("hard");
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;
                score.setText("score:"+s);
            }
        });
    }
    private void startMoveImage (){
        x=(float) Math.random()*800;
        y=(float) Math.random()*1200+400;
        image.setX(x);
        image.setY(y);

    }
}