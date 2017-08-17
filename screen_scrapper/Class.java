
public class Class 
{
	private String  days;
	private String  strTime;
	private String  strTod;
	private String  endTime;
	private String  endTod;
	private String  building = "";
	private String  room;
	
	public Class(String days, String time, String location)
	{
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
			curr = location.charAt(++charCount);
		}
		
		room = location.substring(charCount);
				
	}
	
}

