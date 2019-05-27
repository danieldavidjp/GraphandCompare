package com.example.daniel.graphandcompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    private Button backPrepButton;
    private Button loadButton;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backPrepButton= (Button) findViewById(R.id.backPrepButton);
        backPrepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPrepare();

            }
        });

        loadButton= (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLoad();

            }
        });
        startButton= (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStart();
            }
        });
    }


    public void openLoad() {

        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

    public void openPrepare() {

        Intent intent = new Intent(this, PrepareActivity.class);
        startActivity(intent);
    }
    public void openStart(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
