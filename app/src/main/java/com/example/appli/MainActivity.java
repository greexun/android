package com.example.appli;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Contact c1 = new Contact("Richemont","Mathis","0632564842","26/05/1999",true);
    Contact c2 = new Contact("Lorenzi","Thomas","0632566742","26/05/2008",true);
    public static final int KEY_FOR_RESULT = 1;
    public static final String KEY_FROM_NOM = "2";
    public static final String KEY_FROM_PRENOM = "3";
    public static final String KEY_FROM_DATE = "4";
    public static final String KEY_FROM_TEL = "5";

    final Contact[] listC = {c1, c2};
    final ArrayList<Contact> listContact = new ArrayList<>(Arrays.asList(listC));
    final ContactAdapter adapter = new ContactAdapter(MainActivity.this, listContact);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView lv = findViewById(R.id.listView);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listCocktails);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent showIntent = new Intent(MainActivity.this, ShowContact.class);

                showIntent.putExtra(KEY_FROM_NOM, listContact.get(i).getNom());
                showIntent.putExtra(KEY_FROM_PRENOM,listContact.get(i).getPrenom());
                showIntent.putExtra(KEY_FROM_TEL,listContact.get(i).getTel());
                showIntent.putExtra(KEY_FROM_DATE,listContact.get(i).getDateNaissance());





                startActivity(showIntent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact name = listContact.get(i);
                listContact.remove(i);
                Toast.makeText(MainActivity.this, "Le contact " + name.getNom() + " à été éffacé", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void addContact(View view) {
        Intent intent = new Intent(this, AjoutContact.class);
        startActivityForResult(intent,KEY_FOR_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String resultNom = data.getStringExtra(AjoutContact.KEY_FROM_NOM);
        String resultPrenom = data.getStringExtra(AjoutContact.KEY_FROM_PRENOM);
        String resultDate = data.getStringExtra(AjoutContact.KEY_FROM_DATE);
        String resultTel = data.getStringExtra(AjoutContact.KEY_FROM_TEL);


        Contact contact = new Contact(resultNom, resultPrenom, resultTel, resultDate, false);
        listContact.add(contact);
        adapter.notifyDataSetChanged();
    }
}