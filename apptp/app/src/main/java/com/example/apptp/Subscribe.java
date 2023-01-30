package com.example.apptp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.apptp.databinding.ActivityLoginBinding;
import com.example.apptp.databinding.ActivitySubscribeBinding;

public class Subscribe extends AppCompatActivity {
    private ActivitySubscribeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("          Subscribe");
        binding = ActivitySubscribeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.Subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Article
                Intent i = new Intent( Subscribe.this ,  Reception.class );
                startActivity(i);
            }
        });




    }
}