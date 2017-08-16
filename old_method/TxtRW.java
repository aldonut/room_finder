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
	      
	      String element = "";
	      int count = 0;
	      String[] words = new String[17];
	      Scanner sc = new Scanner(schedule);
	      
	      //first time count reaches 2
	      boolean firstFive = true;
	      
	      //first time count reaches 5
	      boolean firstTwo = true;
	      

	      
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
		        		element = "";
		        		firstFive = false;
		        	}
	        		
	        		//if you're done with the name
	        		if(sc.hasNextDouble())
	        		{
	   	        	
	        			words[count] = element;
	        			count++;
	        			firstFive = true;
	        			continue;	
	        		}
	        		
		        	element = element + sc.next() + " ";
		        	continue;
	        	}
	        	
	        	//if you've reached the building and room number 
	        	if(count == 10)
	        	{
		        	element = sc.next();
		        
		        	//retrieves room number
		        	words[count] = element.substring(element.length() - 3, element.length());
		        	count++;
		        	
		        	//retrieves building name
		        	words[count] = element.substring(0, element.length() - 3);
		        	count++;
	        	}
	        	
	        	element = sc.next();
	        	words[count] = element;
				count++;
				
				//all columns finished, start new row.
				if(count == 16)
				{
					for(int i = 0; i < 15; i++)
					{
						br.write(words[i] + "|");
					}
					
					br.write(words[15]);
					count = 0;
					firstTwo = true;
					br.write("\n");
				}  		
	        }     
		sc.close();
		br.close();
	}
}
