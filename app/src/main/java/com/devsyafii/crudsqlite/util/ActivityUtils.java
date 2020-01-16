/*
 * Created by Muhamad Syafii
 * Copyright (c) 2020.
 * All Rights Reserved
 *
 */
package com.devsyafii.crudsqlite.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static androidx.core.util.Preconditions.checkNotNull;

public class ActivityUtils {

    public static void openActivity(Context context, Class<?> target){
        context.startActivity(new Intent(context, target));
    }

    public static void closeActivity(Context context){
        if (context != null){
            hideKeyboard((Activity) context);
            ((Activity) context).finish();
        }
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    @SuppressLint("RestrictedApi")
    public static void replaceFragmentActivity (@NonNull FragmentManager fragmentManager,
                                                @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_NONE);
        transaction.replace(frameId, fragment);
        transaction.commit();
    }
}
