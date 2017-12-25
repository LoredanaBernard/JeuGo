package ensim.Go;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goban goban = new Goban();
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
	}

}
