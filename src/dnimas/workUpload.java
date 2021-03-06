/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * workUpload.java
 *
 * Created on Feb 8, 2013, 2:12:53 AM
 */

package dnimas;
import java.io.FileInputStream;
import java.io.File;
import org.apache.commons.net.ftp.FTPClient;
import javax.swing.*;
 
/**
 * Class description: This class allows students to upload work to an FTP server
 *
 * Arguments of the constructor:
 * int option2 - A JFrame reference which is not does not effect operations performed in this class
 *
 * int option22 - A JFrame reference which is used to determine what JFrame should be shown after this one
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
 * Class Attributes: Most attributes are set by arguments from the constructor. The attributes that are set from arguments of the constructor can be defined by the values that are used to set them.
 * So refer to the description of the constructor inputs to understand the how the attribute is used.
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
 * FileInputStream in- Input stream for the file to be uploaded
 * FTPClient ftp- class instance used to connect to the FTP server and upload work
 * File f - class instance to hold data for the file selected to be uploded
 * 
 * Methods:
 * SubmitActionPerformed  - Evoked when the submit button is pressed
 *    Inputs: the ActionEvent
 * SkipActionPerformed - Evoked when the skip button is pressed
 *    Inputs: the ActionEvent
 * UploadActionPerformed  - Evoked when the upload button is pressed
 *    Inputs: the ActionEvent
 *
 * BrowseActionPerformed - Evoked then the browse button is pressed
 *    Inputs: the ActionEvent
 */
public class workUpload extends javax.swing.JFrame {
   //Class attributes used to hold data for group submission
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
   FileInputStream in = null;
   FTPClient ftp = new FTPClient();
   File f;
    /** Creates new form workUpload */
    public workUpload(int option2,int option22, int current, int number, String[] descriptionsS2,String[] namesS2,String[] passwordsS2,int beginHourNum2, int beginMinNum2,int endHourNum2, int endMinNum2,descriptionConfirmation dc2,String[] fileName) {
        super("Work Upload");
        //code created by netbeans for interface
        initComponents();
        //get data from the study session description JFrames
        file = new String[fileName.length+1];
        dc1 = dc2;
    	option = option2;
    	option12 = option22;
    	beginHourNum = beginHourNum2;
   	beginMinNum = beginMinNum2;
   	endHourNum = endHourNum2;
   	endMinNum = endMinNum2;
   	option = option2;
   	option12 = option22;
   	currentStudent = current;
   	numberOfStudents = number;
   	workLink.setEditable(false); 
	System.out.println(current);
        descriptionS = new String[current];
	namesS = new String[current];
	passwordsS = new String[current];

	for(int i =0;i<current;i++)
	{
           descriptionS[i] = descriptionsS2[i];
	   namesS[i] = namesS2[i];
	   passwordsS[i] = passwordsS2[i];
	}
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        workLink = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        skip = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select file to upload:");

        browse.setText("Choose File");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        upload.setText("Upload");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        skip.setText("Skip");
        skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel2.setText("*click red 'x' in the top right corner to cancel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(browse, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(workLink, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(upload, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skip, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browse))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upload)
                    .addComponent(skip))
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //action listener for browse button. Simply allows user to select file
    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed

        JFileChooser chooser = new JFileChooser();
	chooser.showOpenDialog(null);
	f = chooser.getSelectedFile();
	workLink.setText(f.getPath());
    }//GEN-LAST:event_browseActionPerformed

    //action listener for upload. Makes connection, authenticates, and uploads file
    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        // TODO add your handling code here:
        try{
           //make connection
	   ftp.connect(connection.ipFTP,connection.portFTP);
           //login to FTP server
	   boolean test = ftp.login(connection.usernameFTP, connection.passwordFTP);
           //Test to see if login is successful
	   if(test)
	   {
	      System.out.println("Connected");
	   }
	   else
	      System.out.println("failed");
           //Set the file type to be uploaded
	   ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
           //get input stream for the file and use that input stream to upload the file
	   in = new FileInputStream(f.getPath());
	   test = ftp.storeFile(f.getName(), in);
           //test to see if the upload was successful
           if(test)
	   {
	      System.out.println("Uploaded");
	   }
	   else
	      System.out.println("failed");
           //close the input
	   in.close();
           //Get the filename of the file uploaded
	   file[file.length-1] = f.getName();
           //If the the current instance of workupload was created in the studySessionDescription class, then option12 = 0 and the groupTime class should be called next.
           //Else go to descriptionConfirmation JFrame
	   if(option12 == 0 ){
	      groupTime gt = new groupTime(descriptionS,namesS,passwordsS,new descriptionConfirmation(),file);
              gt.setVisible(true);
              dispose();
	   }
	   else{
	      descriptionConfirmation dc = new descriptionConfirmation(namesS,descriptionS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
	      dc.setVisible(true);
	      dispose();
	      dc1.dispose();
	   }
	}catch(Exception E){
	   JOptionPane.showMessageDialog(null, "Error" + E);
	}
    }//GEN-LAST:event_uploadActionPerformed
    //action listener for the skip button. Just skips over the workupload JFrame. 
    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        //If option12 equals zero then show the groupTime JFrame. Otherwise show the descriptionConfirmation JFrame 
        if(option12 == 0 ){
	   groupTime gt = new groupTime(descriptionS,namesS,passwordsS,new descriptionConfirmation(),file);
           gt.setVisible(true);
           dispose();
	}
	else{
           descriptionConfirmation dc = new descriptionConfirmation(namesS,descriptionS,passwordsS,beginHourNum,beginMinNum,endHourNum,endMinNum,file);
	   dc.setVisible(true);
	   dispose();
	   dc1.dispose(); 
	}
    }//GEN-LAST:event_skipActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton skip;
    private javax.swing.JButton upload;
    private javax.swing.JTextField workLink;
    // End of variables declaration//GEN-END:variables

}
