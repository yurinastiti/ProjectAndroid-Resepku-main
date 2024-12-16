package com.example.tugasbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResepActivity extends AppCompatActivity {
    public static final String RECIPE_NAME_EXTRA = "recipe_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep);

        String recipeName = getIntent().getStringExtra(RECIPE_NAME_EXTRA);

        // Customize the activity content based on the recipe name if needed
        setTitle(recipeName);
    }
}
