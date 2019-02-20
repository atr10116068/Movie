package com.example.wakhid.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class showImage extends AppCompatActivity {
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        im = (ImageView) findViewById(R.id.show_id);
        load();
    }

    void load(){
        Glide.with(this)
                .load(getIntent().getStringExtra("src"))
                .into(im);
    }
}
