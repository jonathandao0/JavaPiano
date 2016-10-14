// Fig. 25.6: MenuTest.java
// Testing MenuFrame.
import javax.swing.JFrame;
import javafx.application.Application;
import javafx.stage.Stage;

public class VirtualPianoApp extends Application
{
	public void start( Stage stage ){ 
		VirtualPianoFrame frame = new VirtualPianoFrame(); // create MenuFrame 
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 1440, 400 ); // set frame size
		frame.setVisible( true ); // display frame
	} // end main
} // end class MenuTest


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

