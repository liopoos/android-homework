package com.example.hades.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt, cls;
    CheckBox cb1, cb2, cb3;
    String status = "你选择的是：";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new click());
        cls = (Button) findViewById(R.id.button2);
        cls.setOnClickListener(new clear());
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
    }

    private class click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (cb1.isChecked()) {
                status += cb1.getText();
            }
            if (cb2.isChecked()) {
                status += cb2.getText();
            }
            if (cb3.isChecked()) {
                status += cb3.getText();
            }
            tv.setText(status);
        }
    }

    private class clear implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            status = "你选择的是：";
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            tv.setText(status);
        }
    }
}
