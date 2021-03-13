package fr.gsb.rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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
    }
}

public void seConnecter(View vue){

    String matricule = etMatricule.getText().toString();
    String mdp = etMdp.getText().toString();

    String url = String.format( "http://localhost:5000/visiteurs/%s/%s" , matricule , mdp ) ;
    Log.i("RV" , ">>> " + url) ;


    //Création d'écouteurs
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
                Log.i("RV" , "" + Session.getSession()) ;
                Log.i("RV" , "" + Session.getSession().getLeVisiteur()) ;

                //Toast.makeText(MainActivity.this,"Connexion réussie", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MenuRvActivity.class);
                startActivity(intent);
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

    // Annuler : Initialisation des champs.
    public void Annuler(View view){

        etMatricule.setText("");
        etMdp.setText("");

        Toast.makeText(MainActivity.this,"\"Vous avez annulé la procédure d'authentification\"",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Initialisation des champs");
    }
}



