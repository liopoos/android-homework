package com.example.hades.toutiao;

import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hades on 2017/6/12.
 */

public class NewsActivity extends AppCompatActivity {
    private ImageView newsPhoto;
    private TextView newsTitle;
    private TextView newsContent;
    private TextView newsTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        newsPhoto = (ImageView) findViewById(R.id.news_info_photo_bar);
        newsTitle = (TextView) findViewById(R.id.news_info_title);
        newsContent = (TextView) findViewById(R.id.news_info_content);
        newsTime = (TextView) findViewById(R.id.news_info_time);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_back);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Snackbar.make(view, "返回主页", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null).show();
            }
        });


        Intent intent = getIntent();

        News item = (News) intent.getSerializableExtra("News");
        URL url = null;
        try {
            url = new URL(item.getImg());
            newsPhoto.setImageBitmap(BitmapFactory.decodeStream(url.openStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        newsTitle.setText(item.getTitle());
        newsContent.setText(item.getContent());
        newsTime.setText("时间：" + item.getPubDate());

    }
}
