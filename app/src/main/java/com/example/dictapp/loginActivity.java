package com.example.dictapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
EditText et_userid,et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_userid=(EditText)findViewById(R.id.et_userid);
        et_pass=(EditText)findViewById(R.id.et_pass);
    }
    public void login(View view)
    {
        if(et_userid.getText().toString().isEmpty())
        {
            et_userid.setError("empty");
            et_userid.requestFocus();
        }
        else
            {
                if(et_pass.getText().toString().isEmpty())
                {
                    et_pass.setError("empty");
                    et_pass.requestFocus();
                }
                else
                    {
                    //write code for login
                        String userid=et_userid.getText().toString().trim();
                        String password=et_pass.getText().toString().trim();
                        int text;
                        if(userid.equals("ojaswi") && password.equals("ojju@123"))
                        {
                            //Toast.makeText(this, "valid user", Toast.LENGTH_SHORT).show();
                            Intent I=new Intent(this,AddWord.class);
                            startActivity(I);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
                            et_userid.setText("");
                            et_pass.setText("");
                        }


                }
        }
    }
}
