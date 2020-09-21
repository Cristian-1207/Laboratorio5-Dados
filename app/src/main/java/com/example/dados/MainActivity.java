package com.example.dados;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        adapter = new ArrayAdapter<String>(this.getApplicationContext(),R.layout.item_container);
        datos = new ArrayList<String>();
        datos.add("1");
        datos.add("2");
        adapter.addAll(datos);

        loadComponents();

    }

    private void loadComponents() {
        GridView container = (GridView)this.findViewById(R.id.container);
        container.setAdapter(adapter);

        Button add = this.findViewById(R.id.add);
        add.setOnClickListener(this);
        Button remove = this.findViewById(R.id.remove);
        remove.setOnClickListener(this);
        Button roll = this.findViewById(R.id.ro);
        roll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            datos.add("1");
        } else if (v.getId() == R.id.remove) {
            datos.remove(datos.size() -1 );
        } else if (v.getId() == R.id.ro) {
            int size = datos.size();
            datos.clear();
            int suma = 0;
            for (int i = 0 ; i < size; i++) {
                int number = ThreadLocalRandom.current().nextInt(1,6);
                suma += number;
                datos.add(number + "");
            }
            TextView txt = (TextView)this.findViewById(R.id.results);
            txt.setText("El total es " + suma);
        }
        adapter.clear();
        adapter.addAll(datos);


    }
}