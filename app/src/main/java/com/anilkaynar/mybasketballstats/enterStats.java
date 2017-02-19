package com.anilkaynar.mybasketballstats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class enterStats extends AppCompatActivity {
int point3made=0;
    int pointThreeattmp=0;
    int p2made=0;
    int p2attemp=0;
    TextView textView1;
    TextView textView2;
    Sequel sql;
    TextView TextView5;
    TextView textview7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stats);
       textView1=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView3);
        TextView5=(TextView)findViewById(R.id.textView5);
        textview7=(TextView)findViewById(R.id.textView7);
        sql= new Sequel(getApplicationContext());
    }
    public void incrementp3atmp(View v) {
        pointThreeattmp++;
        textView1.setText(pointThreeattmp+"");
    }
    public void  decrementp3atmp(View v) {
        pointThreeattmp--;
        if(pointThreeattmp<0) {
            pointThreeattmp=0;
        }
        textView1.setText(pointThreeattmp+"");
    }
    public void incrementp3made(View v) {
        point3made++;
        textView2.setText(point3made+"");
    }
    public void  decrementp3made(View v) {
        point3made--;
        if(point3made<0) {
            point3made=0;
        }
        textView2.setText(point3made+"");
    }
    public void incrementpoint2attempt(View view) {
        p2attemp++;
         TextView5.setText(p2attemp+"");
    }
    public void decrementpoint2attempt(View view) {
        p2attemp--;
        if(p2attemp<0) {
            p2attemp=0;
        }
        TextView5.setText(p2attemp+"");

    }
    public void incrementpoint2made(View v) {
        p2made++;
        textview7.setText(p2made+"");
    }
    public void decrementpoint2made(View v) {
        p2made--;
        if(p2made<0) {
            p2made=0;
        }
        textview7.setText(p2made+"");
    }
    public double calculateEFg(int Fg,int p3,double Fga) {
        if(Fga==0)
            return -1;
        return (Fg+0.5*p3)/Fga;
    }
    public void submitandsql(View v) {
       int Fg=pointThreeattmp+p2attemp;
        boolean a=false;
       double yfg=(point3made+p2made)/(double)Fg;
        double efg=calculateEFg(p2made+point3made,point3made,Fg);
        if(efg==-1) {
            Toast.makeText(getApplicationContext(),"Efg hasaplanamıyor.",Toast.LENGTH_SHORT).show();
        }
        else {
             a = sql.insertdata(Fg, yfg, point3made, (point3made / pointThreeattmp), efg);
        }
        if(a) {
            Toast.makeText(getApplicationContext(),"Kayıt başarıyla eklendi.",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Kayıt yalan oldu.",Toast.LENGTH_SHORT).show();
        }
   }
}
