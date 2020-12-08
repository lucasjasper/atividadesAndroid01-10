package com.example.listadetarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

        ListView tarefas = findViewById(R.id.tarefas);
        final EditText inputTarefa = findViewById(R.id.inputTarefa);

        final List<String> listaTarefas = new ArrayList<>();

        int layout = android.R.layout.simple_list_item_1;
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, layout, listaTarefas);

        inputTarefa.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

            if (KeyEvent.KEYCODE_ENTER == event.getKeyCode()) {

                adapter.notifyDataSetChanged();

                listaTarefas.add(inputTarefa.getText().toString());
                inputTarefa.setText("");

                adapter.notifyDataSetChanged();

            }

            return false;

            }

        });

        tarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String tarefa = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, tarefa, Toast.LENGTH_SHORT).show();

            }
        });

        tarefas.setAdapter(adapter);

    }
}