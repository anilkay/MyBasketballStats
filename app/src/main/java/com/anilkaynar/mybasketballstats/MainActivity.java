package com.anilkaynar.mybasketballstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent goIntent;
     public double calculateEFg(int Fg,int p3,double Fga) {
         return (Fg+0.5*p3)/Fga;
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goEnter(View v) {
        goIntent=new Intent(this,enterStats.class);
        startActivity(goIntent);

    }
    public void goStat(View v) {
        goIntent=new Intent(this,showStats.class);
        startActivity(goIntent);
    }
    public void submitandSql(View view) {

    }
}
