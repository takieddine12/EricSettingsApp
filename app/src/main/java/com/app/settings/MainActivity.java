package com.app.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            int latency = bundle.getInt("latency",0);
            String language = bundle.getString("language");
            Toast.makeText(MainActivity.this, "Latency is " + latency +  "\n"  + "Language is " + language,Toast.LENGTH_SHORT).show();
        }
    }
}