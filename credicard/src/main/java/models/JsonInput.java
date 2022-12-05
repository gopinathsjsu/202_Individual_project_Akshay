package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonInput {

	@JsonProperty("cclist")
	private List<CreditCardJsonFormat> cclist;

	public List<CreditCardJsonFormat> getCclist() {
		return cclist;
	}

	public void setCclist(List<CreditCardJsonFormat> cclist) {
		this.cclist = cclist;
	}

	@Override
	public String toString() {
		return "JsonInput [cclist=" + cclist + "]";
	}
	
}
