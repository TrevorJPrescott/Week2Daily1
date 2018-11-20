package com.trevorpc.dailysqlpreference2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Output extends AppCompatActivity {



    TextView tvWelcome;
    TextView tvName;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvSkype;
    TextView tvFace;
    SQLhelper sql = new SQLhelper(this,null);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        tvWelcome = findViewById(R.id.tvWelcome);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvSkype = findViewById(R.id.tvSkype);
        tvFace = findViewById(R.id.tvFace);

        String savedExtra = getIntent().getStringExtra("username");

        Cursor cur = sql.getUsersByName(savedExtra);
        Log.d("TAG", "onCreate: "+cur.getColumnNames());




//                                Cursor cur = mySqlLiteHelper.getUsersByName(etUserName.getText().toString());
//                        cur.moveToFirst();
//                        int uNameIndex = cur.getColumnIndex(Constants.USER_NAME_KEY);
//                        int pWordIndex = cur.getColumnIndex(Constants.PASSWORD);
//                        String returnUserName = cur.getString(uNameIndex);
//                        String returnPassword = cur.getString(pWordIndex);
//                        tvPassword.setText(returnPassword);
//                        tvDisplayUserName.setText(returnUserName);





        String welcome = "Welcome, " + savedExtra;
        tvWelcome.setText(welcome);
    }

    public void back(View view)
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }



}