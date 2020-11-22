/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.devsyafii.crudsqlite.R;

public class AboutMeActivity extends AppCompatActivity {

    ImageView imgAbout, imBack;
    String imgUrl = "https://avatars1.githubusercontent.com/u/23512184?v=4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        imgAbout = findViewById(R.id.img_profile);
        imBack = findViewById(R.id.mToolbarBack);

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Glide.with(this)
                .load(imgUrl)
                .apply(new RequestOptions())
                .into(imgAbout);
    }
}
