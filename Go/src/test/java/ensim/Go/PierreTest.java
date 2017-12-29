package ensim.Go;

import java.util.List;

import junit.framework.TestCase;

public class PierreTest extends TestCase {
	
	Pierre p = new Pierre ("b1","n");
	Goban goban;

	public void testPierre() {
		 assertEquals("b1",p.nom);
		 assertEquals("n",p.color);
	}

	public void testNBords() {
		// Tests de retour 2
		p.l = 0;
		p.c = 0;
		assertEquals(2,p.nBords());
		
		p.l = 0;
		p.c = 8;
		assertEquals(2,p.nBords());
		
		p.l = 8;
		p.c = 0;
		assertEquals(2,p.nBords());
		
		p.l = 8;
		p.c = 8;
		assertEquals(2,p.nBords());
		
		// Tests de retour 1
		p.l = 0;
		p.c = 1;
		assertEquals(1,p.nBords());
		
		p.l = 2;
		p.c = 0;
		assertEquals(1,p.nBords());
		
		p.l = 8;
		p.c = 2;
		assertEquals(1,p.nBords());
		
		p.l = 1;
		p.c = 8;
		assertEquals(1,p.nBords());
		
		// Tests de retour 0
		p.l = 1;
		p.c = 2;
		assertEquals(0,p.nBords());
		
		p.l = 5;
		p.c = 1;
		assertEquals(0,p.nBords());
		
		p.l = 6;
		p.c = 6;
		assertEquals(0,p.nBords());
		
	}

	public void testEntoure() {
		goban = new Goban(9);
		p.l =1;
		p.c =1;
		goban.matricePierre[1][1] = p;
		
		List<Pierre> list;
		list = p.entoure(goban);
		// test de 0 pierre autour
		assertEquals(0,list.size());
		
		Pierre p2 = new Pierre("p2","n");
		p2.l =0;
		p2.c =1;
		goban.matricePierre[0][1] = p2;
		
		// Test de 1 pierre autour
		list = p.entoure(goban);
		assertEquals(1,list.size());
		
		
		Pierre p3 = new Pierre("p3","n");
		p3.l =1;
		p3.c =2;
		goban.matricePierre[1][2] = p3;
				
		list = p.entoure(goban);
		
		// Test de 2 pierres autour de p
		assertEquals(2,list.size());
		
		// Test de 4 pierres autour
		Pierre p4 = new Pierre("p4","n");
		p4.l =2;
		p4.c =1;
		goban.matricePierre[2][1] = p4;
		
		Pierre p5 = new Pierre("p5","n");
		p5.l =1;
		p5.c =0;
		goban.matricePierre[1][0] = p5;
		
		list = p.entoure(goban);
		assertEquals(4,list.size());
	}

	public void testEntoureAdverse() {
		goban = new Goban(9);
		p.l =1;
		p.c =1;
		goban.matricePierre[1][1] = p;		
		
		Pierre p2 = new Pierre("p2","b");
		p2.l =0;
		p2.c =1;
		goban.matricePierre[0][1] = p2;
		
		Pierre p3 = new Pierre("p3","b");
		p3.l =1;
		p3.c =2;
		goban.matricePierre[1][2] = p3;
		
		List<Pierre> list2;
		list2 = p.entoure(goban);
		
		assertEquals(2,list2.size());

	}

	public void testEntoureAllie() {
		goban = new Goban(9);
		p.l =1;
		p.c =1;
		goban.matricePierre[1][1] = p;		
		
		Pierre p2 = new Pierre("p2","n");
		p2.l =0;
		p2.c =1;
		goban.matricePierre[0][1] = p2;
		
		Pierre p3 = new Pierre("p3","b");
		p3.l =1;
		p3.c =2;
		goban.matricePierre[1][2] = p3;
		
		List<Pierre> list3;
		list3 = p.entoure(goban);
		
		assertEquals(1,list3.size());

	}

	public void testNLibertes() {
		Goban goban = new Goban(9);
		Pierre p = new Pierre("p1","b");
		Pierre p2 = new Pierre("p2","n");
		Pierre p3 = new Pierre("p3","n");
		
		goban.matricePierre[1][1] = p;
		p.l = 1;
		p.c=1;		
		
		p2.l=1;
		p2.c=2;
		goban.matricePierre[1][2]= p2;
		
		p3.l=0;
		p3.c=8;
		goban.matricePierre[0][8]= p3;
		
		// Test du nombre de libertés de p
		assertEquals(3,p.nLibertes(goban));
		
		// Test du nombre de libertées de p3
		assertEquals(2,p3.nLibertes(goban));
	}

}
