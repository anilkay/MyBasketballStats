package com.anilkaynar.mybasketballstats;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anilkaynar on 19.02.2017.
 */

public class NeAdapter extends BaseAdapter {
    ArrayList <Stat> stat;
    LayoutInflater layoutInflater;
    @Override
    public int getCount() {
        return stat.size();
    }
    NeAdapter(Activity activity, ArrayList<Stat> kis) {
        layoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        stat = kis;
    }

    @Override
    public Object getItem(int i) {
        return (Object) stat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satir;
        satir= layoutInflater.inflate(R.layout.listtt,null);
        TextView textfg= (TextView) satir.findViewById(R.id.Fg);
        TextView textyfg=(TextView) satir.findViewById(R.id.yfg);
        TextView p33=(TextView) satir.findViewById(R.id.p3);
        TextView yp3=(TextView) satir.findViewById(R.id.yp3);
        TextView effg=(TextView) satir.findViewById(R.id.efg);
        Stat st= stat.get(i);
        textyfg.setText(st.getyFg()+"");
        textfg.setText(st.getyFg()+"");
        p33.setText(st.getP3()+"");
        yp3.setText(st.getYp3()+"");
        effg.setText(st.getEfg()+"");
        return satir;
    }
}
