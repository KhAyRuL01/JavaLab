package Exports;
import java.util.*;

import edu.duke.*;
import org.apache.commons.csv.*;
public class TestLabbi {
	public void listExports(CSVParser parser, String exportOfInterst) {
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportOfInterst)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public void whoExportCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExports(parser , "coffee");
    }
    
    public static void main(String[] args){
    	
    	TestLabbi object = new TestLabbi();
    	object.whoExportCoffee();
    }
}