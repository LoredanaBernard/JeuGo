package ensim.Go;

import ensim.Go.Pierre;

public class Goban {
	Pierre [][] matricePierre;
	int taille;
	
	Goban(int taille){
		matricePierre = new Pierre [taille][taille];
		this.taille = taille;
	}
	
	// Afficher goban 
	public void afficherGoban () {
		System.out.println(" ");
		for ( int i=0 ; i<taille ; i++) {
			for ( int j=0 ; j<taille ; j++) {
				if ( estLibre(i,j)) {
					if (j<(taille-1)) {
						System.out.print(" + ");
					}
					else {
						System.out.println(" + ");
					}
					
				}
				else {
					if ( j<(taille-1)) {
						System.out.print(" " + matricePierre[i][j].color+" ");
					}
					else {
						System.out.println(" " + matricePierre[i][j].color+" ");
					}
				}
			}
		}
	}
	// Retourne si l'intersection est vide 
	public boolean estLibre(int l, int c) {
		return ( matricePierre[l][c] == null);
	}
	
	// Retourne une pierre à une position donnée
	public Pierre retourPierre(int l,int c) {
		if (!estLibre(l,c)) {
			return matricePierre[l][c];
		}
		else {
			return null;
		}		
	}

	

}
