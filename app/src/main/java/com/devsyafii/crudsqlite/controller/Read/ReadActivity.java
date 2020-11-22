/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.controller.Read;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private DataHelper dbhelper;
    private List<Student> studentList = new ArrayList<Student>();
    TextView mId;
    StudentAdapter studentAdapter;
    ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mRecycleView = findViewById(R.id.listData);
        mId = findViewById(R.id.tv_id);
        imBack = findViewById(R.id.mToolbarBack);

        dbhelper = new DataHelper(this);
        studentAdapter = new StudentAdapter(this, studentList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecycleView.setLayoutManager(manager);
        mRecycleView.setAdapter(studentAdapter);
        studentList.clear();

        List<Student> list = dbhelper.readDataStudent();
        for (Student contact : list){
            Student model = new Student();
            model.setId(contact.getId());
            model.setName(contact.getName());
            model.setClasses(contact.getClasses());
            studentList.add(model);

            if ((studentList.isEmpty())){
                Toast.makeText(ReadActivity.this, "Tidak ada data!!", Toast.LENGTH_SHORT).show();
            }
        }

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
