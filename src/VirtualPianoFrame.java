// Fig. 25.5: MenuFrame.java
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.OverlayLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class VirtualPianoFrame extends JFrame implements KeyListener{
	WhiteKey[] whiteKeys = new WhiteKey[14];
	BlackKey[] blackKeys = new BlackKey[10];
	String[] whiteNotes = {"c3", "d3", "e3", "f3", "g3", "a3", "b3", 
						   "c4", "d4", "e4", "f4", "g4", "a4", "b4"};
	String[] blackNotes = {"cs3", "ds3", "fs3", "gs3", "as3", 
			   			   "cs4", "ds4", "fs4", "gs4", "as4"};
	LayoutManager keyLayout;
	JPanel whiteKeyPanel, blackKeyPanel, overlayPanel;
	JLabel instructions;
	JLabel[] whiteSpace = new JLabel[3];
	
	// no-argument constructor set up GUI
	public VirtualPianoFrame(){
		super( "Virtual Piano - Jonathan Dao" );
		setMinimumSize(new Dimension(1440, 400));
		
		instructions = new JLabel("Use a, s, d, f, g, h, j, w, e, r, t, y to play notes. Hold Shift to use higher ocatave");
		instructions.setFont(new Font("Arial", Font.PLAIN, 20));
		add(instructions, BorderLayout.PAGE_START);
		
		overlayPanel = new JPanel(){
			public boolean isOptimizedDrawingEnabled(){
				return false;
			}
		};
		overlayPanel.addKeyListener(this);
		keyLayout = new OverlayLayout(overlayPanel);
		overlayPanel.setLayout(keyLayout);
		//keyPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//keyPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		//keyPane.setSize(this.getWidth(), 300);
		
		whiteKeyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		whiteKeyPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		whiteKeyPanel.setSize(this.getWidth(), 300);
		whiteKeyPanel.addKeyListener(this);
		
		for(int i = 0; i < 14; i++){
			whiteKeys[i] = new WhiteKey(whiteNotes[i]);
			whiteKeys[i].setPreferredSize(new Dimension(100, 250));
			whiteKeys[i].addKeyListener(this);
			whiteKeyPanel.add(whiteKeys[i], new Integer(14 - i), -1);
		}
		
		blackKeyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		blackKeyPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		blackKeyPanel.setSize(this.getWidth(), 300);
		blackKeyPanel.setOpaque(false);
		blackKeyPanel.addKeyListener(this);

		for(int i = 0; i < 10; i++){
			blackKeys[i] = new BlackKey(blackNotes[i]);
			blackKeys[i].addKeyListener(this);
			blackKeys[i].setPreferredSize(new Dimension(80, 150));
		}
		for(int i = 0; i < 3; i++){
			whiteSpace[i] = new JLabel();
			whiteSpace[i].setPreferredSize(new Dimension(80, 0));
		}
		blackKeyPanel.add(blackKeys[9], new Integer(1), 0);
		blackKeyPanel.add(blackKeys[8], new Integer(2), 0);
		blackKeyPanel.add(blackKeys[7], new Integer(3), 0);
		blackKeyPanel.add(whiteSpace[2], new Integer(4), 0);
		blackKeyPanel.add(blackKeys[6], new Integer(5), 0);
		blackKeyPanel.add(blackKeys[5], new Integer(6), 0);
		blackKeyPanel.add(whiteSpace[1], new Integer(7), 0);
		blackKeyPanel.add(blackKeys[4], new Integer(8), 0);
		blackKeyPanel.add(blackKeys[3], new Integer(9), 0);
		blackKeyPanel.add(blackKeys[2], new Integer(10), 0);
		blackKeyPanel.add(whiteSpace[0], new Integer(11), 0);
		blackKeyPanel.add(blackKeys[1], new Integer(12), 0);
		blackKeyPanel.add(blackKeys[0], new Integer(13), 0);

		overlayPanel.add(blackKeyPanel);
		overlayPanel.add(whiteKeyPanel);
		add(overlayPanel, BorderLayout.CENTER);
		addKeyListener(this);
	}
	
	public void keyPressed( KeyEvent event ){
		if(event.getModifiers() == 0){
			if(event.getKeyCode() == 65){ // a
				whiteKeys[0].doClick();
			}
			if(event.getKeyCode() == 83){ // s
				whiteKeys[1].doClick();
			}
			if(event.getKeyCode() == 68){ // d
				whiteKeys[2].doClick();
			}
			if(event.getKeyCode() == 70){ // f
				whiteKeys[3].doClick();
			}
			if(event.getKeyCode() == 71){ // g
				whiteKeys[4].doClick();
			}
			if(event.getKeyCode() == 72){ // h
				whiteKeys[5].doClick();
			}
			if(event.getKeyCode() == 74){ // j
				whiteKeys[6].doClick();
			}
			if(event.getKeyCode() == 87){ // w
				blackKeys[0].doClick();
			}
			if(event.getKeyCode() == 69){ // e
				blackKeys[1].doClick();
			}
			if(event.getKeyCode() == 84){ // t
				blackKeys[2].doClick();
			}
			if(event.getKeyCode() == 89){ // y
				blackKeys[3].doClick();
			}
			if(event.getKeyCode() == 85){ // u
				blackKeys[4].doClick();
			}
		}
		else if(event.getModifiers() == 1){
			if(event.getKeyCode() == 65){ // a
				whiteKeys[7].doClick();
			}
			if(event.getKeyCode() == 83){ // s
				whiteKeys[8].doClick();
			}
			if(event.getKeyCode() == 68){ // d
				whiteKeys[9].doClick();
			}
			if(event.getKeyCode() == 70){ // f
				whiteKeys[10].doClick();
			}
			if(event.getKeyCode() == 71){ // g
				whiteKeys[11].doClick();
			}
			if(event.getKeyCode() == 72){ // h
				whiteKeys[12].doClick();
			}
			if(event.getKeyCode() == 74){ // j
				whiteKeys[13].doClick();
			}
			if(event.getKeyCode() == 87){ // w
				blackKeys[5].doClick();
			}
			if(event.getKeyCode() == 69){ // e
				blackKeys[6].doClick();
			}
			if(event.getKeyCode() == 84){ // t
				blackKeys[7].doClick();
			}
			if(event.getKeyCode() == 89){ // y
				blackKeys[8].doClick();
			}
			if(event.getKeyCode() == 85){ // u
				blackKeys[9].doClick();
			}
		}
	} // end method keyPressed
   
	public void keyReleased( KeyEvent event ){
	} // end method keyReleased

   // handle press of an action key
	public void keyTyped( KeyEvent event ){
	}
} // end class MenuFrame


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

