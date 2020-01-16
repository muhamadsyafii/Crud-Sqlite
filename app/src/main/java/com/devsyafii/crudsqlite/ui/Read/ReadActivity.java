package com.devsyafii.crudsqlite.ui.Read;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;
import com.devsyafii.crudsqlite.util.CustomToolbar;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private DataHelper dbhelper;
    private List<Student> studentList = new ArrayList<Student>();
    TextView mId;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        CustomToolbar.setupToolbar(this);
        mRecycleView = findViewById(R.id.listData);
        mId = findViewById(R.id.tv_id);

        dbhelper = new DataHelper(this);
        studentAdapter = new StudentAdapter(this, studentList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecycleView.setLayoutManager(manager);
        mRecycleView.setAdapter(studentAdapter);
        studentList.clear();
        List<Student> list = dbhelper.readDataStudent();
        for (Student contact : list){
            Student model = new Student(null,null,null);
            model.setId(contact.getId());
            model.setName(contact.getName());
            model.setClasses(contact.getClasses());
            studentList.add(model);

            if ((studentList.isEmpty())){
                Toast.makeText(ReadActivity.this, "Tidak ada data!!", Toast.LENGTH_SHORT).show();
            }else {

            }
        }
    }
}
