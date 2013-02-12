/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 * Class Desription - this class just gets the number of students in the group and creates a studySessionDescription class Instance
 *
 * Inputs to the constructor - none
 *
 * Class attributes:
 * JTextField numberArea - text field use to retrieve the number of students
 *
 * Class Methods: none
 *
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class groupCount extends JFrame{
	JTextField numberArea;
	groupCount(){

	   super("Number of Students?");


	   JLabel number = new JLabel("Enter the number of Students in Group.");
	   numberArea = new JTextField(2);
	   JButton numberButton = new JButton("Submit");

           //Action listenter for the number button
	   numberButton.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e){
                           //get the text from the numberArea
			   String holder = numberArea.getText();
			   try{
                              //Convert string for the number of students to into an integer
			      int x = Integer.parseInt(holder)-1;
                              //If the users input is valid then move show the studySessinoDescription class
			      if(x+1 > 0)
			      {
                                      DBConnect dataGiver = new DBConnect();
				      studySessionDescription s = new studySessionDescription(0,0,0,x,new String[0],new String[0],new String[0],0,0,0,0,new descriptionConfirmation(),new String[0],dataGiver);
				      s.setVisible(true);
				      dispose();
			      }
			      else
					  JOptionPane.showMessageDialog(null, "Your input is not valid please try again");

			   }
			   catch(Exception f){
				   JOptionPane.showMessageDialog(null, "Your input is not valid please try again");
			   }

		   }});
	   setLayout(new FlowLayout());
	   setSize(300,100);
	   add(number);
	   add(numberArea);
	   add(numberButton);
	   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   setResizable(false);
	}
}
