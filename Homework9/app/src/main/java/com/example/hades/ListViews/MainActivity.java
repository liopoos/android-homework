package com.example.hades.ListViews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    //private List<String> data = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        //listView = (ListView)findViewById(R.id.)
        SimpleAdapter adapter = new SimpleAdapter(this, getData(), R.layout.listview,
                new String[]{"title", "info", "img"},
                new int[]{R.id.title, R.id.info, R.id.img});
        listView.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "阿鲁1");
        map.put("info", "这是第一个阿鲁表情");
        map.put("img", R.drawable.i1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "阿鲁2");
        map.put("info", "这是第二个阿鲁表情");
        map.put("img", R.drawable.i2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "阿鲁3");
        map.put("info", "这是第三个阿鲁表情");
        map.put("img", R.drawable.i3);
        list.add(map);

        return list;
    }


}
