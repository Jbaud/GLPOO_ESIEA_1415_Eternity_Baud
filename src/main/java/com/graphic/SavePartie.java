package main.java.com.graphic;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

// a refaire, ecriture csv 
public class SavePartie{

	//public Partie[][] partie;
	
	public SavePartie(){
		
		
	}
	
	public void savePartie(Partie[][] partie)
	{
		//////////////////////////////////////
		File newfile =new File("partie3.csv");
		File oldfile =new File("partie2.csv");
 
		if(oldfile.renameTo(newfile)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}
		File newfile2 =new File("partie2.csv");
		File oldfile2 =new File("partie1.csv");
 
		if(oldfile2.renameTo(newfile2)){
			System.out.println("Rename succesful");
		}else{
			System.out.println("Rename failed");
		}		
		//////////////////////////////////////
		
		  String csv = "partie1.csv";
	      CSVWriter writer = null;
		try {
		writer = new CSVWriter(new FileWriter(csv), ',', 
				    CSVWriter.NO_QUOTE_CHARACTER, 
				    CSVWriter.NO_ESCAPE_CHARACTER, 
				    System.getProperty("line.separator"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	ArrayList test = new ArrayList();
		
	    for (int i = 0; i < partie.length; i++) {
			for (int j = 0; j < partie.length; j++) {
			String[]	test ={ String.valueOf(partie[i][j].piece.getId()) ,String.valueOf(partie[i][j].x), String.valueOf(partie[i][j].y), String.valueOf(partie[i][j].orientation)};
			 writer.writeNext(test);
			}
		}    	        
	    //  writer.writeNext(test);
	        
	      try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}