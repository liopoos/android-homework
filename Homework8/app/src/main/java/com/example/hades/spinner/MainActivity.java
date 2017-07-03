package com.example.hades.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<String>();
    Spinner sp;
    ImageView iv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("image0");
        list.add("image1");
        list.add("image2");
        list.add("image3");
        list.add("image4");
        sp = (Spinner)findViewById(R.id.spinner);
        iv = (ImageView)findViewById(R.id.imageView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new itemSelected());
    }

    private class itemSelected implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) parent.getAdapter();
            switch (adapter.getItem(position)){
                case "image0":iv.setImageDrawable(getResources().getDrawable(R.drawable.pic_1));break;
                case "image1":iv.setImageDrawable(getResources().getDrawable(R.drawable.pic_2));break;
                case "image2":iv.setImageDrawable(getResources().getDrawable(R.drawable.pic_3));break;
                case "image3":iv.setImageDrawable(getResources().getDrawable(R.drawable.pic_4));break;
                case "image4":iv.setImageDrawable(getResources().getDrawable(R.drawable.pic_5));break;
            }


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
