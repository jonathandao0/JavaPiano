// Fig. 25.5: MenuFrame.java
// Demonstrating menus.
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MenuFrame extends JFrame 
{
   private final Color[] colorValues = 
      { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };   
   private JRadioButtonMenuItem[] colorItems; // color menu items
   private JRadioButtonMenuItem[] fonts; // font menu items
   private JCheckBoxMenuItem[] styleItems; // font style menu items
   private JLabel displayJLabel; // displays sample text
   private ButtonGroup fontButtonGroup; // manages font menu items
   private ButtonGroup colorButtonGroup; // manages color menu items
   private int style; // used to create style for font
   
   private String[] labelText = {
		   	"Welcome to the fantasyland of menus",
		   	"Bienvenue a la fantasyland des menus",
		   	"Ch\u00E0o m\u1EEBng b\u1EA1n d\u1EBFn Fantasyland c\u1EE7a menu"
   			};
   private ButtonGroup sizeButtonGroup; // manages font menu items
   private JRadioButtonMenuItem[] sizeItemList; // color menu items
   private int[] sizeItems = {24, 26, 28};
   int size = sizeItems[0];
   
   // no-argument constructor set up GUI
   public MenuFrame()
   {
      super( "Using JMenus" );     

      JMenu helpMenu = new JMenu( "Help" ); // create Help menu
      helpMenu.setMnemonic( 'H' ); // set mnemonic to H

      // create English Item
      JMenuItem englishItem1 = new JMenuItem( "English..." );
      englishItem1.setMnemonic( 'E' ); // set mnemonic to E
      helpMenu.add( englishItem1 ); // add item to file menu
      englishItem1.addActionListener(

         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuFrame.this,
							                  "This is an example of using menus",
							                  "English", 
							                  JOptionPane.PLAIN_MESSAGE );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
 
      // create Francais... menu item
      JMenuItem francaisItem1 = new JMenuItem( "Fran\u00E7ais..." );
      francaisItem1.setMnemonic( 'F' ); // set mnemonic to F
      helpMenu.add( francaisItem1 ); // add item to file menu
      francaisItem1.addActionListener(

         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuFrame.this,
							                  "Ceci est un exemple d'utilisation des menus",
							                  "Fran\u00E7ais", 
							                  JOptionPane.PLAIN_MESSAGE );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      // create Vietnamese... menu item
      JMenuItem vietnameseItem1 = new JMenuItem( "Vietnamese..." );
      vietnameseItem1.setMnemonic( 'V' ); // set mnemonic to V
      helpMenu.add( vietnameseItem1 ); // add  item to file menu
      vietnameseItem1.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
               JOptionPane.showMessageDialog( MenuFrame.this,
							                  "\u0110\u00E2y l\u00E0 m\u1ED9t v\u00ED d\u1EE5 c\u1EE7a vi\u1EC7c s\u1EED d\u1EE5ng c\u00E1c menu",
							                  "vietnamese", 
							                  JOptionPane.PLAIN_MESSAGE );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
      
      JMenuBar bar = new JMenuBar(); // create menu bar
      setJMenuBar( bar ); // add menu bar to application
      bar.add( helpMenu ); // add file menu to menu bar
      
      JMenu translateMenu = new JMenu( "Translate" ); // create Translate menu
      translateMenu.setMnemonic( 'T' ); // set mnemonic to T
      
   // create English Item
      JMenuItem englishItem2 = new JMenuItem( "English..." );
      englishItem2.setMnemonic( 'E' ); // set mnemonic to E
      translateMenu.add( englishItem2 ); // add item to file menu
      englishItem2.addActionListener(

         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
            	displayJLabel.setText(labelText[0]);
            		
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
 
      // create Francais... menu item
      JMenuItem francaisItem2 = new JMenuItem( "Fran\u00E7ais..." );
      francaisItem2.setMnemonic( 'F' ); // set mnemonic to F
      translateMenu.add( francaisItem2 ); // add item to file menu
      francaisItem2.addActionListener(

         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
            	displayJLabel.setText(labelText[1]);
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      // create Vietnamese... menu item
      JMenuItem vietnameseItem2 = new JMenuItem( "Vietnamese..." );
      vietnameseItem2.setMnemonic( 'V' ); // set mnemonic to V
      translateMenu.add( vietnameseItem2 ); // add  item to file menu
      vietnameseItem2.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            public void actionPerformed( ActionEvent event )
            {
            	displayJLabel.setText(labelText[2]);
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      bar.add( translateMenu ); // add file menu to menu bar
      
      
      JMenu formatMenu = new JMenu( "Settings" ); // create Translate menu
      formatMenu.setMnemonic( 'S' ); // set mnemonic to T

      // array listing string colors
      String[] colors = { "Black", "Blue", "Red", "Green" };

      JMenu colorMenu = new JMenu( "Color" ); // create color menu
      colorMenu.setMnemonic( 'C' ); // set mnemonic to C

      // create radio button menu items for colors
      colorItems = new JRadioButtonMenuItem[ colors.length ];
      colorButtonGroup = new ButtonGroup(); // manages colors
      ItemHandler itemHandler = new ItemHandler(); // handler for colors

      // create color radio button menu items
      for ( int count = 0; count < colors.length; count++ ) 
      {
         colorItems[ count ] = 
            new JRadioButtonMenuItem( colors[ count ] ); // create item
         colorMenu.add( colorItems[ count ] ); // add item to color menu
         colorButtonGroup.add( colorItems[ count ] ); // add to group
         colorItems[ count ].addActionListener( itemHandler );
      } // end for

      colorItems[ 0 ].setSelected( true ); // select first Color item

      formatMenu.add( colorMenu ); // add color menu to format menu
      formatMenu.addSeparator(); // add separator in menu

      // array listing font names
      String[] fontNames = { "Serif", "Monospaced", "SansSerif" };
      JMenu fontMenu = new JMenu( "Font" ); // create font menu
      fontMenu.setMnemonic( 'n' ); // set mnemonic to n

      // create radio button menu items for font names
      fonts = new JRadioButtonMenuItem[ fontNames.length ];
      fontButtonGroup = new ButtonGroup(); // manages font names

      // create Font radio button menu items
      for ( int count = 0; count < fonts.length; count++ ) 
      {
         fonts[ count ] = new JRadioButtonMenuItem( fontNames[ count ] );
         fontMenu.add( fonts[ count ] ); // add font to font menu
         fontButtonGroup.add( fonts[ count ] ); // add to button group
         fonts[ count ].addActionListener( itemHandler ); // add handler
      } // end for

      fonts[ 0 ].setSelected( true ); // select first Font menu item
      fontMenu.addSeparator(); // add separator bar to font menu

      String[] styleNames = { "Bold", "Italic" }; // names of styles
      styleItems = new JCheckBoxMenuItem[ styleNames.length ];
      StyleHandler styleHandler = new StyleHandler(); // style handler

      // create style checkbox menu items
      for ( int count = 0; count < styleNames.length; count++ ) 
      {
         styleItems[ count ] = 
            new JCheckBoxMenuItem( styleNames[ count ] ); // for style
         fontMenu.add( styleItems[ count ] ); // add to font menu
         styleItems[ count ].addItemListener( styleHandler ); // handler
      } // end for

      formatMenu.add( fontMenu ); // add Font menu to Format menu
      formatMenu.addSeparator(); // add separator in menu
      
      JMenu sizeMenu = new JMenu("Font Size");
      sizeMenu.setMnemonic( 'S' ); // set mnemonic to S
      sizeItemList = new JRadioButtonMenuItem[3];
      sizeButtonGroup = new ButtonGroup();
      for(int i = 0; i < 3; i++){
    	  sizeItemList[i] = new JRadioButtonMenuItem( String.valueOf(sizeItems[i]));
    	  sizeMenu.add(sizeItemList[i]);
          sizeButtonGroup.add( sizeItemList[i] ); // add to button group
          sizeItemList[ i ].addItemListener( styleHandler ); // add handler
      }
      formatMenu.add( sizeMenu);
      bar.add( formatMenu ); // add Format menu to menu bar
      
      // set up label to display text
      displayJLabel = new JLabel(labelText[0], SwingConstants.CENTER );
      displayJLabel.setForeground( colorValues[ 0 ] );
      displayJLabel.setFont( new Font( "Serif", Font.PLAIN, size ) );
      sizeItemList[ 0 ].setSelected( true ); // select first Size menu item

      getContentPane().setBackground( Color.CYAN ); // set background
      add( displayJLabel, BorderLayout.CENTER ); // add displayJLabel
   } // end MenuFrame constructor

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener 
   {
      // process color and font selections
      public void actionPerformed( ActionEvent event )
      {
         // process color selection
         for ( int count = 0; count < colorItems.length; count++ )
         {
            if ( colorItems[ count ].isSelected() ) 
            {
               displayJLabel.setForeground( colorValues[ count ] );
               break;
            } // end if
         } // end for

         // process font selection
         for ( int count = 0; count < fonts.length; count++ )
         {
            if ( event.getSource() == fonts[ count ] ) 
            {
               displayJLabel.setFont( 
                  new Font( fonts[ count ].getText(), style, size ) );
            } // end if
         } // end for

         repaint(); // redraw application
      } // end method actionPerformed
   } // end class ItemHandler

   // inner class to handle item events from checkbox menu items
   private class StyleHandler implements ItemListener 
   {
      // process font style selections
      public void itemStateChanged( ItemEvent e )
      {
         String name = displayJLabel.getFont().getName(); // current Font
         Font font; // new font based on user selections
         
         // Set Font Size
         if(sizeItemList[0].isSelected())
        	 size = sizeItems[0];
         else if(sizeItemList[1].isSelected())
        	 size = sizeItems[1];
         else if(sizeItemList[2].isSelected())
        	 size = sizeItems[2];
        		
         // determine which CheckBoxes are checked and create Font
         if ( styleItems[ 0 ].isSelected() && 
              styleItems[ 1 ].isSelected() )
            font = new Font( name, Font.BOLD + Font.ITALIC, size );
         else if ( styleItems[ 0 ].isSelected() )
            font = new Font( name, Font.BOLD, size );
         else if ( styleItems[ 1 ].isSelected() )
            font = new Font( name, Font.ITALIC, size );
         else
            font = new Font( name, Font.PLAIN, size );

         displayJLabel.setFont( font );
         repaint(); // redraw application
      } // end method itemStateChanged
   } // end class StyleHandler
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

