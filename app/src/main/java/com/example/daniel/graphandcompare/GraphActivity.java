package com.example.daniel.graphandcompare;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
/*import android.support.design.widget.Snackbar;*/
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.daniel.graphandcompare.recorderutils.AudioDataReceivedListener;
import com.example.daniel.graphandcompare.recorderutils.RecordingThread;
import com.newventuresoftware.waveform.WaveformView;

public class GraphActivity extends AppCompatActivity {

    private WaveformView mRealtimeWaveformView;
    RecordingThread mRecordingThread;
    private static final int REQUEST_RECORD_AUDIO = 13;
    Button record;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

       /* mRealtimeWaveformView =  v.findViewById(R.id.waveformView);
        mRecordingThread = new RecordingThread(new AudioDataReceivedListener() {
            @Override
            public void onAudioDataReceived(short[] data) {
                mRealtimeWaveformView.setSamples(data);
            }
        });
        record = v.findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mRecordingThread.recording()) {
                    startAudioRecordingSafe();
                } else {
                    mRecordingThread.stopRecording();
                    listener.onGraphFinished();
                }
            }
        });
        return v;*/
        record= (Button) findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openResult();

            }
        });
    }
    public void openResult() {

        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

  /*  private void startAudioRecordingSafe() {
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_GRANTED) {
            mRecordingThread.startRecording();
        } else {
            requestMicrophonePermission();
        }
    }

    private void requestMicrophonePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.RECORD_AUDIO)) {
            // Show dialog explaining why we need record audio
            Snackbar.make(mRealtimeWaveformView, "Microphone access is required in order to record audio",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{
                            android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
                }
            }).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_RECORD_AUDIO && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mRecordingThread.stopRecording();
        }
    }*/
}
