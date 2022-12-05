package models;

import java.util.List;

import credicard.ProcessedCreditCard;

public class JsonOutput {

	List<ProcessedCreditCard> pcc;

	public List<ProcessedCreditCard> getPcc() {
		return pcc;
	}

	public void setPcc(List<ProcessedCreditCard> pcc) {
		this.pcc = pcc;
	}
	
	
}
