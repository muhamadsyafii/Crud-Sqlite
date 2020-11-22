/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.Delete;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;

public class DeleteActivity extends AppCompatActivity {
    DataHelper database;
    EditText mId;
    Button btnDelete;
    ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        database = new DataHelper(this);
        mId = findViewById(R.id.et_id);
        btnDelete = findViewById(R.id.btnDelete);
        imBack = findViewById(R.id.mToolbarBack);

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mId.getText().toString();
                if (TextUtils.isEmpty(id)){
                    mId.requestFocus();
                    Toast.makeText(DeleteActivity.this, "Please enter your ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                int deleteRows = database.deleteStudent(mId.getText().toString());
                if (deleteRows > 0 ){
                    mId.setText("");
                    finish();
                }else {
                    Toast.makeText(DeleteActivity.this, "Data not Delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
