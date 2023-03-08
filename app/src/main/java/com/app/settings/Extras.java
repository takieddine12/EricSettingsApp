package com.app.settings;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;

public class Extras {

    public static void saveValues(Context context , int progress , String language){
        SharedPreferences sharedPreferences = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("progress",progress);
        editor.putString("language",language);
        editor.apply();
    }
}
