package com.example.sharedpreference_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEdt,depEdt,regEdt,semEdt,cgpaEdt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdt=(EditText) findViewById(R.id.nameedt);
        depEdt=(EditText) findViewById(R.id.depedt);
        regEdt=(EditText) findViewById(R.id.regedt);
        semEdt=(EditText) findViewById(R.id.semedt);
        cgpaEdt=(EditText) findViewById(R.id.cgpaedt);
        saveBtn=(Button) findViewById(R.id.savebtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Information Saved!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
         String name=nameEdt.getText().toString();
               String department=depEdt.getText().toString();
               String registration=regEdt.getText().toString();
               Integer semester=Integer.valueOf(semEdt.getText().toString());
               Float cgpa=Float.valueOf(cgpaEdt.getText().toString());
                SharedPreferences sharedPreferences=getSharedPreferences("studentinfo",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("department",department);
                editor.putInt("semester",semester);
                editor.putString("registration", registration);
                editor.putFloat("cgpa",cgpa);
                editor.commit();
//                SharedPreferences sharedPreferences1=getSharedPreferences("studentinfo",MODE_PRIVATE);
//                Toast.makeText(MainActivity.this,sharedPreferences1.getString("name",""),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
////        Intent intent=new Intent(MainActivity.this,ShowData.class);
////        startActivity(intent);
        SharedPreferences sharedPreferences=getSharedPreferences("studentinfo",MODE_PRIVATE);
        nameEdt.setText(sharedPreferences.getString("name",""));
        depEdt.setText(sharedPreferences.getString("department",""));
        regEdt.setText(sharedPreferences.getString("registration",""));
        String semester=String.valueOf(sharedPreferences.getInt("semester", 0));
        semEdt.setText(semester);
        String val=String.valueOf(sharedPreferences.getFloat("cgpa",0));
        cgpaEdt.setText(val);
    }
}
