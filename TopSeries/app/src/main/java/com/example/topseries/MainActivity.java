package com.example.topseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> series = new ArrayList<>();
        series.add("Scorpions");
        series.add("Mr. Robot");
        series.add("Ozark");
        series.add("Nvs");
        series.add("The 100");
        series.add("The boys");
        series.add("Greys Anatomy");
        series.add("The God Doctor");
        series.add("Supernatural");
        series.add("Game of Thrones");

        int layout = android.R.layout.simple_list_item_1;

        ListAdapter adapter = new ArrayAdapter<String>(this, layout, series);

        ListView seriesList = findViewById(R.id.series);

        seriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String serie = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, serie, Toast.LENGTH_SHORT).show();

            }
        });

        seriesList.setAdapter(adapter);

    }
}