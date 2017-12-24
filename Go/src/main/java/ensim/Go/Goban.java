package ensim.Go;

import ensim.Go.Pierre;

public class Goban {
	Pierre [][] matricePierre;
	
	Goban(){
		matricePierre = new Pierre [9][9];		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
