package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import credicard.CreditCardValidate;
import credicard.ProcessedCreditCard;
import models.CreditCardJsonFormat;
import models.JsonInput;


public class JSONParser extends FileParser {

	@Override
	List<ProcessedCreditCard> parseFile(String fileName) {
		
		List<ProcessedCreditCard> processedCards = new ArrayList<ProcessedCreditCard>();
		
		try {
			String line = "";
			ObjectMapper mapper = new ObjectMapper();
			BufferedReader br = new BufferedReader(new FileReader(fileName));  
			String jsonString = "";
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				jsonString+=line + "\n";
			}
			jsonString = "{\r\n"
					+ "  \"cclist\" :"+jsonString+"}";
			System.out.println(jsonString);
			JsonInput cards = mapper.readValue(jsonString, JsonInput.class);
			System.out.println(cards);
			for(CreditCardJsonFormat cc: cards.getCclist()) {
				System.out.println(cc.getCardNumber());
				ProcessedCreditCard pcc = CreditCardValidate.validate(cc.getCardNumber());
				processedCards.add(pcc);
			}
			
			
			
		}catch(Exception e) {}
		
		return processedCards;
	}

	
}
