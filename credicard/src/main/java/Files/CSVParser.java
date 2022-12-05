package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import credicard.CreditCardValidate;
import credicard.ProcessedCreditCard;

public class CSVParser extends FileParser{

	@Override
	List<ProcessedCreditCard> parseFile(String fileName) {
		String line = "";
		String splitBy = ",";
		
		List<ProcessedCreditCard> processedCards = new ArrayList<ProcessedCreditCard>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));  
			while ((line = br.readLine()) != null)  {
				String[] card = line.split(splitBy);    // use comma as separator  
				System.out.println(card[0] +  "   " + card[1] + "   " + card[2]);  
				ProcessedCreditCard pcc = CreditCardValidate.validate(card[0]);
				processedCards.add(pcc);
			}
		}catch(Exception e) {}
		
		return processedCards;
	}
}
