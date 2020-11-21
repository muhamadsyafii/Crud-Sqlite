/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.util.CustomToolbar;

public class AboutMeActivity extends AppCompatActivity {

    ImageView imgAbout;
    String imgUrl = "https://avatars1.githubusercontent.com/u/23512184?v=4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        CustomToolbar.setupToolbar(this, "My Profile");

        imgAbout = findViewById(R.id.img_profile);

        Glide.with(this)
                .load(imgUrl)
                .apply(new RequestOptions())
                .into(imgAbout);
    }
}
