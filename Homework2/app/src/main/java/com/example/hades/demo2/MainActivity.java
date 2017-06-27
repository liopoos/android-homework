package com.example.hades.demo2;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static android.view.View.TEXT_ALIGNMENT_TEXT_START;
import static android.view.View.TEXT_ALIGNMENT_VIEW_END;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button bt1, bt2, bt3, bt4, bt5;
    int size = 20;
    Integer[] bts = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);
        et.addTextChangedListener(new changeText());
        bt1 = (Button) findViewById(R.id.addText);
        bt2 = (Button) findViewById(R.id.lessText);
        bt3 =  (Button) findViewById(R.id.bt3);
        bt4 =  (Button) findViewById(R.id.bt4);
        bt5 =  (Button) findViewById(R.id.bt5);
        bt1.setOnClickListener(new addClick());
        bt2.setOnClickListener(new lessClick());
        bt3.setOnClickListener(new textClick());
        bt4.setOnClickListener(new textClick());
        bt5.setOnClickListener(new textClick());
        tv.setTextSize(size);
        for (int i = 0; i < 6; i++) {
            new button_click(bts[i]);
        }

    }

    private class button_click {
        button_click(Integer id) {
            Button bt;
            bt = (Button) findViewById(id);
            Drawable background = bt.getBackground();
            ColorDrawable colorDrawable = (ColorDrawable) background;
            int color = colorDrawable.getColor();
            bt.setOnClickListener(new click(color));
        }
    }

    private class changeText implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            tv.setText(s);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tv.setText(s);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private class click implements View.OnClickListener {
        int bt_color;

        click(int color) {
            bt_color = color;
        }

        public void onClick(View v) {
            tv.setTextColor(bt_color);
        }
    }

    private class addClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            tv.setTextSize(++size);

        }
    }

    private class lessClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            tv.setTextSize(--size);

        }
    }


    private class textClick implements View.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.bt3){
                tv.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
                tv.setText("已经左对齐");
            }
            else if(v.getId() == R.id.bt4) {
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setText("已经局中对齐");
            }
            else if(v.getId() == R.id.bt5){
                tv.setTextAlignment(TEXT_ALIGNMENT_VIEW_END);
                tv.setText("已经右对齐");
            }
        }
    }
}
