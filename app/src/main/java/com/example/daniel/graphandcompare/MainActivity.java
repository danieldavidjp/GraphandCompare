package com.example.daniel.graphandcompare;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button graphButton;
    private Button loadButton;
    private Button tutorialButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1001);


        }
        graphButton= (Button) findViewById(R.id.graphButton);
        graphButton.setOnClickListener(new View.OnClickListener() {
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

        tutorialButton = (Button) findViewById(R.id.tutorialButton);
        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTutorial();
            }
        });
    }

    public void openPrepare() {

        Intent intent = new Intent(this, PrepareActivity.class);
        startActivity(intent);
    }

    public void openLoad() {

        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

    public void openTutorial(){

        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1001: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permission Granted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        }
    }
}
