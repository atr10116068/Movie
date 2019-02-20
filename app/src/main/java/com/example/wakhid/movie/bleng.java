package com.example.wakhid.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class bleng extends AppCompatActivity {
    TextView detail,id,date,judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);

        detail = (TextView) findViewById(R.id.dDetail);
        id = (TextView) findViewById(R.id.dId);
        date = (TextView) findViewById(R.id.dDate);
        judul = (TextView) findViewById(R.id.dJudul);

        detail.setText(getIntent().getStringExtra("detail"));
        id.setText(getIntent().getStringExtra("id"));
        date.setText(getIntent().getStringExtra("date"));
        judul.setText(getIntent().getStringExtra("judul"));
    }
}
