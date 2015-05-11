import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fenetre extends JFrame implements KeyListener,ActionListener,MouseListener{
	
	public static void main(String[] args) {
	
		Fenetre test = new Fenetre();
	
			
	}
	


	//Object graphique
	private JPanel panel;
	private JFrame frame;

	private JLabel time = new JLabel("00:00");

    //Timer
	Timer timer1;
    int var_time = 0;
    ActionListener tache_timer = new ActionListener()  {
		  public void actionPerformed(ActionEvent e1)  {

			  var_time++;
			
			  int minute = var_time/60;
	          int seconde = var_time - (minute*60);
	
	          String sm = Integer.toString(minute);
	          if (minute < 10){ sm = "0" + Integer.toString(minute);}
	          String ss = Integer.toString(seconde);
	          if (seconde < 10){ ss = "0" + Integer.toString(seconde);}

			  time.setText(sm+":"+ss);		 
		 }
     };		 
     
	
	public Fenetre() {
		renderGame();
	}
	
	
	private void renderGame(){	
		
		//Creation de la fenetre
	
		frame = new JFrame("Eternity Game");  
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	    
	    panel = (JPanel)frame.getContentPane();  
	    panel.setLayout(null);
	    
	
	    
	    //timer
		Font font = new Font("Arial",Font.BOLD,33);
		time.setFont(font);		
		time.setOpaque(true);
		time.setBounds(500,30,500,30);	
		
		time.setBackground(Color.black);
		time.setForeground(Color.white);
					
   		timer1 = new Timer(1000, tache_timer);		
   		
   		timer1.start();   
    
        panel.add(time);             
        frame.setSize(650, 450);
   		frame.setVisible(true);	
   		frame.setResizable(false);
   		

	}



		
	
	//Evenement	
	public void actionPerformed(ActionEvent e) {			
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

		public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	
}