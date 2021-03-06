/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * descriptionConfirmation.java
 *
 * Created on Feb 8, 2013, 2:50:06 AM
 */

package dnimas;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Timestamp;
/**
 * Class Description - This class provides an interface and access to other classes which allow students to change session time
 * add student to group submission, delete a student from the group submission, edit a student submission, upload more work, and
 * submit the group submission
 *
 *
 * Arguments of the constructor -
 * String[] descriptions2 - array of descriptions submitted by each group member
 *
 * String[] names2 - array of the usernames of the group members
 *
 * String[] passwords2 - array of the passwords of the group members
 *
 * int beginHourNum2, beginMinNum2, endHourNum2, endMinNum2 - beginning and ending hour and minute of group submission
 *
 * String[] fileName - array of filenames for the work which has been uploaded by the group
 *
 * Class Attributes: Most attributes are set by arguments from the constructor. The attributes that are set from arguments of the constructor can be defined by the values that are used to set them.
 * So refer to the description of the constructor inputs to understand the how the attribute is used.
 *
 * String[] names - namesS2
 * String[] passwords - passwordsS2
 * String[] descriptions - descriptionsS2
 * String[] file - fileName
 * int beginHourNum - beginHoutNum2
 * int beginMinNum - beginMinNum2
 * int endHourNum - endHourNum2
 * int endMinNum - endMinNum2
 * descriptionConfirmation dc - a handle to the instance of this class
 *
 *
 * Methods:
 *    editTimeActionPerformed - action listener for the editTime button
 *       Inputs - the ActionEvent
 *    uploadWorkActionActionPerformed - action listener for the uploadWork button
 *       Inputs - the ActionEvent
 *    submitActionPerformed - action listener for the submit button
 *       Inputs - the ActionEvent
 *    editEntryActionPerformed - action listener for the editEntry button
 *       Inputs - the ActionEvent
 *    addEntryActionPerformed - action listener for the addEntry button
 *       Inputs - the ActionEvent
 *    deleteEntryActionPerformed - action listener for the deleteEntry button
 *       Inputs - the ActionEvent
 * 
 * Inner Classes:
 *   time - class used to store the the current time
 *   getTime - class used to retrieve the current time
 */
public class descriptionConfirmation extends javax.swing.JFrame {
    String[] names;
    String[] descriptions;
    String[] passwords;
    String[] file;
    int beginHourNum;
    int beginMinNum;
    int endHourNum;
    int endMinNum;;
    descriptionConfirmation dc;
    descriptionConfirmation(){

    }
    public  static class time{
       public static double  theTime;
       public static String  theTimeS;
       public  String  theTimeS2;
       time()
       {
          theTime = -1;
	  theTimeS = "-1";
       }
       time(double t,String s,String s2)
       {
          theTime = t;
	  theTimeS = s;
	  theTimeS2 = s2;
	}
    }

