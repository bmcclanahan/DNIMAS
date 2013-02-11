

package dnimas;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 * Class description: This class allows students of a group to enter a description
 * of work done while in the group. The class also takes information gathered for the
 * group submission and passes it to the next JFrame to be shown
 *
 * Inputs to constructor:
 * int option2 - Indicates whether or not this class instance was created in an editWhichStudent class instance or a groupTime class instance
 *
 * int option22 - Indicates whether or not the instance of this class was created in an instance of the descriptionConfirmation class
 *
 * int current - Indicates the index of the user currently using the instance of this class to submit
 *               his or her information
 * int number - The total number of students in the group
 *
 * String[] descriptionsS2 - array of descriptions submitted by each group member
 *
 * String[] namesS2 - array of the usernames of the group members
 *
 * String[] passwords - array of the passwords of the group members
 *
 * int beginHourNum2, beginMinNum2, endHourNum2, endMinNum2 - beginning and ending hour and minute of group submission
 *
 * descriptionConfirmation dc2 - Instance of the descriptionConfirmation class currently displayed. Used to destroy the current instance when information
 *                               needs to be updated
 *
 * String[] fileName - array of filenames for the work which has been uploaded by the group
 *
 * DBConnect dataGiver - Instance of DBConnect class. Used to access the database
 *
 * Class Attributes: All attributes are set by an argument of the constructor. The attributes are defines by the values that are used to set them.
 * So refer to the description of the inputs to understand the how the attribute is used.
 *
 * String[] namesS - namesS2
 * String[] passwordsS - passwordsS2
 * String[] descriptionS - descriptionsS2
 * String[] file - fileName
 * int currentStudent - current
 * int numberOfStudens -  number
 * int option - option2
 * int option12 - option22
 * int beginHourNum - beginHoutNum2
 * int beginMinNum - beginMinNum2
 * int endHourNum - endHourNum2
 * int endMinNum - endMinNum2
 * descriptionConfirmation dc1 - dc2
 * DBConnect dataGiver - dataGiv
 *
 * Methods:
 * SubmitActionPerformed  - Evoked when the submit button is pressed
 *    Inputs: the ActionEvent
 * SkipActionPerformed - Evoked when the skip button is pressed
 *    Inputs: the ActionEvent


 */
