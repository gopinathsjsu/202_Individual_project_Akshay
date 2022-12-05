package credicard;

public class AmexCard extends CreditCard{
	public AmexCard(String number) {
		super.number = number;
	}

	@Override
	public String toString() {
		return "Amex ["+super.number+"]";
	}
}
