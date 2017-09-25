package exportdata;

import edu.duke.*;
import org.apache.commons.csv.*;
public class ExportData {
	public void tester()
	{
		FileResource file = new FileResource();
		CSVParser parser = file.getCSVParser();
		String string = countryInf(parser,"Germany");
		System.out.println(string);
		parser = file.getCSVParser();
		listExportersTwoProducts(parser,"gold","diamond");
		parser = file.getCSVParser();
		System.out.println(numberOfExporters(parser,"gold"));
	}
	public String countryInf(CSVParser parser,String country)
	{
		String string = "NOT FOUND";
		for(CSVRecord current : parser)
		{
			if(country.equals(current.get("Country")))
			{
						string = country + ": " + current.get("Exports") + ": " + current.get("Value (dollars)");		
			}
		}
		return string;
	}
	public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
	{
		String string = null;
		for(CSVRecord current : parser)
		{
			string = current.get("Exports") ;
			if(string.indexOf(exportItem1)!=-1 && string.indexOf(exportItem2)!=-1)
			{
				System.out.println(current.get("Country"));
			}
		}
	}
	public int numberOfExporters(CSVParser parser,String exportItem)
	{
		int count = 0;
		for(CSVRecord current : parser)
		{
			String string = current.get("Exports") ;
			if(string.indexOf(exportItem)!=-1)
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		ExportData data = new ExportData();
		data.tester();
	}
}
