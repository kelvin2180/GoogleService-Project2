package com.example.kchu.shared_pref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void save(View view)
    {
        EditText uname = (EditText) findViewById(R.id.name);
        EditText upass = (EditText) findViewById(R.id.pass);
        EditText uphoneNo = (EditText) findViewById(R.id.phoneNo);

        SharedPreferences sharedPreferences = getSharedPreferences(uname.getText().toString(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",uname.getText().toString());
        editor.putString("password",upass.getText().toString());
        editor.putString("phoneNo",uphoneNo.getText().toString());

        editor.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();

    }

    public void display(View view)
    {
        EditText check = (EditText) findViewById(R.id.check);
        SharedPreferences sharedPreferences = getSharedPreferences(check.getText().toString(),MODE_PRIVATE);
        TextView info = (TextView) findViewById(R.id.info);

        if(sharedPreferences.getString("username","")=="")
        {
            info.setText("Name does not exist\n");
        }
        else {
            String name = sharedPreferences.getString("username", "");
            String password = sharedPreferences.getString("password", "");
            String phoneNo = sharedPreferences.getString("phoneNo", "");

            info.setText("Name: ");
            info.append(name);
            info.append("\nAddress: ");
            info.append(password);
            info.append("\nPhone No: ");
            info.append(phoneNo);

        }
    }
    public void starter(View view)
    {
        Intent intent = new Intent(MainActivity.this, StartedService.class);
        startService(intent);
    }


    public void showData(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("EXB",MODE_PRIVATE);
        TextView data = (TextView) findViewById(R.id.data);
        String name = sharedPreferences.getString("name", "");
        data.setText(name);

    }
    public void reset(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("EXB",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","");
        editor.apply();

    }
}
