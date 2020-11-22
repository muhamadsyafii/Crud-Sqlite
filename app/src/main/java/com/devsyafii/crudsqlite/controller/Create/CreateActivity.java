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

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;
import com.devsyafii.crudsqlite.util.ActivityUtils;
import com.devsyafii.crudsqlite.util.CustomToolbar;

import es.dmoral.toasty.Toasty;

public class CreateActivity extends AppCompatActivity {
    private DataHelper dbhelper;
    private EditText mName, mClass;
    private Button mSubmit;
    private String sName, sClass;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        CustomToolbar.setupToolbar(this, "Create Data");
        dbhelper = new DataHelper(this);
        student = new Student();
        mName = findViewById(R.id.mName);
        mClass = findViewById(R.id.mClass);
        mSubmit = findViewById(R.id.btn_submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = String.valueOf(mName.getText());
                sClass = String.valueOf(mClass.getText());
                if (sName.equals("")) {
                    mName.requestFocus();
                    Toasty.error(CreateActivity.this, "Plase enter your name", Toasty.LENGTH_SHORT).show();
                } else {
                    if (sClass.equals("")) {
                        mClass.requestFocus();
                        Toasty.error(CreateActivity.this, "Plase enter your class", Toasty.LENGTH_SHORT).show();
                    } else {
                        mName.setText("");
                        mClass.setText("");
                        Toasty.success(CreateActivity.this, "Create Success", Toasty.LENGTH_SHORT).show();
                        student.setName(sName);
                        student.setClasses(sClass);
                        dbhelper.createStudent(student);
                        ActivityUtils.hideKeyboard(CreateActivity.this);
                    }
                }
            }
        });
    }
}
