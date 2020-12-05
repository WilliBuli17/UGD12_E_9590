package com.example.tubes_kelompok_d.UnitTest;

import android.content.Context;
import android.content.Intent;

import com.example.tubes_kelompok_d.Navbar;

public class ActivityUtil {
    private Context context;
    public ActivityUtil(Context context) {
        this.context = context;
    }
    public void startMainActivity() {
        context.startActivity(new Intent(context, Navbar.class));
    }
}
