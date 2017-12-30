package ensim.Go;

import java.util.ArrayList;
import java.util.List;

public class Pierre {
	public int l;
	public int c;
	public String color;
	public String nom;
	
	Pierre(String n, String color){
		this.nom =n;
		this.color = color;
	}
	
	// Retourne le nombre de bords que la pierre touche
	int nBords() { 
		if((l == 0 && c == 0) || (l == 0 && c == 8) || (l == 8 && c == 0) || (l == 8 && c == 8)) {
			return 2;
		}
		else {
			if ( l == 0 || c == 0 || l == 8 || c == 8 ) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

	// Retourne la liste des pierres qui entourent  
	List <Pierre> entoure(Goban goban){
		List<Pierre> pEntoure = new ArrayList<Pierre>();
		// Ajout de la pierre au dessus si elle existe
		if(l!=0) {
			if (!goban.estLibre(l-1,c)) {
				pEntoure.add(goban.retourPierre(l-1,c));
			}			
		}
		// Ajout de la pierre à gauche si elle existe
		if (c!=0) {
			if (!goban.estLibre(l,c-1)) {
				pEntoure.add(goban.retourPierre(l,c-1));
			}	
		}
		// Ajout de la pierre en dessous si elle existe
		if (l!=goban.taille-1) {
			if (!goban.estLibre(l+1,c) ) {
				pEntoure.add(goban.retourPierre(l+1,c));
			}	
		}
		// Ajout de la pierre à droite si elle existe
		if (c!=goban.taille-1) {
			if (!goban.estLibre(l,c+1)) {
				pEntoure.add(goban.retourPierre(l,c+1));
			}	
		}
		
	
		return pEntoure;
	}
	
	// Retourne les pierres adverses qui entourent
	public List<Pierre> entoureAdverse(Goban goban){
		List<Pierre> listeEntoure = new ArrayList<Pierre>();
		listeEntoure = entoure(goban);
		for( Pierre p : entoure(goban)) {
			if ( (p.color).equals(this.color)) {	// Si la pierre n'est pas de la même couleur que celle testée
				listeEntoure.remove(p);		// On la supprime de la liste 
			}
		}		
		return listeEntoure;
	}
	
	public List<Pierre> entoureAllie(Goban goban){
		List<Pierre> listeEntoure = new ArrayList<Pierre>();
		listeEntoure = entoure(goban);
		for( Pierre p : entoure(goban)) {
			if ( !(p.color).equals(this.color)) {	// Si la pierre est de la même couleur que celle testée
				listeEntoure.remove(p);		// On la supprime de la liste 
			}
		}
		
		return listeEntoure;
	}
	
	// Retourne le nombre de libertes de la pierre
	public int nLibertes(Goban goban) {
		return 4-(entoure(goban).size() + nBords());
	}
	



}

