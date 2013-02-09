/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Feb 8, 2013, 12:17:37 AM
 */

package dnimas;
import javax.swing.*;
import java.text.DecimalFormat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
/**
 *
 * @author b.mcclanahan
 */
public class logIn extends javax.swing.JFrame {
     String usernameString;
     String passwordString;
     DBConnect dataGiver = new DBConnect();
    public  static class time{
		   public static double  theTime;
		   public static String  theTimeS;
		   public static String  theTimeS2;
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

		        serverName = args;

			// Send request
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

    /** Creates new form NewJFrame */
    public logIn() {
        super("DNIMAS Study Session Log In");
        initComponents();
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

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DNIMAS Study Session Log In/Out");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("username: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("password: ");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        b2.setText("Log Out");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b1.setText("Log In");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setText("Collaborative Learning");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b2)
                    .addComponent(b1))
                .addGap(28, 28, 28)
                .addComponent(b3)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        groupCount s = new groupCount();
	s.setVisible(true);
    }//GEN-LAST:event_b3ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
               usernameString = username.getText();
	       passwordString = password.getText();

	      DBConnect connect = new DBConnect();
	      time timeInfo = getTime("64.90.182.55");
              try{
            	 passwordString = hash.sha1(passwordString);
	             String password2 = dataGiver.getDataLog(usernameString);
	             if(passwordString.equals(password2))
	             {
	            	 try{
	            	     String test = connect.logIn(usernameString, time.theTimeS2,time.theTime);
		                 if(!test.equals("fail"))
                                 {
		                	 JOptionPane.showMessageDialog(null, "You have successfully logged in at " + time.theTimeS);
                                         username.setText("");
                                         password.setText("");

                                 }
		                 else
		                	 JOptionPane.showMessageDialog(null, "You are already logged in.");

	                 }
	                 catch(Exception ext){
		                JOptionPane.showMessageDialog(null, "Unknown error" + ext);
	                 }

	             }
	             else
			        JOptionPane.showMessageDialog(null, "Your username or password is incorrect " );

                 }
              catch(Exception ex){

            	  JOptionPane.showMessageDialog(null, "Your username or password is incorrect " );
              }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        usernameString = username.getText();
        passwordString = password.getText();
	DBConnect connect = new DBConnect();
	time timeInfo = getTime("64.90.182.55");
	int action = 0;
	try{
	   String password2 = dataGiver.getDataLog(usernameString);
           passwordString = hash.sha1(passwordString);
	   if(passwordString.equals(password2))
	   {
	      try{
		  //get the day of the week
		  Calendar cl = Calendar.getInstance();

		  System.out.println(cl.getTime());
		  int dayOfWeek = cl.get(Calendar.DAY_OF_WEEK);
		  DecimalFormat myFormatter = new DecimalFormat("###.##");
		  double total = connect.logOut(usernameString,passwordString, timeInfo.theTimeS2,timeInfo.theTime,dayOfWeek);
		 
		  JOptionPane.showMessageDialog(null, "You have successfully logged out at " + time.theTimeS + "\n Time of session: "+ myFormatter.format(total) + "hrs");
				             //formatter.format(total) how to format numbers
                  username.setText("");
                  password.setText("");
	       }
	       catch(Exception ext){
	          JOptionPane.showMessageDialog(null, "You are not logged in 2 " + ext );

	       }
	    }
	    else
               JOptionPane.showMessageDialog(null, "Your username or password is incorrect");


        }
        catch(Exception ex)
	{
	   JOptionPane.showMessageDialog(null, "Your username or password is incorrect " );

	}
    }//GEN-LAST:event_b2ActionPerformed

    /**
    * @param args the command line arguments
    */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logIn().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
