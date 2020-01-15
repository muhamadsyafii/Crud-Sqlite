package com.devsyafii.crudsqlite.ui.Create;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.database.DataHelper;
import com.devsyafii.crudsqlite.model.Student;

import es.dmoral.toasty.Toasty;

public class FragmentCreate extends Fragment {

    private DataHelper dbhelper;
    private EditText mName, mClass;
    private Button mSubmit;
    private String sName, sClass;


    public FragmentCreate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create, container, false);
        dbhelper = new DataHelper(getContext());
        mName = root.findViewById(R.id.mName);
        mClass = root.findViewById(R.id.mClass);
        mSubmit = root.findViewById(R.id.btn_submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = String.valueOf(mName.getText());
                sClass = String.valueOf(mClass.getText());
                if (sName.equals("")) {
                    mName.requestFocus();
                    Toasty.error(getContext(), "Plase enter your name", Toasty.LENGTH_SHORT).show();
                } else if (sClass.equals("")) {
                    mClass.requestFocus();
                    Toasty.error(getContext(), "Plase enter your class", Toasty.LENGTH_SHORT).show();
                } else {
                    mName.setText("");
                    mClass.setText("");
                    Toasty.success(getContext(), "Create Success", Toasty.LENGTH_SHORT).show();
                    dbhelper.createStudent(new Student(null, sName, sClass));
                }
            }
        });
        return root;
    }

}
