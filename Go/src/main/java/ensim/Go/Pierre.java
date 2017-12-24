package ensim.Go;

import java.util.ArrayList;
import java.util.List;

public class Pierre {
	public int x;
	public int y;
	public String color;
	public String nom;
	
	Pierre(String n){
		this.nom =n;
	}
	
	// Retourne le nombre de bords que la pierre touche
	int nBords() { 
		if((x==0 && y==0) || (x==0 && y==9) || (x==9 && y==0) || (x==9 && y==0)) {
			return 2;
		}
		else {
			if ( x==0 || y==0 || x==9 || y==9 ) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

	// Retourne la liste des pierres qui entoure 
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
		if (x!=9) {
			if (!goban.estLibre(x+1,y) ) {
				pEntoure.add(goban.retourPierre(x+1,y));
			}	
		}
		// Ajout de la pierre en dessous si elle existe
		if (y!=9) {
			if (!goban.estLibre(x,y+1)) {
				pEntoure.add(goban.retourPierre(x,y+1));
			}	
		}
		
		return pEntoure;
	}
	
	



}

