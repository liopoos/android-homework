package com.example.hades.toutiao;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by hades on 2017/6/17.
 */

public class LikeActivity extends AppCompatActivity {
    private ListView likeListView;
    AddLikeItem likeItem = new AddLikeItem(this);
    List<Map<String, String>> data;
    News newsItem = new News(null,null,null,null,null);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        likeListView = (ListView) findViewById(R.id.list);
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.like_list,
                new String[]{"news_title", "news_desc"},
                new int[]{R.id.like_title, R.id.like_desc});
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                if (view instanceof ImageView) {
                    URL url = null;
                    try {
                        url = new URL((String) data);
                        ImageView iv = (ImageView) view;
                        iv.setImageBitmap(BitmapFactory.decodeStream(url.openStream()));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } else
                    return false;
            }
        });
        likeListView.setAdapter(adapter);
        likeListView.setOnItemClickListener(new listener());

    }

    private List<Map<String, String>> getData() {
        data = likeItem.Query();
        return data;

    }


    private class listener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map map = (Map)data.get((int) id);
            newsItem.setTitle((String)map.get("news_title"));
            newsItem.setDesc((String)map.get("news_desc"));
            newsItem.setContent((String)map.get("news_content"));
            newsItem.setPhotoId((String)map.get("news_img"));
            newsItem.setPubDate((String)map.get("news_pubdata"));
            Log.i("Tag", String.valueOf(newsItem.getContent()));
            Intent intent = new Intent(LikeActivity.this, NewsActivity.class);
            intent.putExtra("News", newsItem);
            LikeActivity.this.startActivity(intent);
        }
    }
}


