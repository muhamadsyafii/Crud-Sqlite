/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.ui.Delete;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.util.ActivityUtils;
import com.devsyafii.crudsqlite.util.CustomToolbar;

import es.dmoral.toasty.Toasty;

public class DeleteActivity extends AppCompatActivity {
    DataHelper database;
    EditText mId;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        CustomToolbar.setupToolbar(this, "Delete Data");
        database = new DataHelper(this);
        mId = findViewById(R.id.et_id);
        btnDelete = findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mId.getText().toString();
                if (TextUtils.isEmpty(id)){
                    mId.requestFocus();
                    Toasty.info(DeleteActivity.this, "Please enter your ID", Toasty.LENGTH_SHORT).show();
                    return;
                }
                int deleteRows = database.deleteStudent(mId.getText().toString());
                if (deleteRows > 0 ){
                    Toasty.success(DeleteActivity.this, "Data Delete", Toasty.LENGTH_SHORT).show();
                    mId.setText("");
                    ActivityUtils.hideKeyboard(DeleteActivity.this);
                    ActivityUtils.closeActivity(DeleteActivity.this);
                }else {
                    Toasty.error(DeleteActivity.this, "Data not Delete", Toasty.LENGTH_SHORT).show();
                }
            }
        });
    }
}
