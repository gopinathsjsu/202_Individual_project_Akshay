package Files;

import java.util.List;

import credicard.ProcessedCreditCard;

public  class InputFile {

	FileParser parser;
	
	public void addFile(FileParser parser) {
		this.parser = parser;
	}
	
	public List<ProcessedCreditCard> processFile(String fileName) {
		List<ProcessedCreditCard> pcc =  parser.parseFile(fileName);
		return pcc;
	}
	
	public void writeOutput(List<ProcessedCreditCard> cards, String oFile) {
		parser.writeOutput(cards, oFile);
	}
}
