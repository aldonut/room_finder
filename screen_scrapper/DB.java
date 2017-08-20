import java.sql.*;
import java.util.ArrayList;

public class DB
{

	/** 
	 * method retries data from created class obj and inserts 
	 * data into database individually
	 * @param theClass a class object which contains the class data
	 */
	public static void insert(Class theClass)
	{
		Connection myConn = null;
		try{
               myConn = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/rooms?autoReconnect=true&useSSL=false", "root", "chodo");

		Statement instertStmt = myConn.createStatement();

		String classData = "insert into data" 
					+ "(id, days, starTime, strTod, endTime, endTod," + 
					" building, room)"
					+ "values(" +
					"'" + theClass.getID()       + "'," +
					"'" + theClass.getDays()     + "'," +
					"'" + theClass.getStrTime()  + "'," +
					"'" + theClass.getStrTod()   + "'," +
					"'" + theClass.getEndtime()  + "'," +
					"'" + theClass.getEndTod()   + "'," +
					"'" + theClass.getBuilding() + "'," +
					"'" + theClass.getRoom()     + "'"  +
					 ")";
			instertStmt.executeUpdate(classData);
			myConn.close();
		}

		catch (Exception e) {System.out.println(e);}
		finally
		{ 
			 if(myConn!=null)
				try 
			 	{
					myConn.close();
			 	} 
			 	catch (SQLException e)
			 	{
					e.printStackTrace();
			 	}
		}
	}
	
	
}