package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response ;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.NoConnectionError;

import org.json.JSONException;
import org.json.JSONObject;

import fr.gsb.R;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;


import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMatricule ;
    EditText etMatricule ;

    TextView tvMdp ;
    EditText etMdp ;

    TextView tvErreur ;

    Button bValider ;
    Button bAnnuler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMatricule = (EditText) findViewById(R.id.etMatricule);
        etMatricule.setText("a131");
        etMdp = (EditText) findViewById(R.id.etMdp);
        etMdp.setText("azerty");
    }




public void seConnecter(View vue){

    String matricule = etMatricule.getText().toString();
    String mdp = etMdp.getText().toString();


   /*  Visiteur leVisiteur = ModeleGsb.getInstance().seConnecter(matricule , mdp);

    if (leVisiteur != null){
        Log.i("RV" , "" + leVisiteur) ;
        Session.ouvrir(leVisiteur);
    }
    else {
        Log.w("RV" , "Connection refusée" );
    }*/

    String url = String.format( "http://192.168.121.151:5000/visiteurs/%s/%s" , matricule , mdp ) ;


    Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            Visiteur visiteur = new Visiteur() ;


            System.out.println("> " + response.toString());
            try
            {
                visiteur.setMatricule( response.getString( "vis_matricule" ) );
                visiteur.setNom( response.getString( "vis_nom" ) ) ;
                visiteur.setPrenom( response.getString( "vis_prenom" ) ) ;
                System.out.println( visiteur ) ;
                Session.ouvrir( visiteur );


                Log.i("RV" , "" + Session.getSession().getLeVisiteur()) ;


                Toast.makeText(MainActivity.this,"Bienvenue ! " , Toast.LENGTH_SHORT).show();

            }

            catch (JSONException e)
            {
                System.out.println("Nok : " + e.getMessage());
            }

            System.out.println("HTTP OK");

        }

    } ;


    Response.ErrorListener ecouteurErreur = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("HTTP Error > " + error.toString() );
        }

    } ;

    JsonObjectRequest requete = new JsonObjectRequest(Request.Method.GET , url, null, ecouteurReponse, ecouteurErreur);
    RequestQueue fileRequete = Volley.newRequestQueue(this) ;
    fileRequete.add(requete) ;

}


    public void Annuler(View view){

        etMatricule.setText("");
        etMdp.setText("");

        Toast.makeText(MainActivity.this,"\"Vous avez annulé la procédure d'authentification\"",Toast.LENGTH_SHORT).show();

    }
}
