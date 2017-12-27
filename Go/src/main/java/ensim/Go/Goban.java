package ensim.Go;

import ensim.Go.Pierre;

public class Goban {
	Pierre [][] matricePierre;
	
	Goban(){
		matricePierre = new Pierre [9][9];		
	}
	
	// Afficher goban 
	public void afficherGoban () {
		System.out.println(" ");
		for ( int i=0 ; i<9 ; i++) {
			for ( int j=0 ; j<9 ; j++) {
				if ( estLibre(i,j)) {
					if (j<8) {
						System.out.print(" + ");
					}
					else {
						System.out.println(" + ");
					}
					
				}
				else {
					if ( j<8) {
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
	public boolean estLibre(int x, int y) {
		return ( matricePierre[x][y] == null);
	}
	
	// Retourne une pierre à une position donnée
	public Pierre retourPierre(int x,int y) {
		if (!estLibre(x,y)) {
			return matricePierre[x][y];
		}
		else {
			return null;
		}		
	}

	

}
