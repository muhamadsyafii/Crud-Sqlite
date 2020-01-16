package com.devsyafii.crudsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.devsyafii.crudsqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_school";
    private static final String TABLE_STUDENT = "tbl_student";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STD_ID = "id";
    private static final String TABLE_NAME = "name";
    private static final String TABLE_CLASS = "class";

    private static final String queryCreateTable = "CREATE TABLE " + TABLE_STUDENT + "(" + TABLE_STD_ID + " INTEGER PRIMARY KEY," + TABLE_NAME + " TEXT," + TABLE_CLASS + " TEXT" + ")";

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public void createStudent(Student student) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TABLE_STD_ID, student.getId());
        values.put(TABLE_NAME, student.getName());
        values.put(TABLE_CLASS, student.getClasses());

        database.insert(TABLE_STUDENT, null, values);
        database.close();
    }

    public int updateStudent(Student student) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TABLE_NAME, student.getName());
        values.put(TABLE_NAME, student.getName());

        return database.update(TABLE_STUDENT, values, TABLE_STD_ID + " = ?", new String[]{String.valueOf(student.getId())});
    }

    public int deleteStudent(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_STUDENT, TABLE_STD_ID +" = ?", new String[]{id});
    }

    public List<Student> readDataStudent() {
        List<Student> list = new ArrayList<Student>();
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student(null, null, null);
                student.setId(cursor.getString(0));
                student.setName(cursor.getString(1));
                student.setClasses(cursor.getString(2));
                list.add(student);
            } while (cursor.moveToNext());
        }
        database.close();
        return list;
    }
}
