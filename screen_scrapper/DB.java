

import java.sql.*;
import java.util.ArrayList;

public class DB
{

	public static void insert(Class theClass)
	{

		Connection myConn = null;
		try{

               myConn = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/rooms?autoReconnect=true&useSSL=false", "root", "chodo");

		Statement instertStmt = myConn.createStatement();

		String event = "insert into data" 
					+ "(days, starTime, strTod, endTime, endTod," + 
					" building, room)"
					+ "values(" + 
					"'" + theClass.getDays() + "'," +
					"'" + theClass.getStrTime() + "'," +
					"'" + theClass.getStrTod() + "'," +
					"'" + theClass.getEndtime() + "'," +
					"'" + theClass.getEndTod() + "'," +
					"'" + theClass.getBuilding() + "'," +
					"'" + theClass.getRoom() + "'" +
					 ")";
			
		System.out.println("room added");

			instertStmt.executeUpdate(event);
			myConn.close();

		}

		catch (Exception e) {System.out.println(e);}
		finally{
			 /*This block should be added to your code
			  * You need to release the resources like connections
			  */
			 if(myConn!=null)
				try {
					myConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	
}
}
