package fr.gsb.rv.entites;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Visiteur {

	private String matricule ;
	private String nom ;
	private String prenom ;
	private String mdp ;


	public Visiteur() {
		this.matricule = null;
		this.nom = null;
		this.prenom = null;
		this.mdp = null;
	}
	
	public Visiteur(String matricule, String mdp, String nom, String prenom ) {
		super();
		this.matricule = matricule;
		this.mdp = mdp ;
		this.nom = nom;
		this.prenom = prenom;
	}



	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	@Override
	public String toString() {
		return "Visiteur{" +
				"matricule='" + matricule + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", mdp='" + mdp + '\'' +
				'}';
	}


}
