package com.example.hades.toutiao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hades on 2017/6/17.
 */

public class NewsListDB extends SQLiteOpenHelper {

    public NewsListDB(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists list(_id integer primary key autoincrement,title text,desc text,content text,pubdate text,img text)";
        Log.i("Tag", "create Database");
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Tag", "update Databases");
    }
}