/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.Update;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;

public class UpdateActivity extends AppCompatActivity {

    private DataHelper database;
    private String id, name, classes;
    private EditText mId, mName, mClass;
    private Button btnUpdate, btnShow;
    ImageView imBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new DataHelper(this);

        mId = findViewById(R.id.et_showId);
        mName = findViewById(R.id.et_Name);
        mClass = findViewById(R.id.et_classes);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnShow = findViewById(R.id.btnShow);
        imBack = findViewById(R.id.mToolbarBack);

        mName.setText(name);
        mClass.setText(classes);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                classes = mClass.getText().toString();
                if (name.equals("")){
                    mName.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                }else {
                    if (classes.equals("")){
                        Toast.makeText(UpdateActivity.this, "Please enter your Class", Toast.LENGTH_SHORT).show();
                    }else {
                        long l = Long.parseLong(id);
                        database.updateStudent(l,name,classes);
                        Toast.makeText(UpdateActivity.this, "Data success update..", Toast.LENGTH_SHORT).show();
                        mId.setText("");
                        mName.setText("");
                        mClass.setText("");
                    }
                }

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = mId.getText().toString();
                if (id.equals("")){
                    Toast.makeText(UpdateActivity.this, "Please enter your ID", Toast.LENGTH_SHORT).show();
                    mId.requestFocus();
                }else {
                    try {
                        long show = Long.parseLong(id);
                        name = database.getName(show);
                        classes = database.getClass(show);
                        mName.setText(name);
                        mClass.setText(classes);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
