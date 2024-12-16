package com.example.tugasbesar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnkunjungi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnkunjungi = findViewById(R.id.btnkunjungi);
        btnkunjungi.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnkunjungi) {
            Intent moveIntent = new Intent(MainActivity.this, Recycleview.class);
            startActivity(moveIntent);
        }
    }
}