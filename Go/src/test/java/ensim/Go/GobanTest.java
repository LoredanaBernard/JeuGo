package ensim.Go;

import junit.framework.TestCase;

public class GobanTest extends TestCase {
	Goban goban;


	public void testEstLibre() {
		goban = new Goban(9);
		Pierre p = new Pierre ("b1","n");
		goban.matricePierre[1][1] = p;
		assertEquals(false,goban.estLibre(1, 1));
		assertEquals(true,goban.estLibre(0, 1));
	}

	public void testRetourPierre() {
		goban = new Goban(9);
		assertEquals(null,goban.retourPierre(0, 2));
		
		Pierre p = new Pierre ("b1","n");
		goban.matricePierre[1][1] = p;
		assertEquals(p,goban.retourPierre(1, 1));
	}

}