public class studySessionDescription extends javax.swing.JFrame {
    //Class attributes
    String[] namesS;
    String[] passwordsS;
    String[] descriptionS;
    String[] file;
    int currentStudent;
    int numberOfStudents;
    int option;
    int option12;
    int beginHourNum;
    int beginMinNum;
    int endHourNum;
    int endMinNum;
    descriptionConfirmation dc1;
    DBConnect dataGiver;
    public studySessionDescription(int option2,int option22, int current, int number, String[] descriptionsS2,String[] namesS2,String[] passwordsS2,int beginHourNum2, int beginMinNum2,int endHourNum2, int endMinNum2,descriptionConfirmation dc2,String[] fileName,DBConnect dataGiv) {
        super("Study Session Description");
        //Place JFrame Components
        initComponents();
        //Set class attributes
        file = fileName;
	dc1 = dc2;
	beginHourNum = beginHourNum2;
	beginMinNum = beginMinNum2;
	endHourNum = endHourNum2;
	endMinNum = endMinNum2;
	option = option2;
	option12 = option22;
	currentStudent = current;
	numberOfStudents = number;
        dataGiver = dataGiv; 
	description.setLineWrap(true);
	description.setWrapStyleWord(true);
	int limit;
        
	if(option != 0)
	{
	   descriptionS = new String[number];
           namesS = new String[number];
           passwordsS = new String[number];
	   limit =  number;
	}
	else
	{
	   descriptionS = new String[current+1];
	   namesS = new String[current + 1];
           passwordsS = new String[current +1];
	   limit = current;

	}
	for(int i =0;i<limit;i++)
	{
	   descriptionS[i] = descriptionsS2[i];
	   namesS[i] = namesS2[i];
	   passwordsS[i] = passwordsS2[i];
	}

        //add list of students successfully logged in
        String[] fullName;
        String studentsString = "";
        //Get full name of all the users who have added a description from database
        //And add the names to the loggedInStudents textArea 
        try{
           fullName = dataGiver.getFullName(namesS2);
           for(int i=0;i<fullName.length;i++){
              studentsString = studentsString + fullName[i] + "\n";
           }
           loggedInStudents.setText(studentsString);
           loggedInStudents.setEditable(false);
        }catch(Exception E){
           JOptionPane.showMessageDialog(null, "Could not fetch full name from database" + E);
        }

        //Set default close operation and make JFrame not resizable
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 	setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        names = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        skip = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        passwords = new javax.swing.JPasswordField();
        jScrollPane3 = new javax.swing.JScrollPane();
        loggedInStudents = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Study Session Description");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        scrollPane1.add(jScrollPane1);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        skip.setText("Skip");
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel4.setText("*click red 'x' at top right corner to cancel");

        loggedInStudents.setColumns(20);
        loggedInStudents.setRows(5);
        jScrollPane3.setViewportView(loggedInStudents);

        jLabel5.setText("Students Successfully Logged In");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(names, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(passwords)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(skip, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(names, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(skip))
                .addGap(19, 19, 19)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action Listener for the submit button
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
         //Prompt the user to verify that they wish to submit the description. n will contain 0 is yes and 1 if no
         int n = JOptionPane.showConfirmDialog(this,"Are you sure you want to submit","Confirmation",JOptionPane.YES_NO_OPTION);
         //If the user varifies the submission enter the following if statement
         if(n==0){
                   //get username and password from text box
                   String tempUserName = names.getText();
	           String tempPassword = passwords.getText();
		   String comparePassword;

                   //variable used to check for redundand entry
	           int checkRedundant = 0;
	           
		   try{
                            //check for redundant entry
			     for(int i=0;i<currentStudent;i++)
			     {
			    	 //If there is a name already in the list which matches this entry set checkRedundant to 1
			    	 if(namesS[i].equals(names.getText()) && option12 != 1)
			    	 checkRedundant = 1;
			     }
                             //get the sha1 hash of the password entered by the user  and compare to the password
                             //stored for that uer in the database. The password is retreived using the student's username.
			     tempPassword = hash.sha1(tempPassword);
			     comparePassword = dataGiver.getDataLog(tempUserName);

                             //variblabe used to indicate whether or not the user is logged in
			     int loggedIn = dataGiver.checkLogIn(tempUserName);

                             //If the user is logged in, the uername and password is correct, and the entry is not redundant
                             //then enter the following if statement
			     if(tempPassword.equals(comparePassword) && checkRedundant == 0 && loggedIn == 1)
			     {
                                 //If the instance of this class was created in an instance of groupTime or descriptionConfirmation student enter the
                                 //following conditional 
			         if(option == 0)
			         {
                                    //Update the namesS, passwordsS, and descriptionsS variables with the information given by the current student
				    namesS[currentStudent] = names.getText();
				    passwordsS[currentStudent] = passwords.getText();
				    descriptionS[currentStudent] = description.getText();

                                    //If the index of the current student is less than the number of students then create another instance of studySessionDescription
                                    //for the next student in the group to add their description
			            if(currentStudent < numberOfStudents)
			            {
			               studySessionDescription s = new studySessionDescription(0,0,currentStudent+1,numberOfStudents,descriptionS,namesS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,new descriptionConfirmation(),file,dataGiver);
		                       s.setVisible(true);
		                       dispose();
		  	            }
                                    //If the index of the current student is equal to the number of students then enter the following conditional
			            else
			            {
                                       //If this class was not created by a descriptionConfirmation class instance then show a workUpload JFrame.
			    	       if(option12 == 0)
			     	       {

			    	          workUpload wu = new workUpload(0,0,currentStudent+1,numberOfStudents,descriptionS,namesS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,new descriptionConfirmation(),file);
			    	          wu.setVisible(true);
					  dispose();
			    	       }
                                       
                                       //If this class instance was created in a descriptionConfirmation class instance then
                                       //show the descriptionConfirmation JFrame
			               else
			    	       {
				           descriptionConfirmation dc = new descriptionConfirmation(namesS,descriptionS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
				           dc.setVisible(true);
				           dispose();
				           dc1.dispose();
			    	        }

			             }
			          }
                                 //If this class was instance was created in the editWhichStudent class instance then update the
                                 //records for that student and show the descriptionConfirmation JFrame 
			          else
			          {
				      namesS[option-1] = names.getText();
				      passwordsS[option-1] = passwords.getText();
				      descriptionS[option-1] = description.getText();
		  	              descriptionConfirmation dc = new descriptionConfirmation(namesS,descriptionS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
			              dc.setVisible(true);
				      dispose();
				      dc1.dispose();
			          }
			   }
                           //Checks to see if a user is logged in, if username and password are incorrect, and to see if there a redundant
                           //entry
			   else{
				   if(!tempPassword.equals(comparePassword))
				      JOptionPane.showMessageDialog(null, "Your username or password is incorrect");
				   //else  if(loggedIn == 0)
					 // JOptionPane.showMessageDialog(null, "You are not logged in");
				   else if(loggedIn == 1)
					  JOptionPane.showMessageDialog(null, "There is already an entry for this user");
				   else
					  JOptionPane.showMessageDialog(null, "You are not logged in");
			   }
                   //If an excption is thrown then a username could not be received for the username provided 
		   }catch(Exception E){


			   JOptionPane.showMessageDialog(null, "Your username or password is incorrect" + E);

		   }
        }
    }//GEN-LAST:event_submitActionPerformed


    //Action listener for the skip button
    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
         //Verify that the user wants to wishes to skip this entry
         int n = JOptionPane.showConfirmDialog(this,"Are you sure you want to submit","Confirmation",JOptionPane.YES_NO_OPTION);
         if(n==0){

             //If the index of the current student is less than the index of the number of students then show the studySessionDescriptionFrame
             if(currentStudent < numberOfStudents){
                studySessionDescription s = new studySessionDescription(0,0,currentStudent,numberOfStudents-1,descriptionS,namesS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,new descriptionConfirmation(),file,dataGiver);
                s.setVisible(true);
                dispose();
	     }
             //If the index of the current student is equal to the number of students then enter the following conditional
             else
	     {
                //If this class instance was not created by a descriptionConfirmation class instance then show the workUpload JFrame
		if(option12 == 0)
	     	{
		   workUpload wu = new workUpload(0,0,currentStudent+1,numberOfStudents,descriptionS,namesS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,new descriptionConfirmation(),file);
		   wu.setVisible(true);
	           dispose();
	    	}
                //If this class instance was created by a instance of the descriptionConfirmation JFrame then show the descriptionConfirmation JFrame 
	        else
	    	{
                   //Create arguments to pass to descriptionConfirmation class instance
		   String[] descrip = new String[numberOfStudents];
		   String[] names = new String[numberOfStudents];
		   String[] pass = new String[numberOfStudents];

		   for(int i=0;i<numberOfStudents;i++){
		      descrip[i] = descriptionS[i];
		      names[i] = namesS[i];
		      pass[i] = passwordsS[i];
		   }
		   descriptionConfirmation dc = new descriptionConfirmation(names,descrip,pass,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
		   dc.setVisible(true);
		   dispose();
		   dc1.dispose();
	    	}
	     }

         }
    }//GEN-LAST:event_skipActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studySessionDescription().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea loggedInStudents;
    private javax.swing.JTextField names;
    private javax.swing.JPasswordField passwords;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton skip;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

}
