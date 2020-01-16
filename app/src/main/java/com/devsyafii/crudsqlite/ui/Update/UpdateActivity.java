/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.ui.Update;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;
import com.devsyafii.crudsqlite.util.ActivityUtils;
import com.devsyafii.crudsqlite.util.CustomToolbar;

import es.dmoral.toasty.Toasty;

public class UpdateActivity extends AppCompatActivity {

    private DataHelper database;
    private String id, name, classes;
    private EditText mId, mName, mClass;
    private Button btnUpdate, btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        CustomToolbar.setupToolbar(this, "Update Data");
        database = new DataHelper(this);

        mId = findViewById(R.id.et_showId);
        mName = findViewById(R.id.et_Name);
        mClass = findViewById(R.id.et_classes);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnShow = findViewById(R.id.btnShow);

        mName.setText(name);
        mClass.setText(classes);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = String.valueOf(mName.getText());
                classes = String.valueOf(mClass.getText());

                if (name.equals("")){
                    mName.requestFocus();
                    Toasty.error(UpdateActivity.this, "Please enter your Name", Toasty.LENGTH_SHORT).show();
                }else if (classes.equals("")){
                    Toasty.error(UpdateActivity.this, "Please enter your Class", Toasty.LENGTH_SHORT).show();
                }else {
                    long l = Long.parseLong(id);
                    database.updateStudent(l,name,classes);
                    Toasty.success(UpdateActivity.this, "Data success update..", Toasty.LENGTH_SHORT).show();
                    mId.setText("");
                    mName.setText("");
                    mClass.setText("");
                    ActivityUtils.hideKeyboard(UpdateActivity.this);
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
                ActivityUtils.hideKeyboard(UpdateActivity.this);
            }
        });

    }
}
