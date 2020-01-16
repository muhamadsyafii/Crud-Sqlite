/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.ui.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.ui.Create.CreateActivity;
import com.devsyafii.crudsqlite.ui.Delete.DeleteActivity;
import com.devsyafii.crudsqlite.ui.Read.ReadActivity;

import com.devsyafii.crudsqlite.ui.Update.UpdateActivity;
import com.devsyafii.crudsqlite.ui.account.AboutMeActivity;
import com.devsyafii.crudsqlite.util.ActivityUtils;

public class HomeActivity extends AppCompatActivity {

    ImageView mCreate, mRead, mUpdate, mDelete, imAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mCreate = findViewById(R.id.iv_mCreate);
        mRead = findViewById(R.id.iv_mRead);
        mUpdate = findViewById(R.id.iv_mUpdate);
        mDelete = findViewById(R.id.iv_mDelete);
        imAccount = findViewById(R.id.iv_account);

        onClick();
    }

    private void onClick() {
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(HomeActivity.this, CreateActivity.class);
            }
        });
        mRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(HomeActivity.this, ReadActivity.class);

            }
        });
        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(HomeActivity.this, UpdateActivity.class);

            }
        });
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(HomeActivity.this, DeleteActivity.class);
            }
        });
        imAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.openActivity(HomeActivity.this, AboutMeActivity.class);
            }
        });
    }
}
