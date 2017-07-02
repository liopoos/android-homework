package com.example.hades.homework7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv, tv2;
    int x = 0, y = 0, opt = 0;
    String t = "";
    Integer[] bts = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.jia, R.id.jian, R.id.cheng, R.id.chu, R.id.clear, R.id.dengyu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button[] num = new Button[bts.length];
        for (int i = 0; i < bts.length; i++) {
            num[i] = (Button) findViewById(bts[i]);
            num[i].setOnClickListener(new num_click());
        }
    }

    private class num_click implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button bt;
            bt = (Button) v;
            tv = (TextView) findViewById(R.id.textView);
            tv2 = (TextView) findViewById(R.id.textView2);
            switch (bt.getId()) {
                case R.id.button0: {
                    if (!t.isEmpty()) {
                        t += 0;
                        tv.setText(t);
                    } else {
                        tv.setText("0");
                    }
                    break;
                }
                case R.id.button1: {
                    t += 1;
                    tv.setText(t);
                    break;
                }
                case R.id.button2: {
                    t += 2;
                    tv.setText(t);
                    break;
                }
                case R.id.button3: {
                    t += 3;
                    tv.setText(t);
                    break;
                }
                case R.id.button4: {
                    t += 4;
                    tv.setText(t);
                    break;
                }
                case R.id.button5: {
                    t += 5;
                    tv.setText(t);
                    break;
                }
                case R.id.button6: {
                    t += 6;
                    tv.setText(t);
                    break;
                }
                case R.id.button7: {
                    t += 7;
                    tv.setText(t);
                    break;
                }
                case R.id.button8: {
                    t += 8;
                    tv.setText(t);
                    break;
                }
                case R.id.button9: {
                    t += 9;
                    tv.setText(t);
                    break;
                }
                case R.id.jia: {
                    opt = 1;
                    tv2.setText("+");
                    cmp();
                    break;
                }
                case R.id.jian: {
                    opt = 2;
                    tv2.setText("-");
                    cmp();
                    break;
                }
                case R.id.cheng: {
                    opt = 3;
                    tv2.setText("*");
                    cmp();
                    break;
                }
                case R.id.chu: {
                    opt = 4;
                    tv2.setText("/");
                    cmp();
                    break;
                }
                case R.id.clear: {
                    init();
                    break;
                }
                case R.id.dengyu: {
                    dengyu();
                    break;
                }
            }


        }

        private void cmp() {
            x = Integer.parseInt(t);
            t = "";
            Toast.makeText(getApplicationContext(), "x的值为" + x,
                    Toast.LENGTH_SHORT).show();
        }

        private void dengyu() {
            y = Integer.parseInt(t);
            int z = 0;
            switch (opt) {
                case 1:
                    z = x + y;
                    break;
                case 2:
                    z = x - y;
                    break;
                case 3:
                    z = x * y;
                    break;
                case 4: {
                    if (y == 0) {
                        tv.setText("错误，除数不能为0");
                    } else {
                        z = x / y;
                    }
                }
                break;
                default:z = y;
            }
            tv.setText(Integer.toString(z));
            t = Integer.toString(z);
            x = z;
            y = z;
            tv2.setText("opt");
            opt = 0;
        }


        private void init() {
            opt = 0;
            x = 0;
            y = 0;
            t = "";
            tv2.setText("opt");
            tv.setText("0");
        }
    }
}
