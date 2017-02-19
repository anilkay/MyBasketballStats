package com.anilkaynar.mybasketballstats;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class showStats extends AppCompatActivity {
ListView listView;
    Sequel data;
    ArrayList <Stat> olay=new <Stat> ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);
        data=new Sequel(getApplicationContext());
          listView=(ListView) findViewById(R.id.list);
        getData();
        NeAdapter adap= new NeAdapter(this,olay);
         listView.setAdapter(adap);
    }
    public void getData() {
       Cursor c=data.getallda();
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++) {
            Log.e("cursor"," "+c.getDouble(1)+c.getDouble(2));
            olay.add(new Stat(c.getDouble(1),c.getDouble(2),c.getInt(3),c.getDouble(4),0.50));
            c.moveToNext();
        }
    }
}
