package com.devsyafii.crudsqlite.ui.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.devsyafii.crudsqlite.R;
import com.devsyafii.crudsqlite.ui.Create.FragmentCreate;
import com.devsyafii.crudsqlite.util.ActivityUtils;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_create:
//                Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show();
                ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new FragmentCreate(), R.id.fl_Home);
                return true;
            case R.id.nav_update:
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
