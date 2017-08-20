import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class DataExtraction 
{
	public static void main(String[] args)
	{ 
		int i = 0;
		
		try
		{
			Document doc = Jsoup.connect("http://www.sjsu.edu/openuniversity/docs/cies/2174_FALL_IES.htm").maxBodySize(0).timeout(7000).userAgent("Mozilla/17.0").get(); //connection
			               
			Element table = doc.select("table.schedule-table").get(0); //selecting table
	        Elements rows = table.select("tr"); //selecting all rows
	        java.util.Iterator<Element> rowIter = rows.iterator(); //making an iterator for rows 
            rowIter.next();
            int topCount = 0; //after 10 elements, skip the useless row

            
	        while(rowIter.hasNext())
	        {
	        		if(topCount == 10)
	        		{
		        		topCount = 0;
	                    rowIter.next();
	        		    continue;
	        		}
	        	
	            Element row = (Element)rowIter.next();  //get the first row
	            
	            
	            Elements cols = row.select("td"); //getting each col of row
	            java.util.Iterator<Element> colIter = cols.iterator(); 
	            	
	            
	            
	            	colIter.next(); //skip name
	            	i++; //let exception know you are done.
  	
	            	String classID = colIter.next().text();
	            	
	          
	            	for(i = 0; i < 4; i++)
	            	{
	            		colIter.next();
	            	}
	            
	            	
	            			            
	            String days = colIter.next().text();
	            String times = colIter.next().text();
	            String location = colIter.next().text();
	            
	            	 if(!location.equals("OFFCAMPUS") 
	 	            		&& !location.equals("ONLINE") && !location.equals("") 
	 	            		&& times.length() != 0 && !times.equals("-")
	 	            		&& days.length() != 0)
	            	 {
	            		 Class theClass = new Class(classID, days,times,location);
	            		 DB.insert(theClass);
	            		 System.out.println("\ndays:*"  +
			                	 days + "*\ntimes:*"  +  times + "*\nlocation:*" + location + "*"
			                	 + "\n" + colIter.next().text() + "\n"); 
	            	 }
	            
	            topCount++; //keeps count on elements until "back to top" is reached.
	           
	 
	        }
		}
	
		catch(NoSuchElementException e)
		{
			if(i == 1)
			   System.out.println("done");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
