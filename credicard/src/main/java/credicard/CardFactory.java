package credicard;


public class CardFactory {
	public CreditCard getCard(int cardType, String aCard) {
		CreditCard card = null;
		switch(cardType) {
			case 0:
				card = new VisaCard(aCard);
				break;
			case 1:
				card = new MasterCard(aCard);
				break;
			case 2:
				card = new AmexCard(aCard);
				break;
			case 3: 
				card = new DiscoverCard(aCard);
				break;
			default:
				break;
		}
		return card;
	}
}
