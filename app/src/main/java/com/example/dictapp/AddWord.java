package com.example.dictapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddWord extends AppCompatActivity {

    EditText et_word,et_meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        et_word=(EditText)findViewById(R.id.et_word);
        et_meaning=(EditText)findViewById(R.id.et_meaning);
    }
    public void add(View view)
    {
        if(et_word.getText().toString().isEmpty())
        {
            et_word.setError("empty");
            et_word.requestFocus();
        }
        else
        {
            if(et_meaning.getText().toString().isEmpty())
            {
                et_meaning.setError("empty");
                et_meaning.requestFocus();
            }
            else
            {
                String word=et_word.getText().toString().trim();
                String meaning=et_meaning.getText().toString().trim();
                DbManager dm=new DbManager(this);//make database object
                SQLiteDatabase db=dm.getWritableDatabase();
                String query="insert into dict values('"+word+"','"+meaning+"')";
                db.execSQL(query);//all queries get executed by this methoded
                Toast.makeText(this,"The word and meaning are added", Toast.LENGTH_SHORT).show();

                et_word.setText("");
                et_meaning.setText("");

            }
        }


    }
}
