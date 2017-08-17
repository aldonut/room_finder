

import java.io.IOException;
import java.util.List;

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
		
		try
		{
			Document doc = Jsoup.connect("http://www.sjsu.edu/openuniversity/docs/cies/2174_FALL_IES.htm").userAgent("Mozilla/17.0").get(); //connection
			Element table = doc.select("table.schedule-table").get(0); //selecting table
	        Elements rows = table.select("tr"); //selecting all rows
	        java.util.Iterator<Element> rowIter = rows.iterator(); //making an iterator for rows 
            rowIter.next();
            int topCount = 0;
            int colCount = 0;

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
	            	
	            for(int i = 0; i < 6; i++)
	            {
	            	colIter.next();
	            }

	            	String days = colIter.next().text();
	            	String times = colIter.next().text();
	            	String location = colIter.next().text();
	            	 System.out.println("\ndays: "  +
		                	 days + "\ntimes: "  +  times + "\nlocation: " + location); 
		       
	            	 //check that location is useful else don't create obj
	            
	            topCount++;
	           
	 
	        }
	                  
		}
	
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

