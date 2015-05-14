package main.java.com.graphic;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestJLabel {
	
	private String stringSec3;
	private String stringMin1;
	private String stringSec1;
	private String stringMin2;
	private String stringSec2;
	private String stringMin3;
	public TestJLabel(){
		 JFrame frame = new JFrame();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			int min1=12;
			int sec1=2;
			int min2=3;
			int sec2=6;
			int min3=42;
			int sec3=25;
			
			String nom1="Michel";
			String nom2="Bruno";
			String nom3="BobLaTomate";
			String stringMin1 = Integer.toString(min1);
			String stringSec1 = Integer.toString(sec1);
			String stringMin2 = Integer.toString(min2);
			String stringSec2 = Integer.toString(sec2);
			String stringMin3 = Integer.toString(min3);
			String stringSec3 = Integer.toString(sec3);
			
		    if (min1 < 10)
		    {
		  	this.stringMin1 = "0" + Integer.toString(min1);
		    }
		        
		    if (sec1 < 10)
		    {
		  	this.stringSec1 = "0" + Integer.toString(sec1);
		    }
		    
		    if (min2 < 10)
		    {
		  	this.stringMin2 = "0" + Integer.toString(min2);
		    }
		        
		    if (sec2 < 10)
		    {
		  	this.stringSec2 = "0" + Integer.toString(sec2);
		    }
		    
		    if (min3 < 10)
		    {
		  	this.stringMin3 = "0" + Integer.toString(min3);
		    }
		    
		    if (sec3 < 10)
		    {
		  	this.stringSec3 = "0" + Integer.toString(sec3);
		    }
		    
		    Object rowData[][] = { { "1", nom1, min1+":"+sec1 },
			        { "2", nom2, min2+":"+sec2 },
			        { "3", nom3 , min3+":"+sec3 } };
			    Object columnNames[] = { "Classement", "Nom du Joueur", "Temps" };
		    JTable table = new JTable(rowData, columnNames);

		    JScrollPane scrollPane = new JScrollPane(table);
		    ((JLabel)table.getDefaultRenderer(String.class)).setHorizontalTextPosition(JLabel.CENTER);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    frame.setSize(300, 150);
		    frame.setVisible(true);
	}
  public static void main(String args[]) {
	  TestJLabel FenetreScore = new TestJLabel();
		FenetreScore.setVisible(true);

  }
private void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}