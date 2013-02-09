/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnimas;

/**
 *
 * @author b.mcclanahan
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
		     con = DriverManager.getConnection("jdbc:mysql://169.254.194.145:3306/DNIMAS","root","Summer09");
		     st = con.createStatement();
		  }
		  catch(Exception ex){
			  JOptionPane.showMessageDialog(null,"A connection with the database could not be established: " + ex);
		    // System.out.println("A connection with the database could not be established " + ex);
		  }
		}

		/*public void getData(){
		   try{
		      String query = "SELECT * FROM student";
		      rs = st.executeQuery(query);
		      // System.out.println("data:");
		      while(rs.next()){
		         String stuffs = rs.getString("courseTeacherEmail");
		         // System.out.println(stuffs);
		      }
		   }
		   catch(Exception ex){
		      System.out.println("Nahhh");
		   }


		}*/

		public String getDataLog(String username) throws SQLException{
			String query = "SELECT * FROM users WHERE user_name = \'" + username+ "\'" ;
			//System.out.println(query);
			rs = st.executeQuery(query);
			// System.out.println("data:");
			rs.next();
			String stuffs = rs.getString("user_pass");
			while(rs.next())
			    stuffs = rs.getString("user_pass");
			return stuffs;

		}

		public String logIn(String userID,  String  time,Double time2) throws SQLException{
			  String whatHappened;

			  String query = "SELECT * FROM users WHERE user_name = \'" + userID +"\'";
			  rs = st.executeQuery(query);
			  rs.next();
			  int id = rs.getInt("user_id");
			  int status = rs.getInt("user_status");
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


			  return whatHappened;
		}
		public double logOut(String userID,String password, String  time,Double time2,int dayOfWeek) throws SQLException {
			  String query = "SELECT * FROM users WHERE user_name = \'" + userID + "\'";
			  rs = st.executeQuery(query);
			  rs.next();
			  int status = rs.getInt("user_status");
			  int id = rs.getInt("user_id");
			  String startString = rs.getString("user_date");
			  startString = startString.substring(0,19);
			  System.out.println(startString);
			  if(status == 1)
			  {
			     query = "SELECT * FROM posts WHERE post_by =" + id + " AND post_date = \'" + startString +"\'";
			     System.out.println(query);
			     rs = st.executeQuery(query);
			     rs.next();
			     Double startDouble = rs.getDouble("post_startDouble");
			     Double duration = Math.floor(time2 - startDouble);
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

			     return 1;
			  }



		}

		//Makes topic submission and corresponding date submissions
		public void topicSubmission(String[] names2, String[] descriptions2,String[] passwords2,int beginHourNum2,int beginMinNum2,int endHourNum2, int endMinNum2,String date)throws SQLException{

			//Make the topic submission

			//Get the week from the categories table
			String query = "SELECT * FROM categories WHERE cat_id = 1";
			System.out.println(query);
			rs = st.executeQuery(query);
			rs.next();
			Calendar cl = Calendar.getInstance();
    	                int weekNum = cl.get(Calendar.DAY_OF_WEEK);
			int duration = (endHourNum2*3600+endMinNum2*60) - (beginHourNum2*3600+endMinNum2*60);

			String startTime = String.format("%02d",beginHourNum2)+":"+String.format("%02d",beginMinNum2) ;
			String endTime = String.format("%02d",endHourNum2) + ":" + String.format("%02d",endMinNum2);

			//make string for content
			String content = "";
			for(int i=0;i<descriptions2.length;i++)
			     content = content + descriptions2[i] + "\n";
			MAC addressGetter = new MAC();
			query = "INSERT INTO topics(sub_date,sub_week,sub_startTime,sub_duration,sub_endTime,sub_content,sub_cat) VALUES(\'"+date+"\',"+weekNum+",\'"+startTime+"\'," +duration+",\'"+endTime+"\',\'"+content+"\',1)";//,\'"+addressGetter.getAddress()+"\')";
			st.executeUpdate(query);
			query = "SELECT * FROM topics WHERE sub_date = \'" + date + "\'";
			rs = st.executeQuery(query);
			rs.next();
			//submission ID
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
       //Check to see if a user is logged in before allowing them to make a group submission
	   public int checkLogIn(String username)throws SQLException{

		   String query = "SELECT * FROM users WHERE user_name = \'" + username + "\'";
		   rs = st.executeQuery(query);
		   rs.next();
		   int stat = rs.getInt("user_status");
		   return stat;
	   }



}

