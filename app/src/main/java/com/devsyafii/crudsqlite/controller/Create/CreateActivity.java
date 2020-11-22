/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.Create;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;

public class CreateActivity extends AppCompatActivity {
    private DataHelper dbhelper;
    private EditText mName, mClass;
    private Button mSubmit;
    private String sName, sClass;
    private Student student;
    private ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbhelper = new DataHelper(this);
        student = new Student();
        mName = findViewById(R.id.mName);
        mClass = findViewById(R.id.mClass);
        mSubmit = findViewById(R.id.btn_submit);
        imBack = findViewById(R.id.mToolbarBack);

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = mName.getText().toString();
                sClass = mClass.getText().toString();
                if (sName.equals("")) {
                    mName.requestFocus();
                    Toast.makeText(CreateActivity.this, "Plase enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    if (sClass.equals("")) {
                        mClass.requestFocus();
                        Toast.makeText(CreateActivity.this, "Plase enter your class", Toast.LENGTH_SHORT).show();
                    } else {
                        mName.setText("");
                        mClass.setText("");
                        Toast.makeText(CreateActivity.this, "Create Success", Toast.LENGTH_SHORT).show();
                        student.setName(sName);
                        student.setClasses(sClass);
                        dbhelper.createStudent(student);
                    }
                }
            }
        });
    }
}
