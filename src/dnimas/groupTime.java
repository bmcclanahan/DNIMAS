/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class groupTime extends JFrame{

	JTextField beginHour = new JTextField(2);
	JTextField beginMins = new JTextField(2);
	JTextField endHour = new JTextField(2);
	JTextField endMins = new JTextField(2);
	String[] pass;
	String[] descrip;
	String[] names;
	String file;
	int beginHourNum;
	int beginMinNum;
	int endHourNum;
	int endMinNum;
	descriptionConfirmation dc;
	groupTime(String[] descriptions2,String[] names2,String[] passwords2,descriptionConfirmation dc2,String fileName){

	   super("Time of Session");
	   file = fileName;
	   dc = dc2;
	   names = new String[names2.length];
	   descrip = new String[descriptions2.length];
	   pass = new String[passwords2.length];
	   for(int i=0;i<names2.length;i++)
	   {
		   names[i] = names2[i];
		   descrip[i] = descriptions2[i];
		   pass[i] = passwords2[i];
	   }
	   JPanel p1 = new JPanel();
	   JPanel p2 = new JPanel();
	   JPanel p3 = new JPanel();
	   JLabel big = new JLabel("Enter the time of the session");
	   JLabel colon = new JLabel(":");
	   JLabel colon2 = new JLabel(":");
	   JLabel begin = new JLabel("Begin time");
	   JLabel end = new JLabel("End time");
	   JButton submit = new JButton("submit");
	   submit.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e){

		   try{
			   beginHourNum = Integer.parseInt(beginHour.getText());
			   beginMinNum = Integer.parseInt(beginMins.getText());
			   endHourNum = Integer.parseInt(endHour.getText());
			   endMinNum = Integer.parseInt(endMins.getText());
			   if(beginHourNum>endHourNum)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else if(beginHourNum == endHourNum && beginMinNum>endMinNum)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else if(endHourNum<1 || beginHourNum <1)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else if(endHourNum>12 || beginHourNum>12)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else if(endMinNum<0 ||beginMinNum<0)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else if(endMinNum>59||beginMinNum>59)
				   JOptionPane.showMessageDialog(null, "Your input is invalid");
			   else
			   {
				   descriptionConfirmation dc1 = new descriptionConfirmation(names,descrip,pass,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
				   dc1.setVisible(true);
				   dc.dispose();
				   dispose();
			   }

		   }catch(Exception ex){
			   JOptionPane.showMessageDialog(null, "Your input is invalid");
		   }



		   }});


	   p1.add(big);
	   p2.add(begin);
	   p2.add(beginHour);
	   p2.add(colon);
	   p2.add(beginMins);
	   p2.add(Box.createRigidArea(new Dimension(10,0)));
	   p2.add(end);
	   p2.add(endHour);
	   p2.add(colon2);
	   p2.add(endMins);
	   p3.add(submit);
	   add(p1, BorderLayout.NORTH);
	   add(p2, BorderLayout.CENTER);
	   add(p3, BorderLayout.SOUTH);
	   setSize(500,150);

	   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   setResizable(false);

   }
}
