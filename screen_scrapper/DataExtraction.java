package empty_rooms;

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
			Document doc = Jsoup.connect("http://www.sjsu.edu/openuniversity/docs/cies/2174_FALL_IES.htm").userAgent("Mozilla/17.0").get();
			Element table = doc.select("table.schedule-table").get(0);
	        Elements trs = table.select("tr");
	        java.util.Iterator<Element> trIter = trs.iterator();
	        boolean firstRow = true;
	        while (trIter.hasNext()) 
	        {
	 
	            Element tr = (Element)trIter.next();
	            if (firstRow) 
	            {
	                firstRow = false;
	                continue;
	            }
	            
	            Elements tds = tr.select("td");
	            java.util.Iterator<Element> tdIter = tds.iterator();
	            
	            int tdCount = 1;
	            String course = null;
	            Integer classNum = null;
	            String mode = null;
	            String title = null;
	            Double units = null;
	            String type = null;
	            String days = null;
	            String times = null;
	            String location = null;
	            String instructor = null;
	            String fee = null;
	            Integer seats = null;
	            
	            
	            // process new line
	            while (tdIter.hasNext()) {
	 
	                Element td = (Element)tdIter.next();
	                switch (tdCount++) {
	                case 1:
	                    course = td.text();
	                    break;
	                case 2:
	                    classNum = Integer.parseInt(td.text());
	                    break;
	                case 3:
	                    mode = td.text();
	                    break;
	                case 4:
	                    title = td.text();
	                    break;
	                case 5:
	                    units = Double.parseDouble(td.text());
	                    break;
	                case 6:
	                    type = td.text();
	                    break;
	                case 7:
	                    days = td.text();
	                    break;
	                case 8:
	                    times = td.text();
	                    break;
	                case 9:
	                    location = td.text();
	                    break;
	                case 10:
	                    instructor = td.text();
	                    break;
	                case 11:
	                    fee = td.text();
	                    break;
	                case 12:
	                    seats = Integer.parseInt(td.text());
	                    break;
	                    
	                }
	 
	            }
	            System.out.println(course);
	        } //table rows
	        

	       
		}
	
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

