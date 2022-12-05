package credicard;

public class MasterCard extends CreditCard{
	public MasterCard(String number) {
		super.number = number;
	}

	@Override
	public String toString() {
		return "MasterCard ["+super.number+"]";
	}
}
