package HottestTemperaturedays;

import edu.duke.*;
import org.apache.commons.csv.*;

public class HottestTemperaturedays {
	
	public static void main(String[] args) {
		HottestTemperaturedays  htd = new HottestTemperaturedays();
		htd.testHottestInDays();
	}
	
	public CSVRecord HottestHourInFile(CSVParser parser)
	{
		CSVRecord largest = null;
		for(CSVRecord current : parser)
		{
			if(largest==null)
				largest = current ;
			else
			{
				double x = Double.parseDouble(current.get("TemperatureF"));
				double y = Double.parseDouble(largest.get("TemperatureF"));
				if(x>y)
				{
					largest = current ;
				}
			}
		}
		return largest;
	}
	
	public void testHottestInDays()
	{
		FileResource fr = new FileResource();
		CSVRecord largest = HottestHourInFile(fr.getCSVParser());
		System.out.println("Hottest temperature was "+largest.get("TemperatureF")+" at " +largest.get("TimeEST"));
	}

}