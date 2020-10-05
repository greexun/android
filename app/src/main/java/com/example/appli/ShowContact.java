package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowContact extends AppCompatActivity {

    private TextView ed1;
    private TextView ed2;
    private TextView ed3;
    private TextView ed4;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);






        ed1 = findViewById(R.id.nomView);
        String nom = getIntent().getStringExtra(MainActivity.KEY_FROM_NOM);
        ed1.setText(nom);

        ed2 = findViewById(R.id.prenomView);
        String prenom = getIntent().getStringExtra(MainActivity.KEY_FROM_PRENOM);
        ed2.setText(prenom);

        ed3 = findViewById(R.id.naisView);
        String naiss = getIntent().getStringExtra(MainActivity.KEY_FROM_DATE);
        ed3.setText(naiss);

        ed4 = findViewById(R.id.telView);
        String tel = getIntent().getStringExtra(MainActivity.KEY_FROM_TEL);
        ed4.setText(tel);


    }
}