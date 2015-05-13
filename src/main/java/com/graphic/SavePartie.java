import java.awt.List;
import java.io.BufferedWriter;
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
		  String csv = "data.csv";
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
			String[]	test ={ String.valueOf(partie[i][j].piece.getId()) ,String.valueOf(partie[i][j].x),String.valueOf(partie[i][j].x),String.valueOf(partie[i][j].orientation)};
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