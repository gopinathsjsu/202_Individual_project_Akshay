package Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import credicard.CreditCardValidate;
import credicard.ProcessedCreditCard;
import models.CreditCardJsonFormat;

public class XMLParser extends FileParser{

	@Override
	List<ProcessedCreditCard> parseFile(String fileName) {
		
		List<ProcessedCreditCard> processedCards = new ArrayList<ProcessedCreditCard>();
		try {
		File xmlFile = new File(fileName);

	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    org.w3c.dom.Document document = documentBuilder.parse(xmlFile);

	    Node rootNode = document.getDocumentElement();
	    //System.out.println(rootNode.getBaseURI());
	    NodeList list = document.getElementsByTagName("row");
	   // NodeList list = rootNode.getChildNodes();
	    List<CreditCardJsonFormat> creditCards = new ArrayList<CreditCardJsonFormat>();
	    
	    for (int i = 0; i < list.getLength(); i++) {

	        Node node = list.item(i);

	        if (node.getNodeType() == Node.ELEMENT_NODE) {

	            Element element = (Element) node;
	            
	            CreditCardJsonFormat cc = new CreditCardJsonFormat();
	           // System.out.println(element.toString());
	            cc.setCardNumber(element.getElementsByTagName("CardNumber").item(0).getTextContent());
	            cc.setExpirationDate(element.getElementsByTagName("ExpirationDate").item(0).getTextContent());
	            cc.setCardHolderName(element.getElementsByTagName("CardHolder").item(0).getTextContent());
	   
	            
	            creditCards.add(cc);
	        }
	    }
	    
	    for (CreditCardJsonFormat cc : creditCards) {
	    	ProcessedCreditCard pcc = CreditCardValidate.validate(cc.getCardNumber());
			processedCards.add(pcc);
	    }
	    
	}catch(Exception e) {}
	    return processedCards;
}
}
