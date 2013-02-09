/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 *
 * @author b.mcclanahan
 */
import java.net.InetAddress;
import java.net.NetworkInterface;


public class MAC {
	public String  theAddress;
	MAC(){
		try{
		   InetAddress ip;
		   ip = InetAddress.getLocalHost();
		   NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		   byte[] mac = network.getHardwareAddress();
		   StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			theAddress = sb.toString();
		}
		catch(Exception E){
			System.out.println("Didn't work");

		}
	}
	public  String getAddress(){
		return theAddress;
	}

}