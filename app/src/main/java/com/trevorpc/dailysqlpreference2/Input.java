package com.trevorpc.dailysqlpreference2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.trevorpc.dailysqlpreference2.Constants.USER_NAME_KEY;

public class Input extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    EditText etPhone;
    EditText etEmail;
    EditText etSkype;
    EditText etFacebook;
    TextView tvUser;


    SQLhelper sqlHelp = new SQLhelper(this,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);



        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etSkype = findViewById(R.id.etSkype);
        etFacebook = findViewById(R.id.etFace);
        tvUser = findViewById(R.id.tvUser);








        String savedExtra = getIntent().getStringExtra("username");


        String welcome = "Welcome, " + savedExtra;
        tvUser.setText(savedExtra);
        tvWelcome.setText(welcome);
    }


    public void back(View view)
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void btnEnter(View view)
    {
        String user = tvUser.getText().toString();
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String skype = etSkype.getText().toString();
        String facebook = etFacebook.getText().toString();
        sqlHelp.insertInput(user,name,phone,email,skype,facebook);


    }
}