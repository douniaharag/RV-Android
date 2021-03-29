package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.gsb.R;
import fr.gsb.rv.technique.Session;


public class MenuRvActivity extends AppCompatActivity {

    TextView lblVisiteur ;

    Button consulter ;
    Button saisir ;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);

        this.consulter = (Button) findViewById(R.id.btnConsulter);
        this.saisir = (Button) findViewById(R.id.btnSaisir);


        this.lblVisiteur = (TextView) findViewById(R.id.lblVisiteur);
        lblVisiteur.setText(Session.getSession().getLeVisiteur().getNom()+ " " + Session.getSession().getLeVisiteur().getPrenom() );

    }

    public void Consulter(View vue){
        consulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this,RechercheRvActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Saisir (View view) {
        saisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRvActivity.this,SaisieRvActivity.class);
                startActivity(intent);
            }
        });
    }
}



