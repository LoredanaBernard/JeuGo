package ensim.Go;

import java.util.ArrayList;
import java.util.List;

public class Pierre {
	public int x;
	public int y;
	public String color;
	public String nom;
	
	Pierre(String n, String color){
		this.nom =n;
		this.color = color;
	}
	
	// Retourne le nombre de bords que la pierre touche
	int nBords() { 
		if((x==0 && y==0) || (x==0 && y==8) || (x==8 && y==0) || (x==8 && y==0)) {
			return 2;
		}
		else {
			if ( x==0 || y==0 || x==8 || y==8 ) {
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
		// Ajout de la pierre à gauche si elle existe
		if(x!=0) {
			if (!goban.estLibre(x-1,y)) {
				pEntoure.add(goban.retourPierre(x-1,y));
			}			
		}
		// Ajout de la pierre au dessus si elle existe
		if (y!=0) {
			if (!goban.estLibre(x,y-1)) {
				pEntoure.add(goban.retourPierre(x,y-1));
			}	
		}
		// Ajout de la pierre à droite si elle existe
		if (x!=8) {
			if (!goban.estLibre(x+1,y) ) {
				pEntoure.add(goban.retourPierre(x+1,y));
			}	
		}
		// Ajout de la pierre en dessous si elle existe
		if (y!=8) {
			if (!goban.estLibre(x,y+1)) {
				pEntoure.add(goban.retourPierre(x,y+1));
			}	
		}
		
		for ( Pierre p : pEntoure) {
			//System.out.println("Pierres autour de " + this.nom + " : " + p.nom);
		}
		return pEntoure;
	}
	
	// Retourne les pierres adverses qui entourent
	public List<Pierre> entoureAdverse(Goban goban){
		List<Pierre> listeEntoure = new ArrayList<Pierre>();
		listeEntoure = entoure(goban);
		for( Pierre p : entoure(goban)) {
			if ( (p.color).equals(this.color)) {	// Si la pierre est de la même couleur que celle testée
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

