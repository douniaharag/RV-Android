package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import fr.gsb.R;

public class RechercheRvActivity extends AppCompatActivity {


    Spinner spinner1 ;
    Spinner spinner2 ;

    Button afficher ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);

        afficher = (Button) findViewById(R.id.afficher) ;

        spinner1 = (Spinner) findViewById(R.id.spinner);

        ArrayList mois = new ArrayList();
        mois.add("01");
        mois.add("02");
        mois.add("03");
        mois.add("04");
        mois.add("05");
        mois.add("06");
        mois.add("07");
        mois.add("08");
        mois.add("09");
        mois.add("10");
        mois.add("11");
        mois.add("12");

        ArrayAdapter adapter = new ArrayAdapter( this,  android.R.layout.simple_spinner_item, mois );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);


        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayList annee = new ArrayList();
        annee.add("2017");
        annee.add("2018");
        annee.add("2019");
        annee.add("2020");
        annee.add("2021");
        annee.add("2022");

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, annee);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);


    }

    public void afficher(View view){

        Intent intent2 = new Intent(RechercheRvActivity.this,ListeRvActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString( "mois", spinner1.getSelectedItem().toString() );
        bundle.putString( "annee", spinner2.getSelectedItem().toString() );

        Log.i("RV","Mois  : " + spinner1.getSelectedItem().toString() );
        Log.i("RV","Année  : " + spinner2.getSelectedItem().toString() );

        intent2.putExtras( bundle );
        startActivity(intent2);

    }
}