package credicard;

public class ProcessedCreditCard {
	private String cardNumber;
	private String cardType;
	private boolean isValid;
	public String getCardNumber() { 
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		return "ProcessedCreditCard [cardNumber=" + cardNumber + ", cardType=" + cardType + ", isValid=" + isValid
				+ "]";
	}
	
}
