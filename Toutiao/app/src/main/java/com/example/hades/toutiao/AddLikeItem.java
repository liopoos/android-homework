package com.example.hades.toutiao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hades on 2017/6/17.
 */

public class AddLikeItem {
    public Context context;
    public String newsTitle, newsDesc, newsContent, newsImg, newsPubDate;


    public AddLikeItem(Context context) {
        this.context = context;
        Log.i("Tag", "context2" + String.valueOf(context));

    }


    public void Creat() {
        NewsListDB listDB = new NewsListDB(context, "news.db", null, 2);
        SQLiteDatabase db = listDB.getReadableDatabase();
        Log.i("Tag", "Creat");
    }

    public void Update() {
        NewsListDB listDB = new NewsListDB(context, "news.db", null, 3);
        SQLiteDatabase db = listDB.getReadableDatabase();
        Log.i("Tag", "Update");
    }

    public void Insert(String t, String d, String c, String i, String p) {
        NewsListDB listDB = new NewsListDB(context, "news.db", null, 2);
        SQLiteDatabase db = listDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", t);
        cv.put("desc", d);
        cv.put("content", c);
        cv.put("img", i);
        cv.put("pubdate", p);
        db.insertOrThrow("list", null, cv);
        Log.i("Tag", "Indert");
        db.close();
    }

    public List<Map<String, String>> Query() {
        NewsListDB dbHelper = new NewsListDB(context, "news.db", null, 2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("list", new String[]{"title", "desc", "content", "img", "pubdate"}, null, null, null, null, null);
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        while (cursor.moveToNext()) {
            Map map = new HashMap<String, String>();
            map.put("news_title", cursor.getString(cursor.getColumnIndex("title")));
            map.put("news_desc", cursor.getString(cursor.getColumnIndex("desc")));
            map.put("news_img", cursor.getString(cursor.getColumnIndex("img")));
            map.put("news_content", cursor.getString(cursor.getColumnIndex("content")));
            map.put("news_pubdate", cursor.getString(cursor.getColumnIndex("pubdate")));
            data.add(map);
        }
        cursor.close();
        db.close();
        return data;
    }

    public void Delete() {
        NewsListDB listDB = new NewsListDB(context, "news.db", null, 2);
        SQLiteDatabase db = listDB.getReadableDatabase();
        String whereClauses = "id=?";
        String[] whereArgs = {String.valueOf(2)};
        db.delete("stu_table", whereClauses, whereArgs);
    }
}
