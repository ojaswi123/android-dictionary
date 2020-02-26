package com.example.dictapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView actv_word;
TextView tv_meaning;
ArrayAdapter AD;
SQLiteDatabase db;
DbManager dm;
String query;
Cursor c;
ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv_word=(AutoCompleteTextView)findViewById(R.id.actv_word);
        tv_meaning=(TextView)findViewById((R.id.tv_meaning));
        al=new ArrayList<String>();
        dm=new DbManager(this);
        db=dm.getWritableDatabase();
        query="select word from dict";
       c=db.rawQuery(query,null);
       boolean res=c.moveToFirst();
       while(res)
       {
           al.add(c.getString(0));
           res=c.moveToNext();
       }
       AD=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,al);
       actv_word.setAdapter(AD);
       actv_word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String word=AD.getItem(position).toString();
            query="select meaning from dict where word='"+word+"'";
            c=db.rawQuery(query,null);
            if(c.moveToFirst())
            {
                tv_meaning.setText(c.getString(0));
            }
           }
       });





    }
    public void addword(View view)
    {
        Intent I=new Intent(this,loginActivity.class);
        startActivity(I);
        finish();
    }



}
