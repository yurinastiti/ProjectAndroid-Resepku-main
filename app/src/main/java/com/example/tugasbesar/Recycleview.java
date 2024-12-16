package com.example.tugasbesar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Recycleview extends AppCompatActivity {
    private String title = "Mode List";
    private RecyclerView rvResep;
    private ArrayList<Resep> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        setActionBarTitle(title);

        rvResep = findViewById(R.id.rv_resep);
        rvResep.setHasFixedSize(true);

        list.addAll(ResepData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvResep.setLayoutManager(new LinearLayoutManager(this));
        ListResepAdapter listResepAdapter = new ListResepAdapter(list);
        rvResep.setAdapter(listResepAdapter);

        listResepAdapter.setOnItemClickCallback(new ListResepAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Resep data) {
                showSelectedResep(data);
            }
        });
    }

    private void showRecyclerGrid() {
        rvResep.setLayoutManager(new GridLayoutManager(this, 2));
        GridResepAdapter gridResepAdapter = new GridResepAdapter(list);
        rvResep.setAdapter(gridResepAdapter);

        gridResepAdapter.setOnItemClickCallback(new GridResepAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Resep data) {
                showSelectedResep(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvResep.setLayoutManager(new LinearLayoutManager(this));
        CardViewResepAdapter cardViewResepAdapter = new CardViewResepAdapter(list);
        rvResep.setAdapter(cardViewResepAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;

        }
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedResep(Resep resep) {
        Toast.makeText(this, "Kamu memilih " + resep.getName(), Toast.LENGTH_SHORT).show();
    }
}