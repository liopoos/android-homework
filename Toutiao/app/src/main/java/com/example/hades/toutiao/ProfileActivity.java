package com.example.hades.toutiao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by hades on 2017/6/17.
 */

public class ProfileActivity extends Activity {
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvTitle = (TextView)findViewById(R.id.my_title);
        tvTitle.setText(getString(R.string.my_title));
    }

}
