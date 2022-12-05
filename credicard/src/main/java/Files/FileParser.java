package Files;

import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import credicard.CardDetails;
import credicard.ProcessedCreditCard;
import models.JsonOutput;

public abstract class FileParser {
	
	abstract List<ProcessedCreditCard> parseFile(String fileName); 
	public void writeOutput(List<ProcessedCreditCard> cards, String outputFileName) {
		try {
			File fout = new File(outputFileName);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		   
			if(outputFileName.endsWith(".xml")) {
				//p.changeParser(new XMLParser());
				 ByteArrayOutputStream baos = new ByteArrayOutputStream();
				    XMLEncoder xmlEncoder = new XMLEncoder(baos);
				    xmlEncoder.writeObject(cards);
				    xmlEncoder.close();

				    String xml = baos.toString();
				    System.out.println(xml);

				    bw.write(xml);
			}
			else if(outputFileName.endsWith(".json")) {
				ObjectMapper mapper = new ObjectMapper();
				JsonOutput jo; 
		        try {
		        	jo = new JsonOutput();
		        	jo.setPcc(cards);
		        	//id.setCclist(inCreditList);
		            mapper.writeValue(new File(outputFileName), jo);
		            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jo.getPcc());
		            
		            //System.out.println(jsonString);
		            bw.write(jsonString);
		            //id = mapper.readValue(jsonString, InputDetails.class);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
			else if(outputFileName.endsWith(".csv")) {
				for (ProcessedCreditCard cd: cards) {
					bw.write(cd.getCardNumber() + ',' + cd.getCardType() + ',' + cd.getIsValid() + ',' + cd.getError());
					bw.newLine();
				}
			}
			
		    
			bw.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}
}
