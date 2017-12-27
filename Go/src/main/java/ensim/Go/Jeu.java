package ensim.Go;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
	
	public void finDeJeu (Joueur j1, Joueur j2) {
		int scoreJ1 = j1.nPierre -j2.nCaptureAdverse;
		int scoreJ2 = j2.nPierre -j1.nCaptureAdverse;
		
		if (scoreJ1 > scoreJ2) {
			System.out.println("Le gagnant est Joueur 1 ! " );
		}
		else {
			System.out.println("Le gagnant est Joueur 2 ! " );
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Goban goban = new Goban();
		Pierre p = new Pierre("p1");
		Pierre p2 = new Pierre("p2");
		Pierre p3 = new Pierre("p3");
		
		goban.matricePierre[1][1] = p;
		p.x = 1;
		p.y=1;
		
		
		p2.x=1;
		p2.y=2;
		goban.matricePierre[1][2]= p2;
		
		p3.x=0;
		p3.y=8;
		goban.matricePierre[0][8]= p3;
		
		
		System.out.println("Pierre à x=1 et y=1 : " + goban.retourPierre(1,1).nom);
		System.out.println("Intersection 1,2 libre : " + goban.estLibre(1,2));
		System.out.println("Intersection 1,1 libre : " + goban.estLibre(1,1));
		
		List<Pierre> list;
		list = p2.entoure(goban);
		for( int i=0 ; i<list.size(); i++) {
			System.out.println("Pierre(s) qui entoure(nt) la pierre p2 :" + list.get(i).nom);
		}
		System.out.println("Nombre de libertés de p2 :" + p2.nLibertes(goban));
		System.out.println("Nombre de libertés de p3 :" + p3.nLibertes(goban));
		
		
		Goban goban = new Goban();
		Joueur j1 = new Joueur("b");
		Joueur j2 = new Joueur ("n");
		
		
		//System.out.println("Intersection 1,1 libre : " + goban.estLibre(1,1));
		j1.placerPierre(goban, 1, 1);
	//System.out.println("Intersection 1,1 libre : " + goban.estLibre(1,1));
		//j1.placerPierre(goban, 1, 1);
		Pierre p =j1.placerPierre(goban, 6, 2);
		Pierre p2 =j1.placerPierre(goban, 7, 2);
		Pierre p3 =j1.placerPierre(goban, 7, 3);
		Pierre p4 =j1.placerPierre(goban, 7, 4);
		Pierre p5 =j1.placerPierre(goban, 7, 5);
		Pierre p6 =j1.placerPierre(goban, 6, 6);
		Pierre p7 =j1.placerPierre(goban, 5, 7);
		Pierre p8 =j1.placerPierre(goban, 4, 7);
		Pierre p9 =j1.placerPierre(goban, 3, 6);
		Pierre p10 =j1.placerPierre(goban, 3, 5);
		Pierre p11=j1.placerPierre(goban, 3, 4);
		Pierre p12=j1.placerPierre(goban, 4, 4);
		Pierre p13=j1.placerPierre(goban, 5, 3);
		Pierre p14=j1.placerPierre(goban, 5, 1);
		Pierre p15=j1.placerPierre(goban, 7, 1);
		Pierre p16=j1.placerPierre(goban, 7, 0);
		Pierre p17=j1.placerPierre(goban, 5, 0);
		
		
		Pierre d1 =j2.placerPierre(goban, 6, 3);
		Pierre d2 =j2.placerPierre(goban, 6, 4);
		Pierre d3 =j2.placerPierre(goban, 6, 5);
		Pierre d4 =j2.placerPierre(goban, 4,6 );
		Pierre d5 =j2.placerPierre(goban, 5, 4);
		Pierre d6 =j2.placerPierre(goban, 5, 5);
		Pierre d7 =j2.placerPierre(goban, 5, 6);
		Pierre d8 =j2.placerPierre(goban, 4, 5);
		Pierre d9 =j2.placerPierre(goban, 6, 1);
		Pierre d10=j2.placerPierre(goban, 6, 0);
		goban.afficherGoban();
		//System.out.println("Intersection 2,2 occupée par : " + goban.matricePierre[2][2].nom);
	//	p.entoure(goban);
		//p.entoureAdverse(goban);
		j1.capturePierre(goban, p);
		int scoreJ1 = j1.nPierre -j2.nCaptureAdverse;
		int scoreJ2 = j2.nPierre -j1.nCaptureAdverse;
		
		if (scoreJ1 > scoreJ2) {
			System.out.println("Le gagnant est Joueur 1 ! " );
		}
		else {
			System.out.println("Le gagnant est Joueur 2 ! " );
		}*/
		
		
		Goban goban = new Goban();
		Joueur j1 = new Joueur("b");
		Joueur j2 = new Joueur ("n");
		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		do {
			// Joueur 1 
			System.out.println("Veuillez saisir une position de pierre :");
			System.out.print("x : ");
			int str = sc.nextInt();
			x = str;
			System.out.print("y : ");
			str = sc.nextInt();
			y = str;
			Pierre p = j1.placerPierre(goban,x, y);
			goban.afficherGoban();
			j1.capturePierre(goban,p);
			
			// Joueur 2
			System.out.println("Veuillez saisir une position de pierre :");
			System.out.print("x : ");
			int str2 = sc.nextInt();
			x = str2;
			System.out.print("y : ");
			str2 = sc.nextInt();
			y = str2;
			Pierre d = j2.placerPierre(goban,x, y);
			goban.afficherGoban();
			j2.capturePierre(goban,d);
			
			System.out.print("Continuer ? ");
		}while ( sc.nextInt() != -1);
	}

}
