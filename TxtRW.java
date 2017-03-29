package class_schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TxtRW 
{
	public static void main(String[] args) throws IOException
	{
	      File schedule = new File("test.txt");
	      
	    //  FileReader fr = new FileReader(schedule);
	      //BufferedReader br = new BufferedReader(fr);
	      
	      String word = "";
	      int count = 0;
	      String[] words = new String[20];
	      Scanner sc = new Scanner(schedule);
	      boolean first = true;

	        while (sc.hasNext()) 
	        {
	      
	        	
	        	if(count == 6)
	        	{
	        		if(first)
		        	{
		        		word = "";
		        		first = false;
		        	}
	        		
	        		if(sc.hasNextDouble())
	        		{
	   	        	
	        			words[count] = word;
	        			count++;
	        			continue;
	        			
	        		}
		        	word = word + sc.next() + " ";
		        	continue;

	        	}
	        	
	        	word = sc.next();
	        	 words[count] = word;
				System.out.println(word);
				count++;
	            
	        }
	     // while((line = br.readLine()) != null)
	   
	    	   

	     
		
		for(String current: words)
		{
			System.out.println(current + "/");
		}
	      
	     // br.close();
	     // fr.close();
		sc.close();
	      


	}
}
