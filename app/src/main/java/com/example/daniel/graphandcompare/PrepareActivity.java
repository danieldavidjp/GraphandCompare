package com.example.daniel.graphandcompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrepareActivity extends AppCompatActivity {

    private Button prepButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        prepButton= (Button) findViewById(R.id.prepButton);
        prepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGraph();

            }
        });
    }

    public void openGraph() {

        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }
}
