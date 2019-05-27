package com.example.daniel.graphandcompare;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.IOException;

public class LoadActivity extends AppCompatActivity {
    private Button loadFileButton;
    private TextView textFilePath;
    private Button playFile;
    private Button startButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        loadFileButton = (Button) findViewById(R.id.loadFileButton);
        textFilePath = (TextView) findViewById(R.id.textFilePath);
        playFile = (Button) findViewById(R.id.playFile);
        startButton = (Button) findViewById(R.id.startButton);

        loadFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialFilePicker()
                        .withActivity(LoadActivity.this)
                        .withRequestCode(1000)
                        .withHiddenFiles(true) // Show hidden files and folders
                        .start();


            }
        });

        playFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    audioPlayer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStart();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            textFilePath.setText(filePath);
        }
    }

    public void audioPlayer() throws IOException {

        String filePath = textFilePath.getText().toString();
        Log.i("info",filePath);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(filePath);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    public void openStart(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
