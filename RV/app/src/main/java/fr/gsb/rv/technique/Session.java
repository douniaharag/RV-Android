package fr.gsb.rv.technique;

import fr.gsb.rv.entites.*;
import fr.gsb.rv.MainActivity;
import fr.gsb.rv.modeles.*;

public class Session {

	private static Session session = null;
	private Visiteur leVisiteur;

	private Session(Visiteur leVisiteur) {
		super();
		System.out.print( "Ouverture Session : " + leVisiteur );
		this.leVisiteur = leVisiteur;
	}

	public static void ouvrir(Visiteur visiteur) {
		//Visiteur visiteur = ModeleGsb.getInstance().seConnecter(matricule, mdp)
		Session.session = new Session(visiteur);
	}


	public static Session getSession() {
		return Session.session;
	}

	public static void fermer() {
		Session.session = null;
	}

	public Visiteur getLeVisiteur() {
		return this.leVisiteur;
	}

	public void setLeVisiteur(Visiteur visiteur) {
		this.leVisiteur = visiteur;
	}

}
