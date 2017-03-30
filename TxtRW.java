package class_schedule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TxtRW 
{
	public static void main(String[] args) throws IOException
	{
	      File schedule = new File("schedule.txt");
	      File formatedSchedule = new File("formatedSchedule.txt");
	      formatedSchedule.createNewFile();
	      BufferedWriter br = new BufferedWriter(new FileWriter(formatedSchedule));
	      
	      String word = "";
	      int count = 0;
	      String[] words = new String[17];
	      Scanner sc = new Scanner(schedule);
	      boolean firstFive = true;
	      boolean firstTwo = true;
	      int totalCount = 0;

	      
	        while (sc.hasNext()) 
	        {
	        	//skip the "sec"
	        	if(count == 2 && firstTwo == true)
	        	{
	        		sc.next();
	        		firstTwo = false;
	        		continue;
	        	}
	        	
	        	//if you've reached the name of class
	        	if(count == 5)
	        	{
	        		if(firstFive)
		        	{
		        		word = "";
		        		firstFive = false;
		        	}
	        		
	        		//if you're done with the name
	        		if(sc.hasNextDouble())
	        		{
	   	        	
	        			words[count] = word;
	        			count++;
	        			firstFive = true;
	        			continue;
	        			
	        		}
		        	word = word + sc.next() + " ";
		        	continue;
	        	}
	        	
	        	if(count == 10)
	        	{
		        	word = sc.next();
		        	System.out.println("<" + word + ">");
		        	System.out.println(word.substring(word.length() - 3, word.length()));
		        	words[count] = word.substring(word.length() - 3, word.length());
		        	count++;
		        	words[count] = word.substring(0, word.length() - 3);
		        	System.out.println(word.substring(0, word.length() - 3));
		        	System.out.println(words[3]);

		        	count++;

	        	}
	        	
	        	word = sc.next();
	        	 words[count] = word;
				count++;
				
				
				if(count == 16)
				{
					for(int i = 0; i < 15; i++)
					{
						br.write(words[i] + ":");
					}
					
					br.write(words[15]);
					count = 0;
					//System.out.println(words[10] + "  " + ++totalCount);
					firstTwo = true;
					br.write("\n");
					
					
					
					
						
						
					
				}
				
				
	        		
	        }
	    
	       
	   
	    	   

	     
		
		
	      
		sc.close();
		br.close();
	      


	}
}
