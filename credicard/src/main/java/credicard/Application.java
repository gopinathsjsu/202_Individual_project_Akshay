package credicard;

import java.util.List;
import java.util.Scanner;

import Files.CSVParser;
import Files.InputFile;
import Files.JSONParser;
import Files.XMLParser;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputFile file = new InputFile();
		
		Scanner sc= new Scanner(System.in); 
		
		System.out.println("Input file");
		
		String iFile = sc.nextLine();
		
		System.out.println("Output file Name:");
		
		String oFile = sc.nextLine();
		
		if(iFile.endsWith("csv")) {
			file.addFile(new CSVParser());
		}
		else if(iFile.endsWith("json")) {
			file.addFile(new JSONParser());
		}
		else if(iFile.endsWith("xml")) {
			file.addFile(new XMLParser());
		}
		List<ProcessedCreditCard> cards = file.processFile(iFile);
		file.writeOutput(cards,oFile);
		
	}


}
