package ensim.Go;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		Goban goban = new Goban();
		Joueur j1 = new Joueur("n");
		Joueur j2 = new Joueur ("b");
		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		do {
			// Joueur 1
			int x1= -1;
			while ( x1<0 || x1>8 ) {
				System.out.println("Joueur 1 :veuillez saisir une position de pierre :");
				System.out.print("x : ");
				int str = sc.nextInt();
				x1 = str;
			}
			x=x1;
			int y2=-1;
			while ( y2<0 || y2>8 ) {
				System.out.print("y : ");
				int str3 = sc.nextInt();
				y2 = str3;
			}
			y =y2;
			Pierre p = j1.placerPierre(goban,x, y);
			goban.afficherGoban();
			j1.capturePierre(goban,p);
			
			// Joueur 2
			int x3=-1;
			while( x3<0 || x3>8 ) {
				System.out.println(" Joueur 2 : veuillez saisir une position de pierre :");
				System.out.print("x : ");
				int str2 = sc.nextInt();
				x3 = str2;
			}
			x=x3;
			int y3=-1;
			while ( y3<0 || y3>8 ) {
				System.out.print("y : ");
				int str2 = sc.nextInt();
				y3 = str2;
			}
			y=y3;
			
			Pierre d = j2.placerPierre(goban,x, y);
			goban.afficherGoban();
			j2.capturePierre(goban,d);
			
			System.out.print("Continuer ? ( -1 pour finir) ");
		}while ( sc.nextInt() != -1);
		
		
		finDeJeu(j1,j2);

}
}
