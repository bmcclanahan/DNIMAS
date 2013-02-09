/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 *
 * @author b.mcclanahan
 */







public class studySession {
	/*public  static class time{
		   public double  theTime;
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

		}*/

   public static void main(String[] arg){
    logIn li = new logIn();
	li.setVisible(true);

	/*DBConnect connect = new DBConnect();
	connect.getData();
	time timeInfo = getTime("64.90.182.55");

	
	try
	{
	  // time timeInfo = getTime("64.90.182.55");
	 //  System.out.println(time.theTimeS);

	}
	catch(IOException e)
	{
	//   System.out.println("Shit don't work");
	}
	*/



   }

}

