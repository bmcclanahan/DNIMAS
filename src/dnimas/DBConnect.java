/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**

 * Class Description: This class is used for to make all queries and updates to the database
 *
 * Input to constructor: none
 *
 * Methods:
 *
 * String getDataLog - returns the password of a user
 *    Inputs:
 *       String username - username of the user
 *
 * String logIn - Logs a user in by updating the users log in status in the data base and returns a string
 * indicating whether or not the log in was successful
 *    Inputs:
 *       String userID - the user's username
 *       String time  - string representation of the time at which the user is logging in
 *       Double time2 - time stamp for when the user is logging in
 *
 * Double logOut - Logs a user out by updating the user's log in status in the database and returns a double
 * indicating the amount of time the user was logged in
 *    Inputs:
 *       String userID - the user's username
 *       String time  - string representation of the time at which the user is logging in
 *       Double time2 - time stamp for when the user is logging in
 *       int dayOfWeek - an integer representing the day of the week
 * 
 * void topicSubmission - makes a topic entry in the database for a group of students 
 *    Inputs: 
 *       names2: usernames
 *       descriptions2: user descriptions
 *       passwords2: user passwords 
 *       int beginHourNum2, beginMinNum2, endHourNum2, endMinNum2 - beginning and ending hour and minute of group submission
 *       String date: String representation of the date the the topic submission is being made 
 *
 * int checkLogIn - checks to see if a user is logged in. Returns 1 if the user is logged in and 0 otherwise
 *    Inputs:
 *       userName - username of the user
 *
 * String[] getFullName - returns the full names associated usernames
 *    Inputs
 *       userNames[] - usernames for which the full names are to be retrieved 
 */

import java.sql.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Calendar;

public class DBConnect {

	   private Connection con;
	   private Statement st;
	   private ResultSet rs;

	    DBConnect(){
	      try{
		     Class.forName("com.mysql.jdbc.Driver");
		     con = DriverManager.getConnection("jdbc:mysql://"+connection.ipMySql +":"+connection.portMySql+"/"+connection.dataBase,connection.usernameMySql,connection.passwordMySql);
		     st = con.createStatement();
		  }
		  catch(Exception ex){
			  JOptionPane.showMessageDialog(null,"A connection with the database could not be established: " + ex);
		    // System.out.println("A connection with the database could not be established " + ex);
		  }
		}

		
                //get password given username
		public String getDataLog(String username) throws SQLException{
			String query = "SELECT * FROM users WHERE user_name = \'" + username+ "\'" ;
			rs = st.executeQuery(query);
			rs.next();
			String stuffs = rs.getString("user_pass");
			while(rs.next())
			    stuffs = rs.getString("user_pass");
			return stuffs;

		}

                //log student in
		public String logIn(String userID,  String  time,Double time2) throws SQLException{
			  String whatHappened;
                          //get the users ID and log in status from the database
			  String query = "SELECT * FROM users WHERE user_name = \'" + userID +"\'";
			  rs = st.executeQuery(query);
			  rs.next();
			  int id = rs.getInt("user_id");
			  int status = rs.getInt("user_status");
                          //Checks the time frame at which the user is attempting to log in
                          //Get the hour and minutes from the timestamp in the database and convert them
                          //to integers
                          String[] timeCheckEnd = time.substring(11,16).split(":");
                          Integer hour = Integer.parseInt(timeCheckEnd[0]);
                          Integer minute = Integer.parseInt(timeCheckEnd[1]);
                          Integer second;
                          int checkTime = hour*60+minute;
                          //Check to see if the user is trying to log in after seven.
                          //Calculation is done as follows hour*60 + minute = second in the day.
                          //Note that hour is a hour in military time
                          if(checkTime <= 30000)//1140
                          {
                             //If the user is not already logged in then change the user_status feild in the users table to 1
                             // and create an entry for the user in the posts table 
			     if(status != 1){
				 query = "UPDATE users SET user_date = \'" + time + "\' WHERE user_name = \'" + userID +" \' ";
				 st.executeUpdate(query);
				 query = "UPDATE users SET user_status = 1 WHERE user_name = \'" + userID + "\'";
				 st.executeUpdate(query);
			         query = "INSERT INTO posts(post_date,post_startTime,post_startDouble,post_by) VALUES( +\'" +time +"\',\'" + time+ "\',"+time2+","+id+")";
			         st.executeUpdate(query);
			         whatHappened = "success";
			     }
			     else
			     {
				  whatHappened = "fail";
		  	     }
                        }
                        //If it is after seven o clock then tell the student that it is to late and return fail2
                        else
                        {
                              JOptionPane.showMessageDialog(null, "Nahhh...It's to late.");
                              whatHappened = "fail2"; 
                        }

			  return whatHappened;
		}
		public double logOut(String userID, String  time,Double time2,int dayOfWeek) throws SQLException {
			  //get the users ID, log in, and the date at which the user logged in from the database
                          String query = "SELECT * FROM users WHERE user_name = \'" + userID + "\'";
			  rs = st.executeQuery(query);
			  rs.next();
			  int status = rs.getInt("user_status");
			  int id = rs.getInt("user_id");
			  String startString = rs.getString("user_date");
                          //Checks the time frame at which the user is attempting to log in
                          //Get the hour and minutes from the timestamp in the database and convert them
                          //to integers
                          String[] timeCheckEnd = time.substring(11,16).split(":");
                          Integer hour = Integer.parseInt(timeCheckEnd[0]);
                          Integer minute = Integer.parseInt(timeCheckEnd[1]);
                          Integer second;
                          int checkTime = hour*60+minute;
                          //Check to see if the user is trying to log out before eight.
                          //Calculation is done as follows hour*60 + minute = second in the day.
                          //Note that hour is a hour in military time
                          if(checkTime>-1)//1199
                          {
                             startString = startString.substring(0, 19);
			     System.out.println(startString);
                             //If the user is indeed log in then update the post entry to indicate how long the student was at study session.
                             //Also update the users_status column in the user table to 0, indicating the user is logged out
			     if(status == 1)
			     {
			        query = "SELECT * FROM posts WHERE post_by =" + id + " AND post_date = \'" + startString +"\'";
			        System.out.println(query);
			        rs = st.executeQuery(query);
			        rs.next();
                                String[] beginTime = startString.substring(11,19).split(":");
                                hour = Integer.parseInt(beginTime[0]);
                                minute = Integer.parseInt(beginTime[1]);
                                second = Integer.parseInt(beginTime[2]);
                                checkTime = hour*60+minute;
                                Double duration;
                                //If the user logs in after 6:10 the duration is equal to 3600 second else it is equal to 7200
                                if(checkTime<=30000)//1090
                                    duration = 3600.0*2.0;
                                else
                                    duration = 3600.0;
			        DecimalFormat twoDForm = new DecimalFormat("#.##");
                                System.out.println("what is the duration " + duration);
			        query = "UPDATE posts SET post_endTime = \'" + time + "\' WHERE post_by =" + id + " AND post_date = \'" + startString +"\'";
			        st.executeUpdate(query);
			        query = "UPDATE posts SET post_duration =" + twoDForm.format(duration/3600)+ " WHERE post_by =" + id + " AND post_date =\'" + startString +"\'";
			        System.out.println(query);
			        st.executeUpdate(query);
			        query = "UPDATE users SET user_status = 0 WHERE user_name = \'" + userID + "\'";
                                st.executeUpdate(query);
                                return duration/3600;
			     }
			     else{
				JOptionPane.showMessageDialog(null, "You are not logged in " );
			        return -1;
			     }
                       }
                       else
                       {
                          JOptionPane.showMessageDialog(null, "Nahhh...It's not 8:00pm yet." );
                          return -1;
                       }

		}

