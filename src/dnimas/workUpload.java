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
 *
 * @author b.mcclanahan
 */
public class workUpload extends javax.swing.JFrame {
   String[] namesS;
   String[] passwordsS;
   String[] descriptionS;
   String file;
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
    public workUpload(int option2,int option22, int current, int number, String[] descriptionsS2,String[] namesS2,String[] passwordsS2,int beginHourNum2, int beginMinNum2,int endHourNum2, int endMinNum2,descriptionConfirmation dc2,String fileName) {
        super("Work Upload");
        initComponents();
        file = fileName;
        dc1 = dc2;
    	 //groupTime gt = new groupTime(descriptionS,namesS,passwordsS,new descriptionConfirmation());
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
   	JPanel p1 = new JPanel();
   	JPanel p2 = new JPanel();
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

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
	chooser.showOpenDialog(null);
	f = chooser.getSelectedFile();
	workLink.setText(f.getPath());
    }//GEN-LAST:event_browseActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        // TODO add your handling code here:
        try{
	   ftp.connect(connection.ipFTP,connection.portFTP);
	   boolean test = ftp.login(connection.usernameFTP, connection.passwordFTP);
	   if(test)
	   {
	      System.out.println("Connected");
	   }
	   else
	      System.out.println("failed");
	   ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	   in = new FileInputStream(f.getPath());
	   test = ftp.storeFile(f.getName(), in);
           if(test)
	   {
	      System.out.println("Uploaded");
	   }
	   else
	      System.out.println("failed");
	   in.close();
	   file = f.getName();
	   if(option12 == 0 ){
	      groupTime gt = new groupTime(descriptionS,namesS,passwordsS,new descriptionConfirmation(),f.getName());
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

    private void skipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipActionPerformed
        // TODO add your handling code here:
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

    /**
    * @param args the command line arguments
    */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new workUpload().setVisible(true);
            }
        });
    }*/

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
