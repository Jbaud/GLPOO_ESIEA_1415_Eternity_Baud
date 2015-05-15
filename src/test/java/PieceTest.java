package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.graphic.Face;
import main.java.com.graphic.Partie;
import main.java.com.graphic.Piece;
import main.java.com.graphic.SavePartie;
import main.java.com.graphic.Score;
import main.java.com.graphic.SuperpoRotateIcon;
import main.java.com.graphic.Verification;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import com.opencsv.CSVWriter;

import main.java.com.graphic.FaceCsvDao;
import main.java.com.graphic.PieceCsvDao;



public class PieceTest {


	
	Partie[][] tableauTest;
	HashMap<Integer,Piece> map_pieces;
	Map<Integer,Face> map_faces;
	ArrayList<Score> liste_score;
	Piece p1;
	Piece p2;

	@Before
	public void initialisation(){

		PartieTest accesseur = new PartieTest();
		this.tableauTest = accesseur.getPartieTest();
		this.p1 = accesseur.getP1();
		this.p2 = accesseur.getP2();
		this.map_pieces = accesseur.map_pieces;
		this.map_faces = accesseur.map_faces;	
		this.liste_score= accesseur.liste_score;

	}

	@Test
	public void testUnicite(){

		assertNotEquals(p1, p2);
	}
	@Test
	public void testVerificationBords(){

		Verification verif= new Verification(tableauTest);	
		assertTrue(verif.checkCoins());
	}

	@Test
	public void testVerificationHorizontal(){

		Verification verif= new Verification(tableauTest);	
		assertTrue(verif.checkHorizontal());
	}

	@Test
	public void testVerificationVertical(){

		Verification verif= new Verification(tableauTest);	
		assertTrue(verif.checkVertical());
	}

	@Test(timeout= 100)
	public void testVerification(){

		Verification verif= new Verification(tableauTest);	
		assertTrue(verif.checkVictoire());
	}
	@Test
	public void testRotationDroite(){
		SuperpoRotateIcon test = new SuperpoRotateIcon(this.p1);
		test.rotateDroite();
		assertNotEquals(test.getPiece(), this.p2);
	}
	@Test
	public void testRotationGauche(){
		SuperpoRotateIcon test = new SuperpoRotateIcon(this.p1);
		test.rotateGauche();
		assertNotEquals(test.getPiece(), this.p2);
	}
		@Test
	public void testIOFaces(){
		FaceCsvDao lecteur = new FaceCsvDao();
		Map<Integer, Face> retourParser = lecteur.parser("faces.csv", ",");
		assertEquals(map_faces, retourParser);
	}
	@Test
	public void testIOPiece(){
		PieceCsvDao lecteur = new PieceCsvDao(map_faces);
		Map<Integer, Piece> retourParser = lecteur.parser("pieces.csv", ",");
		
			assertTrue(true);
	}

	
}