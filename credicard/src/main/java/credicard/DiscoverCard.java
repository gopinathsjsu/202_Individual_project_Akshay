package credicard;

public class DiscoverCard extends CreditCard{
	public DiscoverCard(String number) {
		super.number = number;
	}

	@Override
	public String toString() {
		return "Discover ["+super.number+"]";
	}
}
