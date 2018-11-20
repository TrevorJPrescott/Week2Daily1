package com.trevorpc.dailysqlpreference2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.trevorpc.dailysqlpreference2.Constants.SHARE_PREF_NAME;
import static com.trevorpc.dailysqlpreference2.Constants.USER_NAME_KEY;

public class MainActivity extends AppCompatActivity {

    TextView tvUserName;
    EditText etUserName;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
        tvUserName = findViewById(R.id.tvUserName);


        sharedPreferences = getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);


        String userNameToDisplay = sharedPreferences.getString(Constants.USER_NAME_KEY, "NO NAME");
        tvUserName.setText(userNameToDisplay);

    }

    public void ButtonClick(View view)
    {
        switch(view.getId())
        {
            case (R.id.btnUserName):
                if (!etUserName.getText().toString().isEmpty())
                {
                    String userName = etUserName.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(USER_NAME_KEY, userName);
                    editor.commit();
                    tvUserName.setText(userName);
                    break;
                }
            case(R.id.btnToInput):
                {
                    String userName = tvUserName.getText().toString();
                    Intent myIntent = new Intent(this, Input.class);
                    myIntent.putExtra("username", userName);
                    startActivity(myIntent);
                    break;
                }
                case(R.id.btnToOutput):
                {
                    String userName = tvUserName.getText().toString();
                    Intent myIntent = new Intent(this, Output.class);
                    myIntent.putExtra("username", userName);
                    startActivity(myIntent);
                    break;
                }


        }
    }
}