    public static time getTime(String args)
    {

       try{
          String serverName;
	  serverName = args;		// Send request
	  DatagramSocket socket = new DatagramSocket();
	  InetAddress address = InetAddress.getByName(serverName);
	  byte[] buf = new NtpMessage().toByteArray();
	  DatagramPacket packet =
	  new DatagramPacket(buf, buf.length, address, 123);
			// Set the transmit timestamp *just* before sending the packet
			// ToDo: Does this actually improve performance or not?
	NtpMessage.encodeTimestamp(packet.getData(), 40,
	(System.currentTimeMillis()/1000.0) + 2208988800.0);
	 socket.send(packet);
			// Get response
	packet = new DatagramPacket(buf, buf.length);
	socket.receive(packet);
			// Process response
	NtpMessage msg = new NtpMessage(packet.getData());
	socket.close();
	time info = new time(msg.originateTimestamp,msg.toString(),msg.toString2());
	return  info;
	}
	catch(Exception e){
           JOptionPane.showMessageDialog(null, "Could not connect to ntp server");
           return new time();
	}

    }
    /** Creates new form descriptionConfirmation */
    public descriptionConfirmation(String[] names2, String[] descriptions2,String[] passwords2,int beginHourNum2,int beginMinNum2,int endHourNum2, int endMinNum2,String[] fileName) {
        super("Description Confirmation");
        initComponents();
        //Set the class attributes
        file = fileName;
	beginHourNum = beginHourNum2;
	beginMinNum = beginMinNum2;
	endHourNum = endHourNum2;
	endMinNum = endMinNum2;
	dc = this;
	String theString = "";
        names = new String[names2.length];
	descriptions = new String[names2.length];
	passwords = new String[names2.length];

        //Display usernames, passwords, descriptions, group time and work uploaded in the text area
	for(int i =0; i<names.length; i++){
	   names[i] = names2[i];
	   descriptions[i] = descriptions2[i];
	   passwords[i] = passwords2[i];

           theString = theString +  "Username "+ (i+1) +":" +names[i] + "\n\n";

	   theString = theString + "Description "+ (i+1) +":" + descriptions[i] + "\n\n\n";

        }

	theString = theString + "From: "+ String.format("%02d",beginHourNum) + ":" + String.format("%02d",beginMinNum) +"  To: " + String.format("%02d",endHourNum) +":" + String.format("%02d",endMinNum) + "\n\n";

        theString = theString + "Work Uploaded: \n" ;
        for(int i = 0;i<file.length;i++)
        {
           theString = theString + file[i] +"\n";
        }
	theTextArea.setText(theString); 
	theTextArea.setEditable(false);
	theTextArea.setLineWrap(true);
	theTextArea.setWrapStyleWord(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        theTextArea = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        uploadWork = new javax.swing.JButton();
        deleteEntry = new javax.swing.JButton();
        editEntry = new javax.swing.JButton();
        addEntry = new javax.swing.JButton();
        editTime = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        theTextArea.setColumns(20);
        theTextArea.setRows(5);
        jScrollPane1.setViewportView(theTextArea);

        scrollPane1.add(jScrollPane1);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        uploadWork.setText("Upload More Work");
        uploadWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadWorkActionPerformed(evt);
            }
        });

        deleteEntry.setText("Delete Entry");
        deleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryActionPerformed(evt);
            }
        });

        editEntry.setText("Edit Entry");
        editEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryActionPerformed(evt);
            }
        });

        addEntry.setText("Add Entry");
        addEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryActionPerformed(evt);
            }
        });

        editTime.setText("Edit Time");
        editTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTimeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel1.setText("*click red 'x' in the top right corner to canel ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editTime, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deleteEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(uploadWork, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(editEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uploadWork)
                        .addGap(18, 18, 18)
                        .addComponent(deleteEntry))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editTime)
                        .addGap(18, 18, 18)
                        .addComponent(addEntry)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(editEntry))
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action listener for the editTime button. Shows the groupTime JFrame
    private void editTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTimeActionPerformed
        // TODO add your handling code here:
        groupTime gt = new groupTime(descriptions,names,passwords, dc,file);
	gt.setVisible(true);
    }//GEN-LAST:event_editTimeActionPerformed

    //Action listener for the uploadWork button. Shows the workUpload JFrame
    private void uploadWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadWorkActionPerformed
        // TODO add your handling code here:
        workUpload wu = new workUpload(0,2,names.length,0 ,descriptions,names,passwords,beginHourNum,beginMinNum,endHourNum,endMinNum,dc,file);
        wu.setVisible(true);
    }//GEN-LAST:event_uploadWorkActionPerformed

    //Action listener for the submit button. Makes an entry into the topics table of the database for the group submission
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        //Ask user to confirm that they wish to make the submission
        int n = JOptionPane.showConfirmDialog(this,"Are you sure you want to submit","Confirmation",JOptionPane.YES_NO_OPTION);
        //If the user confirms that he or she wishes to make the submission enter the following conditional
        if(n==0){
           //Get the current time
           time timeInfo = getTime("64.90.182.55");
           //Make class instance of DBConnect to communicate with the database
	   DBConnect submitGroup = new DBConnect();
           
           try{
                 //make the group submission and dispose of this instance of the description confirmation page
                 submitGroup.topicSubmission(names, descriptions, passwords, beginHourNum, beginMinNum, endHourNum, endMinNum, timeInfo.theTimeS2);
                 JOptionPane.showMessageDialog(null, "The submission was successful");
                 dispose();
	   }catch(Exception E){
	      JOptionPane.showMessageDialog(null, "Error" + E);
           }
        }
    }//GEN-LAST:event_submitActionPerformed

    //Action listener for the addEntry button. Shows the studySessionDescription JFrame
    private void addEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryActionPerformed
        // TODO add your handling code here:
        DBConnect dataGiver = new DBConnect();
        studySessionDescription s = new studySessionDescription(0,2,names.length,names.length,descriptions,names,passwords,beginHourNum,beginMinNum,endHourNum,endMinNum,dc,file,dataGiver);
	s.setVisible(true);
    }//GEN-LAST:event_addEntryActionPerformed

    //Action listener for the editEntry button. Shows the editWhichStudent JFrame
    private void editEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryActionPerformed
        // TODO add your handling code here:
        editWhichStudent ews = new editWhichStudent(descriptions,names,passwords,beginHourNum,beginMinNum,endHourNum,endMinNum,dc,file);
	ews.setVisible(true);
    }//GEN-LAST:event_editEntryActionPerformed

    //Action listener for the deleteEntry button. Shows the deleteWhichEntry JFrame
    private void deleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryActionPerformed
        // TODO add your handling code here:
        deleteWhichEntry ews = new deleteWhichEntry(descriptions,names,passwords,beginHourNum,beginMinNum,endHourNum,endMinNum,dc,file);
	ews.setVisible(true);
    }//GEN-LAST:event_deleteEntryActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new descriptionConfirmation().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntry;
    private javax.swing.JButton deleteEntry;
    private javax.swing.JButton editEntry;
    private javax.swing.JButton editTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton submit;
    private javax.swing.JTextArea theTextArea;
    private javax.swing.JButton uploadWork;
    // End of variables declaration//GEN-END:variables

}
