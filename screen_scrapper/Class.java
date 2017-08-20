public class Class 
{
	private String  days;
	private String  strTime;
	private String  strTod;
	private String  endTime;
	private String  endTod;
	private String  building = "";
	private String  room;
	private String  classID;
	
	public Class(String classID,String days, String time, String location)
	{
		this.classID = classID;
		this.days = days;
		timeExtractor(time);
		locationExtractor(location);
	}
	
	public void timeExtractor(String time)
	{
		strTime = time.substring(0, 5);
		strTod  = time.substring(5, 7);
		endTime = time.substring(8, 13);
		endTod  = time.substring(13);
	}
	
	public void locationExtractor(String location)
	{
		int charCount = 0;
		char curr = location.charAt(charCount);
		
		while(Character.isLetter(curr))
		{
			building += curr;
			try
			{
			if(charCount == location.length() - 1)
				return;
				
			curr = location.charAt(++charCount);
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println("error: " + location);
			}
		}
		
		room = location.substring(charCount);
				
	}
	
	public void setDays(String days)
	{
		this.days = days;
	}
	
	public String getDays()
	{
		return days;
	}
	
	public void setStrTime(String time)
	{
		strTime = time;
	}
	
	public String getStrTime()
	{
		return strTime;
	}
	
	public void setStrTod(String time)
	{
		strTod = time;
	}
	
	public String getStrTod()
	{
		return strTod;
	}
	
	public void setEndtime(String time)
	{
		endTime = time;
	}
	
	public String getEndtime()
	{
		return endTime;
	}
	
	public void setEndTod(String time)
	{
		endTod = time;
	}
	
	public String getEndTod()
	{
		return endTod;
	}
	
	public void setBuilding(String bldg)
	{
		building = bldg;
	}
	
	public String getBuilding()
	{
		return building; 
	}
	
	public void setRoom(String room)
	{
		this.room = room;
	}
	
	public String getRoom()
	{
		return room;
	}
	
	public void setID(String id)
	{
		classID = id;

	}
	
	public String getID()
	{
		return classID;
	}
	
	
	
}
