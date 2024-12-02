
public enum Suit {
	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");
	private String symbol;
	Suit(String symbol){
		this.symbol = symbol;
	}
	@Override
	public String toString() {
		return symbol;
	}
}
