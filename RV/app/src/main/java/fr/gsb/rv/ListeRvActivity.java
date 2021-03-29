package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import fr.gsb.R;
import fr.gsb.rv.technique.Session;

public class ListeRvActivity extends AppCompatActivity {


    TextView tvSelection;


    android.widget.ListView ListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        tvSelection = (TextView) findViewById(R.id.tvSelection);
        ListView = (ListView) findViewById(R.id.ListeView);

        String matricule = Session.getSession().getLeVisiteur().getMatricule();

        Bundle bundle = this.getIntent().getExtras();

        String mois = bundle.getString("mois");
        String annee = bundle.getString("annee");


        // tvSelection.setText(mois+ "/" +  annee);

        String url = String.format( "http://192.168.121.151:5000/rapports/%s/%s/%s" , matricule , mois , annee ) ;

    }

}