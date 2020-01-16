package com.devsyafii.crudsqlite.ui.Update;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;
import com.devsyafii.crudsqlite.util.ActivityUtils;
import com.devsyafii.crudsqlite.util.CustomToolbar;

import es.dmoral.toasty.Toasty;

public class UpdateActivity extends AppCompatActivity {

    private DataHelper database;
    private String id, name, classes;
    private EditText mName, mClass;
    private Button btnUpdate, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        CustomToolbar.setupToolbar(this);
        database = new DataHelper(this);

//        Bundle bundle = getArguments();
//        id = bundle.getString("ID");
//        name = bundle.getString("NAME");
//        classes = bundle.getString("CLASS");

        mName = findViewById(R.id.et_Name);
        mClass = findViewById(R.id.et_classes);
        btnUpdate = findViewById(R.id.btnUpdate);
//        btnDelete = findViewById(R.id.btnDelete);

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
                    database.updateStudent(new Student(id, name, classes));
                    Toasty.success(UpdateActivity.this, "Data success update..", Toasty.LENGTH_SHORT).show();
                    ActivityUtils.hideKeyboard(UpdateActivity.this);
                }

            }
        });
    }
}
