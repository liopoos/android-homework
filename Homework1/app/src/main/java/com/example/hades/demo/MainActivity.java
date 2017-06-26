package com.example.hades.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView);
        bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new click());
    }

    private class click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (img.isShown()) {
                img.setVisibility(View.INVISIBLE);
                bt.setText("show");
            } else {
                img.setVisibility(View.VISIBLE);
                bt.setText("fade");
            }
        }
    }
}
