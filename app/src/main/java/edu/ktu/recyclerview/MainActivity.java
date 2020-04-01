package edu.ktu.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        recyclerView = findViewById(R.id.main_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CustomAdapter(data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        data.add("Jonas");
        data.add("Petras");
        data.add("Juozas");

        adapter.notifyDataSetChanged();
    }
}