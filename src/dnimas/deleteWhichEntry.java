/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 *
 * @author b.mcclanahan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class deleteWhichEntry extends JFrame{
	JTextArea numberArea;
	int studentEdit;
	int range;
    String file;
	String[] names;
	String[] descriptions;
	String[] passwords;
	int beginHourNum;
	int beginMinNum;
	int endHourNum;
	int endMinNum;
	descriptionConfirmation dc1;
	deleteWhichEntry(String[] descriptions2,String[] names2,String[] passwords2,int beginHourNum2, int beginMinNum2,int endHourNum2, int endMinNum2,descriptionConfirmation dc2,String fileName){

	   super("Which Entry?");
	   file = fileName;
	   dc1 = dc2;
	   beginHourNum = beginHourNum2;
	   beginMinNum = beginMinNum2;
	   endHourNum = endHourNum2;
	   endMinNum = endMinNum2;
	   JLabel number = new JLabel("Enter the number of the entry to be deleted.");
	   numberArea = new JTextArea(1,2);
	   JButton numberButton = new JButton("Submit");
	   descriptions = new String[names2.length];
	   names = new String[names2.length];
	   passwords = new String[names2.length];
	   for(int i=0;i<names2.length;i++){
		   descriptions[i] = descriptions2[i];
		   names[i] = names2[i];
		   passwords[i] = passwords2[i];
	   }

	   range = names2.length;

	   System.out.println(range);

	   numberButton.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e){
			   String holder = numberArea.getText();
			   try{
			      int x = Integer.parseInt(holder);
			      System.out.println(range);
			      if(x > 0 && x<=range )
			      {
				      x = x - 1;
				      int f = 0;
				      String[] newDesc = new String[range-1];
				      String[] newName = new String[range-1];
				      String[] passWor = new String[range-1];

				      for(int i=0;i<range-1;i++){
				    	  if(f==x)
				    	  f =f+1;
				    	  newDesc[i] = descriptions[f];
				    	  newName[i] = names[f];
				    	  passWor[i] = passwords[f];
				    	  f=f+1;
				      }
				      descriptionConfirmation dc = new descriptionConfirmation(newName,newDesc,passWor,beginHourNum,beginMinNum,endHourNum,endMinNum,file);

					  dc.setVisible(true);
					  dc1.dispose();
					  dispose();
			      }
			      else
			      {
			    	  System.out.println("You are here");
					  JOptionPane.showMessageDialog(null, "Your input is not valid please try again");
			      }



			   }
			   catch(Exception f){
				   JOptionPane.showMessageDialog(null, "Your input is not valid please try again" + f);
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


