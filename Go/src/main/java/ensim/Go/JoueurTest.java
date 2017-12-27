package ensim.Go;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class JoueurTest extends TestCase {
	Goban goban;
		
	public void testJoueur() {
		Joueur j = new Joueur("n");
		assertEquals("n",j.couleur);
	}

	public void testPlacerPierre() {
		Joueur j = new Joueur("n");
		goban = new Goban();
		assertEquals("n",j.placerPierre(goban,1,1).color);
		assertEquals("n2",j.placerPierre(goban,1,2).nom);
		
	}

	public void testCompareList() {
		Joueur j = new Joueur("n");
		List<Pierre> l1 = new ArrayList<Pierre>();
		List<Pierre> l2 = new ArrayList<Pierre>();
		
		Pierre p = new Pierre("b1","b");
		Pierre p2 = new Pierre("b2","b");
		Pierre p3 = new Pierre("n1","n");
		l1.add(p);
		l1.add(p2);
		l2.add(p);
				
		assertEquals(true,j.compareList(l2, l1)); // l1 contient bien tous les éléments de l2
		assertEquals(false,j.compareList(l1, l2));
		l2.add(p3);
		assertEquals(false,j.compareList(l2, l1));	// l1 ne contient pas tous les éléments de l2
		l1.add(p3);
		assertEquals(true,j.compareList(l2, l1));
	}

	public void testCapturePierre() {
		Goban goban = new Goban();
		Joueur j = new Joueur("n");
		Pierre p = new Pierre("p1","b");
		Pierre p2 = new Pierre("p2","n");
		Pierre p3 = new Pierre("p3","n");
		Pierre p4 = new Pierre("p4","n");
		Pierre p5 = new Pierre("p5","n");
			
		p.x = 1;
		p.y=1;		
		goban.matricePierre[1][1] = p;
		
		p2.x=1;
		p2.y=2;
		goban.matricePierre[1][2]= p2;
		
		p3.x=1;
		p3.y=0;
		goban.matricePierre[1][0]= p3;

		p4.x=0;
		p4.y=1;
		goban.matricePierre[0][1]= p4;

		p5.x=2;
		p5.y=1;
		goban.matricePierre[2][1]= p5;
		
		assertEquals(false,goban.estLibre(1, 1));
		j.capturePierre(goban, p5);
		assertEquals(true,goban.estLibre(1, 1));
		
	}

}
