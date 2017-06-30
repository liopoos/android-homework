package com.example.hades.homework5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, clear;
    TextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        clear = (Button) findViewById(R.id.clear);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        login.setOnClickListener(new click1());
        clear.setOnClickListener(new click2());
    }

    private class click1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (username.toString().isEmpty() || password.toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "请填写完整",
                        Toast.LENGTH_SHORT).show();
            } else {
                if (username.getText().toString().equals("e10001") && password.getText().toString().equals("1234567")) {
                    Toast.makeText(getApplicationContext(), "登录成功",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "用户名或密码错误",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class click2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            username.setText("");
            password.setText("");

        }
    }
}
