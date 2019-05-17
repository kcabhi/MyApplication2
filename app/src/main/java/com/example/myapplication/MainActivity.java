package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etDescription;
    private Button btnAdd;
    private final static String BASE_URL="10.0.2.2";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });


    }

    private void Add() {
        String name = etName.getText().toString();
        String description = etDescription.getText().toString();

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Heroesclass heroesclass=retrofit.create(Heroesclass.class);
        Call<Void> voidcall = heroesclass.createHeroes();

    }
}
