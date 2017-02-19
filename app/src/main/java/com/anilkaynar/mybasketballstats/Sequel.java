package com.anilkaynar.mybasketballstats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anilkaynar on 19.02.2017.
 */

public class Sequel extends SQLiteOpenHelper {
    SQLiteDatabase db;
    Sequel(Context context) {
        super(context,"Word",null,1);
        db= this.getWritableDatabase();
    }
    Sequel(Context c, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(c,name,factory,version);
    }
    public boolean insertdata(double Fg,double yFg,int p3m,double Efg,double yp3) {
        ContentValues values= new ContentValues();
        values.put("Fg",Fg);
        values.put("yFg",yFg);
        values.put("p3",p3m);
        values.put("y3p",yp3);
       long chk=db.insert("stats",null,values);
        if(chk==-1) {
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getallda() {
        db=this.getReadableDatabase();
        Cursor result=db.rawQuery("select* from stats",null);
        return result;
    }
   public void Deletedata(int id) {
       db=getWritableDatabase();
       db.execSQL("Delete from stats where id="+id);
   }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         sqLiteDatabase.execSQL("Create Table stats (id integer primary key autoincrement,FG Real,"
                 + "yFG Real,p3 integer,y3p Real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
