package com.devsyafii.crudsqlite.util;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.devsyafii.crudsqlite.R;

public class CustomToolbar {
    public static void setupToolbar(final Activity activity){
        View view = activity.getWindow().getDecorView();
        ImageView mToolbarBack = view.findViewById(R.id.mToolbarBack);
        mToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.closeActivity(activity);
            }
        });
//
//        TextView mToolbarTitle = view.findViewById(R.id.mToolbarTitle);
//        mToolbarTitle.setVisibility(View.GONE);

    }
//    public static void setupToolbar(final Activity activity, String title){
//        View view = activity.getWindow().getDecorView();
//        ImageView mToolbarBack = view.findViewById(R.id.mToolbarBack);
//        mToolbarBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.closeActivity(activity);
//            }
//        });
//
//        TextView mToolbarTitle = view.findViewById(R.id.mToolbarTitle);
//        mToolbarTitle.setVisibility(View.VISIBLE);
//        mToolbarTitle.setText(title);
//    }
//
//    public static void setupSearchToolbar(final Activity activity, final EditTextListener listener){
//        View view = activity.getWindow().getDecorView();
//        ImageView mToolbarBack = view.findViewById(R.id.mToolbarBack);
//        mToolbarBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityUtils.closeActivity(activity);
//            }
//        });
//
//        EditText mToolbarSearch = view.findViewById(R.id.mToolbarSearch);
//        mToolbarSearch.clearFocus();
//        mToolbarSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                listener.onTextChanged(String.valueOf(charSequence));
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//    }

    public interface EditTextListener{
        void onTextChanged(String data);
    }
}
