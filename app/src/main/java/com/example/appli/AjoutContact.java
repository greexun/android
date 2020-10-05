package com.example.appli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AjoutContact extends AppCompatActivity {

    public static final String KEY_FROM_NOM = "NomContact";
    public static final String KEY_FROM_PRENOM = "NomPrenom";
    public static final String KEY_FROM_TEL = "Tel";
    public static final String KEY_FROM_DATE = "Date";

    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private EditText ed4;
    //private EditText ed5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_layout);
        Intent intent = getIntent();
        if (intent != null){
            String str = "";
        }
    }

    public void confirmContact(View view) {



        ed1 = (EditText) findViewById(R.id.nomContact);
        String contNom = ed1.getText().toString();

        ed2 = (EditText) findViewById(R.id.prenomContact);
        String contPren = ed2.getText().toString();

        ed3 = (EditText) findViewById(R.id.dateNaiss);
        String contDate = ed3.getText().toString();
        ed4 = (EditText) findViewById(R.id.tel);
        String contTel = ed4.getText().toString();
        if(contNom != "" && contPren != "" && contDate != "" && contTel != ""){
            Intent intentContact = new Intent();
            intentContact.putExtra(KEY_FROM_NOM, contNom);
            intentContact.putExtra(KEY_FROM_PRENOM,contPren);
            intentContact.putExtra(KEY_FROM_TEL,contTel);
            intentContact.putExtra(KEY_FROM_DATE,contDate);


            setResult(MainActivity.KEY_FOR_RESULT, intentContact);



            super.onActivityResult(1, 1, intentContact);
            super.onBackPressed();
        }



    }

    @Override
    public void onBackPressed() {
        Intent intentContact = new Intent();
        intentContact.putExtra(KEY_FROM_NOM, "test");
        setResult(1, intentContact);


    }

}
