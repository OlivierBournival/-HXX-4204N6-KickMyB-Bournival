package com.example.apptp;

import static java.time.LocalTime.now;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.apptp.databinding.ActivityLoginBinding;
import com.example.apptp.databinding.ActivityReceptionBinding;
import com.example.apptp.model.Tache;
import com.example.apptp.model.TacheAdapter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Reception extends AppCompatActivity {
    private ActivityReceptionBinding binding;
    TacheAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("          Reception");
        binding = ActivityReceptionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // initialisation du recycler
        this.initRecycler();
        this.remplirRecycler();
        //this.remplacer();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //  Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Supprimer toutes les question",Toast.LENGTH_SHORT).show();
            //service.videTouteLesQuestions();
            //service.videtoutLesVote();
            finish();
            startActivity(getIntent());
            return true;
        }
        if (id == R.id.action_poptoast) {
            Toast.makeText(getApplicationContext(),"Supprimer tout les votes",Toast.LENGTH_SHORT).show();
            //service.videtoutLesVote();
            finish();
            startActivity(getIntent());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void remplacer(){
        adapter.list.clear();

        adapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void remplirRecycler() {
        for (int i = 0 ; i < 10000 ; i++) {
            Tache p = new Tache();
            p.nom = "Bob " + i;
            p.dateLimite =  LocalDateTime.now();
            p.tempEcouler = Duration.between(LocalTime.NOON, LocalTime.MIDNIGHT);
            p.PourcentageAcomplicement = Integer.parseInt("" +  20);
            adapter.list.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new TacheAdapter();
        recyclerView.setAdapter(adapter);
    }
}