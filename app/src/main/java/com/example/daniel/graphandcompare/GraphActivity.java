package com.example.daniel.graphandcompare;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
/*import android.support.design.widget.Snackbar;*/
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.daniel.graphandcompare.recorderutils.AudioDataReceivedListener;
import com.example.daniel.graphandcompare.recorderutils.RecordingThread;
import com.newventuresoftware.waveform.WaveformView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class GraphActivity extends AppCompatActivity {

    Button record, stopRecord;
    String pathSave ="";
    MediaRecorder mediaRecorder;

    final int REQUEST_PERMISION_CODE = 1000;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        if(!checkPermissionFromDevice())
            requestPermissions();


        record = (Button) findViewById(R.id.record);
        stopRecord = (Button) findViewById(R.id.stopRecord);
        if(checkPermissionFromDevice()) {




            record.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar date =Calendar.getInstance();

                    SimpleDateFormat dateSet = new SimpleDateFormat("dd-MM-yyy_hh:mm:ss");
                    String dateString = dateSet.format(date.getTime());


                    Log.i("date", dateString);
                    pathSave= Environment.getExternalStorageDirectory()
                            .getAbsolutePath() + "/"
                            + dateString +"_Heart_audio.3gp";
                    setupMediaRecorder();
                    try {
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                        } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });

            stopRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaRecorder.stop();
                    openResult();
                }
            });

        }else{

            requestPermissions();
        }



    }

    private void setupMediaRecorder() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(pathSave);
    }

    private void requestPermissions(){

        ActivityCompat.requestPermissions(this,new String[] {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        }, REQUEST_PERMISION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_PERMISION_CODE:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"permission granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkPermissionFromDevice() {

        int write_external_storage_result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }

    public void openResult() {

        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }


}
