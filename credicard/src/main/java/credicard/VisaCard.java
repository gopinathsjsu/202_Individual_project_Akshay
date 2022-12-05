package credicard;

public class VisaCard extends CreditCard{

	public VisaCard(String number) {
		super.number = number;
	}

	@Override
	public String toString() {
		return "VisaCard ["+super.number+"]";
	}
}
