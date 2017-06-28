package com.example.hades.homework3;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    RadioButton man, women;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) this.findViewById(R.id.textView);
        RadioGroup group = (RadioGroup) this.findViewById(R.id.radiogroup);
        man = (RadioButton) findViewById(R.id.man);
        women = (RadioButton) findViewById(R.id.women);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                String msg = "";
                if (man.getId() == checkedId) {
                    msg = "当前选中的性别为:男";
                }
                if (women.getId() == checkedId) {
                    msg = "当前选中的性别为:女";
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
