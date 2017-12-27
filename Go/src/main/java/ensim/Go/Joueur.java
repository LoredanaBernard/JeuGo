package ensim.Go;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	Goban goban;
	String couleur;
	int nPierre = 1;
	int nCaptureAdverse = 0;

	Joueur(String c){
		this.couleur=c;
	}

	// Place une pierre sur le goban
	public Pierre placerPierre(Goban goban, int x, int y) {
		Pierre p ;
		if (goban.estLibre(x, y)) {		// Si l'intersecrion du goban n'e'st pas encore prise
			p = new Pierre(this.couleur + this.nPierre, this.couleur); // Création d'une nouvelle pierre
			p.x = x;
			p.y = y;
			goban.matricePierre[x][y]= p;	// Attribution de la pierre à une intersection du goban
			nPierre++;
//			if ( p.entoureAdverse(goban).size()>0) {
//				capturePierre(goban, p);
//			}
			
		}
		else {
			p = null;
			System.out.println("Intersection non vide !");
		}
		return p;
	}
	// Compare 2 listes de Pierres
	public boolean compareList (List<Pierre> entoure, List<Pierre> aEnlever) {
		int i=0;
		for ( Pierre p : entoure) {
			for ( Pierre t : aEnlever) {
				if( p.equals(t)) {
					i++;
				}
			}
		}
		return (i == entoure.size());
	}


	// Capture pierre(s) adverse(s) 
	public void capturePierre(Goban goban, Pierre r) {

		List <Pierre> pEntoure = r.entoureAdverse(goban);
		List <Pierre> pEntoure2 = new ArrayList<Pierre>();
		List <Pierre> aEnlever = new ArrayList<Pierre>();
		List <Pierre> aAnalyser = new ArrayList<Pierre>();


		pEntoure = r.entoureAdverse(goban);
		pEntoure2 = pEntoure;
		for(Pierre p : pEntoure2) {
			
			while ( (aAnalyser.size()>0 || compareList(pEntoure, aEnlever) == false ) && (p.nLibertes(goban)==0) ) {
				if(aAnalyser.size()>0) {
					if(p.equals(aAnalyser.get(0))){
						aAnalyser.remove(0);
					}
				}

				aEnlever.add(p);				
				pEntoure = p.entoureAllie(goban);
				pEntoure2 = pEntoure;		// Liste des pierres pas encore analysées
				for ( Pierre l :p.entoureAllie(goban)) {
					for ( Pierre a : aAnalyser) {
						if ( l.equals(a)) {
							pEntoure2.remove(a);
						}
					}
					for ( Pierre e : aEnlever) {
						if ( l.equals(e)) {
							pEntoure2.remove(e);

						}
					}
				}
				if ( pEntoure2.size() == 0) {	//S'il faut passer à la liste de pierre à analyser
					if(aAnalyser.size()>0) {
						p = aAnalyser.get(0);		// p prend la valeur de la premiere pierre de la liste à analyser
					}
				}
				else {
					p = pEntoure2.get(0);
					if ( pEntoure2.size()>0 ) {	// S'il y a plus d'une pierre dans la liste de pierres adverses entourant
						for(int i=1 ; i< pEntoure2.size(); i++) {
							aAnalyser.add(pEntoure2.get(i)); 	// Ajout de la pierre dans la liste à analyser
						}
					}
				}				
			}
			pEntoure = r.entoureAdverse(goban);
			pEntoure2 = pEntoure;
		}

		
		// Suppression des pierres
		for (Pierre d : aEnlever) {
			if ( aEnlever.size()!=0) {
				goban.afficherGoban();
			}
			nCaptureAdverse += aEnlever.size();
			System.out.println("Pierre " + d.nom +" " + d.x + " "+ d.y+ " capturée");
			goban.matricePierre[d.x][d.y] = null;  // Libère l'intersection du goban 
			d.x = -1;	// Change la position de la pierre e, valeur négative pour sa sortie
			d.y = -1;
		}

	}

}