		//Makes topic submission(entry in the topics table for the group submission )
		public void topicSubmission(String[] names2, String[] descriptions2,String[] passwords2,int beginHourNum2,int beginMinNum2,int endHourNum2, int endMinNum2,String date)throws SQLException{

			//Get the day of the week
			Calendar cl = Calendar.getInstance();
    	                int weekNum = cl.get(Calendar.DAY_OF_WEEK);
			int duration = (endHourNum2*3600+endMinNum2*60) - (beginHourNum2*3600+endMinNum2*60);
			String startTime = String.format("%02d",beginHourNum2)+":"+String.format("%02d",beginMinNum2) ;
			String endTime = String.format("%02d",endHourNum2) + ":" + String.format("%02d",endMinNum2);
			//make string for descriptions from each student to enter into the sub_content column of topics
			String content = "";
			for(int i=0;i<descriptions2.length;i++)
			     content = content + descriptions2[i] + "\n";
                        //get MAC address to enter into the sub_by field in topics
			MAC addressGetter = new MAC();
			String query = "INSERT INTO topics(sub_date,sub_week,sub_startTime,sub_duration,sub_endTime,sub_content,sub_cat) VALUES(\'"+date+"\',"+weekNum+",\'"+startTime+"\'," +duration+",\'"+endTime+"\',\'"+content+"\',1)";//,\'"+addressGetter.getAddress()+"\')";
			st.executeUpdate(query);
			query = "SELECT * FROM topics WHERE sub_date = \'" + date + "\'";
			rs = st.executeQuery(query);
			rs.next();
			//associate topic entries with post entries by using value for the sub_id entry in the post_sub column for each user.
			int subID = rs.getInt("sub_id");
			int id;
			String date2;
			for(int i=0;i<names2.length;i++){
				query = "SELECT * FROM users WHERE user_name = \'" + names2[i] + "\'";
				rs = st.executeQuery(query);
				rs.next();
                                id = rs.getInt("user_id");
                                date2 = rs.getString("user_date");
                                query = "UPDATE posts SET post_content = \'" + descriptions2[i] + "\',post_sub = " + subID +" WHERE post_by =" + id + " AND post_date = \'" + date2.substring(0,19) + "\'" ;
                                st.executeUpdate(query);
			}


		}
           //Checks to see if a user is logged in
	   public int checkLogIn(String username)throws SQLException{

		   String query = "SELECT * FROM users WHERE user_name = \'" + username + "\'";
		   rs = st.executeQuery(query);
		   rs.next();
		   int stat = rs.getInt("user_status");
		   return stat;
	   }

           //Returns the full names of users given usernames 
           public String[] getFullName(String[] userNames)throws SQLException{

                  String query;
                  String[] fullNames = new String[userNames.length];
                  for(int i=0;i<userNames.length;i++){
                     query = "SELECT * FROM users WHERE user_name = \'" + userNames[i] + "\'";
                     rs = st.executeQuery(query);
		     rs.next();
                     fullNames[i] = rs.getString("user_fullname");
                  }
                  return fullNames;
           }


}

