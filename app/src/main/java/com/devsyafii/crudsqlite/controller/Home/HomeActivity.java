/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.controller.Create.CreateActivity;
import com.devsyafii.crudsqlite.controller.Delete.DeleteActivity;
import com.devsyafii.crudsqlite.controller.Read.ReadActivity;
import com.devsyafii.crudsqlite.controller.Update.UpdateActivity;
import com.devsyafii.crudsqlite.controller.account.AboutMeActivity;

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
                Intent intent = new Intent(HomeActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
        mRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ReadActivity.class);
                startActivity(intent);

            }
        });
        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UpdateActivity.class);
                startActivity(intent);

            }
        });
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });
        imAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }
}
