package ensim.Go;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	static Scanner sc; 
	static int l;
	static int c;
	static Goban goban;
	
	public static int initialiserJeu() {
		int t;
		sc = new Scanner(System.in);
		System.out.print("Taille du goban : ");
		int str = sc.nextInt();
		t = str;
		if ( t<0) {
			initialiserJeu();
		}
		return t;
	}
	
	// Affichage du gagnant et des scores
	public static void finDeJeu (Joueur j1, Joueur j2) {
		int scoreJ1 = j1.nPierre -j2.nCaptureAdverse;
		int scoreJ2 = j2.nPierre -j1.nCaptureAdverse;
		
		if (scoreJ1 > scoreJ2) {
			System.out.println("Le gagnant est Joueur 1 ! (" + scoreJ1 + " - " + scoreJ2 + ")");
		}
		else {
			if ( scoreJ1 < scoreJ2) {
				System.out.println("Le gagnant est Joueur 2 ! (" + scoreJ2 + " - " + scoreJ1 + ")" );
			}
			else {
				System.out.println("Egalité entre les 2 joueurs ! ");
				
			}
			
		}
		
	}
	
	// Saisie des coordonnes de pierres à placer et capture si possible
	public static void afficherInstructions(Joueur j, String nom, Goban goban) {
		sc = new Scanner(System.in);
		int x1= -1;
		while ( x1<0 || x1>goban.taille ) {
			System.out.println("\n"+nom + ", veuillez saisir une position de pierre :");
			System.out.print("Ligne : ");
			int str = sc.nextInt();
			x1 = str;
		}
		l=x1;
		int y2=-1;
		while ( y2<0 || y2>goban.taille ) {
			System.out.print("Colonne : ");
			int str3 = sc.nextInt();
			y2 = str3;
		}
		c =y2;
		Pierre p = j.placerPierre(goban,l, c);
		goban.afficherGoban();
		if ( goban.estLibre(l, c)) {
			j.capturePierre(goban,p);		
		}
		else {
			afficherInstructions(j,nom,goban);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Goban goban = new Goban(initialiserJeu());
		Joueur j1 = new Joueur("b");
		Joueur j2 = new Joueur("n");
		
		do {
			afficherInstructions(j1, "Joueur 1", goban);
			afficherInstructions(j2, "Joueur 2", goban);					
			System.out.print("Continuer ? ( -1 pour finir) ");
		}while ( sc.nextInt() != -1);
				
		finDeJeu(j1,j2);

}
}
