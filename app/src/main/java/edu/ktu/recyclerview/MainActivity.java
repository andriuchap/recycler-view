package edu.ktu.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<PersonData> data;

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

        data.add(new PersonData("Jonas", "Jonaitis", 20));
        data.add(new PersonData("Petras", "Petraitis", 28));
        data.add(new PersonData("Juozas", "Juozaitis", 36));

        adapter.notifyDataSetChanged();

        final Context context = this;
        adapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Toast.makeText(context, data.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}