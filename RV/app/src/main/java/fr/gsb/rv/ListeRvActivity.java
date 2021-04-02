package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;

import fr.gsb.R;
import fr.gsb.rv.entites.Rapport_Visite;
import fr.gsb.rv.technique.Session;

public class ListeRvActivity extends AppCompatActivity {


    TextView tvRvSelection;
    ListView lvRapportsVisite;

    android.widget.ListView ListView;
    private ArrayList<Rapport_Visite> lesRapport = new ArrayList<Rapport_Visite>();
    private ArrayList<String> lesRv = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);


        tvRvSelection = (TextView) findViewById(R.id.tvRvSelection);
        lvRapportsVisite = (ListView) findViewById(R.id.lvRapportsVisite);

        Bundle bundle = this.getIntent().getExtras();

        String matricule = Session.getSession().getLeVisiteur().getMatricule();
        String mois = bundle.getString("mois");
        String annee = bundle.getString("annee");

        ArrayAdapter<String> adapteur = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,  );
        lvRapportsVisite.setAdapter(adapteur);

        // tvSelection.setText(mois+ "/" +  annee);

        String url = String.format("http://192.168.121.151:5000/rapports/%s/%s/%s", matricule, mois, annee);

        Response.Listener<JSONArray> ecouteurReponse = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        Log.i("RV", response.getJSONObject(i).getString("num"));
                        Rapport_Visite leRapport = new Rapport_Visite();


                    }
                } catch (Exception e) {
                    Log.e("APP-RV", "Erreur JSON : " + e.getMessage());
                }
            }
        };

    }
}

