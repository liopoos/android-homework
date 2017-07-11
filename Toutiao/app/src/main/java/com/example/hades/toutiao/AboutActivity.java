package com.example.hades.toutiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hades on 2017/6/17.
 */

public class AboutActivity extends Activity{
    TextView tvTitle,tvContent;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tvTitle = (TextView)findViewById(R.id.about_title);
        tvContent = (TextView)findViewById(R.id.about_content);
        tvTitle.setText(getString(R.string.about_title));
        tvContent.setText(getString(R.string.about_content));



    }


}
