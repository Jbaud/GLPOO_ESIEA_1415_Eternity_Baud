package test.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.graphic.Face;
import main.java.com.graphic.Orientation;
import main.java.com.graphic.Partie;
import main.java.com.graphic.Piece;
import main.java.com.graphic.Score;
import main.java.com.graphic.Temps;

public class PartieTest {

		private Partie[][] partieTest;
		private Piece p1;
		private Piece p2;
		public HashMap<Integer, Piece> map_pieces;
		public Map<Integer, Face> map_faces;
		public ArrayList<Score> liste_score;
		
		public PartieTest(){
			

			Face f0 = new Face(0,"noir",'B');
			Face f1 = new Face(1,"bandes_violet_jaune",'F');
			Face f2 = new Face(2,"etoile_bleu_jaune",'F');
			Face f3 = new Face(3,"shuriken_vert_bleu",'F');
			Face f4 = new Face(4,"zigzag_rouge_blanc",'F');
			Face f5 = new Face(5,"coeur_blanc_rose",'F');
			Face f6 = new Face(6,"rayures_orange_vert",'F');
			Face f7 = new Face(7,"fleche_rouge_orange",'F');
			Face f8 = new Face(8,"triangle_rose_violet",'F');
			
			map_faces = new HashMap<Integer,Face>();
			
			this.map_faces.put(0, f0);
			this.map_faces.put(1, f1);
			this.map_faces.put(2, f2);
			this.map_faces.put(3, f3);
			this.map_faces.put(4, f4);
			this.map_faces.put(5, f5);
			this.map_faces.put(6, f6);
			this.map_faces.put(7, f7);
			this.map_faces.put(8, f8);
			
			ArrayList<Face> liste = new ArrayList<Face>();
			liste.add(f0);
			liste.add(f0);
			liste.add(f3);
			liste.add(f6);
			
			Piece p1 = new Piece(1, liste);
			this.p1=p1;
			
			ArrayList<Face> liste2 = new ArrayList<Face>();
			liste2.add(f0);
			liste2.add(f0);
			liste2.add(f8);
			liste2.add(f8);
			
			Piece p2 = new Piece(2, liste2);
			this.p2=p2;
			
			ArrayList<Face> liste3 = new ArrayList<Face>();
			liste3.add(f0);
			liste3.add(f0);
			liste3.add(f8);
			liste3.add(f6);
			
			Piece p3 = new Piece(3, liste3);
		
			
			ArrayList<Face> liste4 = new ArrayList<Face>();
			liste4.add(f0);
			liste4.add(f0);
			liste4.add(f7);
			liste4.add(f4);
			
			Piece p4 = new Piece(4, liste4);
		
			ArrayList<Face> liste5 = new ArrayList<Face>();
			liste5.add(f0);
			liste5.add(f1);
			liste5.add(f5);
			liste5.add(f3);
			
			Piece p5 = new Piece(5, liste5);
		
			
			ArrayList<Face> liste6 = new ArrayList<Face>();
			liste6.add(f0);
			liste6.add(f8);
			liste6.add(f5);
			liste6.add(f1);
			
			Piece p6 = new Piece(6, liste6);
		
			ArrayList<Face> liste7 = new ArrayList<Face>();
			liste7.add(f0);
			liste7.add(f3);
			liste7.add(f6);
			liste7.add(f8);
			
			Piece p7 = new Piece(7, liste7);
		
			
			ArrayList<Face> liste8 = new ArrayList<Face>();
			liste8.add(f0);
			liste8.add(f6);
			liste8.add(f4);
			liste8.add(f3);
			
			Piece p8 = new Piece(8, liste8);
			
			ArrayList<Face> liste9 = new ArrayList<Face>();
			liste9.add(f0);
			liste9.add(f5);
			liste9.add(f3);
			liste9.add(f8);
			
			Piece p9 = new Piece(9, liste9);
		
			
			ArrayList<Face> liste10 = new ArrayList<Face>();
			liste10.add(f0);
			liste10.add(f4);
			liste10.add(f2);
			liste10.add(f5);
			
			Piece p10 = new Piece(10, liste10);
		
			ArrayList<Face> liste11 = new ArrayList<Face>();
			liste11.add(f0);
			liste11.add(f4);
			liste11.add(f1);
			liste11.add(f7);
			
			Piece p11 = new Piece(11, liste11);
		
			
			ArrayList<Face> liste12 = new ArrayList<Face>();
			liste12.add(f0);
			liste12.add(f6);
			liste12.add(f7);
			liste12.add(f4);
			
			Piece p12 = new Piece(12, liste12);
		
			ArrayList<Face> liste13 = new ArrayList<Face>();
			liste13.add(f2);
			liste13.add(f2);
			liste13.add(f7);
			liste13.add(f5);
			
			Piece p13 = new Piece(13, liste13);
		
			
			ArrayList<Face> liste14 = new ArrayList<Face>();
			liste14.add(f2);
			liste14.add(f5);
			liste14.add(f6);
			liste14.add(f1);
			
			Piece p14 = new Piece(14, liste14);
		
			ArrayList<Face> liste15 = new ArrayList<Face>();
			liste15.add(f1);
			liste15.add(f2);
			liste15.add(f7);
			liste15.add(f2);
			
			Piece p15 = new Piece(15, liste15);
		
			
			ArrayList<Face> liste16 = new ArrayList<Face>();
			liste16.add(f3);
			liste16.add(f7);
			liste16.add(f1);
			liste16.add(f4);
			
			Piece p16 = new Piece(16, liste16);
			
			Partie partie1 = new Partie(p1, 0, 0, Orientation.OUEST);
			Partie partie2 = new Partie(p2, 0, 3, Orientation.NORD);
			Partie partie3 = new Partie(p3, 3, 3, Orientation.EST);
			Partie partie4 = new Partie(p4, 3, 0, Orientation.SUD);
			Partie partie5 = new Partie(p5, 0, 1, Orientation.NORD);
			Partie partie6 = new Partie(p6, 0, 2, Orientation.NORD);
			Partie partie7 = new Partie(p7, 1, 3, Orientation.EST);
			Partie partie8 = new Partie(p8, 2, 3, Orientation.EST);
			Partie partie9 = new Partie(p9, 3, 2, Orientation.SUD);
			Partie partie10 = new Partie(p10, 3, 1, Orientation.SUD);
			Partie partie11 = new Partie(p11, 2, 0, Orientation.OUEST);
			Partie partie12 = new Partie(p12, 1, 0, Orientation.OUEST);
			Partie partie13 = new Partie(p13, 1, 1, Orientation.EST);
			Partie partie14 = new Partie(p14, 1, 2, Orientation.OUEST);
			Partie partie15 = new Partie(p15, 2, 1, Orientation.OUEST);
			Partie partie16 = new Partie(p16, 2, 2, Orientation.SUD);

			
			Partie[][] partieTest = new Partie[4][4];
			partieTest[0][0]=partie1;
			partieTest[0][3]=partie2;
			partieTest[3][3]=partie3;
			partieTest[3][0]=partie4;
			partieTest[0][1]=partie5;
			partieTest[0][2]=partie6;
			partieTest[1][3]=partie7;
			partieTest[2][3]=partie8;
			partieTest[3][2]=partie9;
			partieTest[3][1]=partie10;
			partieTest[2][0]=partie11;
			partieTest[1][0]=partie12;
			partieTest[1][1]=partie13;
			partieTest[1][2]=partie14;
			partieTest[2][1]=partie15;
			partieTest[2][2]=partie16;

			this.partieTest = partieTest;
			
			map_pieces = new HashMap<Integer, Piece>();
			
			this.map_pieces.put(0, p1);
			this.map_pieces.put(1, p1);
			this.map_pieces.put(2, p2);
			this.map_pieces.put(3, p3);
			this.map_pieces.put(4, p4);
			this.map_pieces.put(5, p5);
			this.map_pieces.put(6, p6);
			this.map_pieces.put(7, p7);
			this.map_pieces.put(8, p8);
			this.map_pieces.put(9, p9);
			this.map_pieces.put(10, p10);
			this.map_pieces.put(11, p11);
			this.map_pieces.put(12, p12);
			this.map_pieces.put(13, p13);
			this.map_pieces.put(14, p14);
			this.map_pieces.put(15, p15);
			this.map_pieces.put(16, p16);
			
			//affichage pieces a enelever
		
			liste_score = new ArrayList<Score>();
			liste_score.add(new Score("Joueur1",new Temps(2,50)));
			liste_score.add(new Score("Joueur2",new Temps(1,50)));
			liste_score.add(new Score("Joueur3",new Temps(0,50)));
			liste_score.add(new Score("Joueur4",new Temps(2,50)));
			liste_score.add(new Score("Joueur6",new Temps(27,30)));
			liste_score.add(new Score("Joueur5",new Temps(11,20)));
		
			
		}

		public Partie[][] getPartieTest() {
			return partieTest;
		}

		public void setPartieTest(Partie[][] partieTest) {
			this.partieTest = partieTest;
		}

		public Piece getP1() {
			return p1;
		}

		public void setP1(Piece p1) {
			this.p1 = p1;
		}

		public Piece getP2() {
			return p2;
		}

		public void setP2(Piece p2) {
			this.p2 = p2;
		}
		
}
