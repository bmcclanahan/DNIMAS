/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 *
 * class description - Holds port numbers, ip addresses, user names, and user passwords to make connections to both the MySQL server and FTP server.
 * the names of the variables are self explanatory
 */
public class connection {
   public static String ipMySql = "localhost";
   public static String portMySql = "3306";
   public static String ipFTP = "169.254.194.145";
   public static int portFTP = 21;
   public static String dataBase = "DNIMAS";
   public static String usernameMySql = "root";
   public static String passwordMySql = "clanin21";
   public static String usernameFTP = "bmcclanahan";
   public static String passwordFTP = "clanin22";
}
