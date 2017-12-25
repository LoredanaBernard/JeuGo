package ensim.Go;

public class Joueur {
	Goban goban;
	String couleur;
	int nPierre = 1;
	
	Joueur(String c){
		this.couleur=c;
	}
	
	// Place une pierre sur le goban
	public void placerPierre(Goban goban, int x, int y) {
		if (goban.estLibre(x, y)) {		// Si l'intersecrion du goban n'e'st pas encore prise
			Pierre p = new Pierre(this.couleur + this.nPierre); // Création d'une nouvelle pierre
			p.x = x;
			p.y = y;
			goban.matricePierre[x][y]= p;	// Attribution de la pierre à une intersection du goban
			nPierre++;
		}		
	}
	
	// Capture pierre(s) adverse(s) 
	public void capturePierre(Goban goban, int x, int y) {
		
		// Capture les pierres adverses qui n'ont plus de libertés 
		// Liste de pierres qui representent un territoire 
		// Efface toutes les pierres de ce territoire
	}

}
