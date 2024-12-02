import java.util.Objects;

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
	@Override
	public int compareTo(Card other) {
	    int comparison = this.rank.ordinal() - other.rank.ordinal();
	    if (comparison != 0) {
	        return comparison;
	    }
	    return this.suit.ordinal() - other.suit.ordinal();
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
        	return true;
        if (obj == null || getClass() != obj.getClass())
        	return false;
        Card card = (Card) obj;
        return rank == card.rank && suit == card.suit;
    }
	@Override
	public int hashCode() {
	    return Objects.hash(rank, suit);
	}
	    @Override
	    public String toString() {
	        return rank.toString() + suit.toString();
	    }
	}
	

