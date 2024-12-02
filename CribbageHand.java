import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CribbageHand {
	public static final Map<Rank, Integer> CARD_VALUES = Collections.unmodifiableMap(Map.ofEntries(
			Map.entry(Rank.ACE, 1),
            Map.entry(Rank.TWO, 2),
            Map.entry(Rank.THREE, 3),
            Map.entry(Rank.FOUR, 4),
            Map.entry(Rank.FIVE, 5),
            Map.entry(Rank.SIX, 6),
            Map.entry(Rank.SEVEN, 7),
            Map.entry(Rank.EIGHT, 8),
            Map.entry(Rank.NINE, 9),
            Map.entry(Rank.TEN, 10),
            Map.entry(Rank.JACK, 10),
            Map.entry(Rank.QUEEN, 10),
            Map.entry(Rank.KING, 10)));
	public final List<Card> cards;
	
	public CribbageHand(Card c1, Card c2, Card c3, Card c4) {
		if(c1 == null || c2 == null || c3 == null || c4 == null) {
			throw new NullPointerException("Cards cannot be null");
		}
		this.cards = Collections.unmodifiableList(List.of(c1,c2,c3,c4));
	}
	public static Set<Set<Card>> powerSet(List<Card> cards){
		if(cards.isEmpty()) {
			Set<Set<Card>> base = new HashSet<>();
			base.add(new HashSet<>());
			return base;
		}
		Card first = cards.get(0);
		List<Card> rest = cards.subList(1, cards.size());
		Set<Set<Card>> powNoFirst = powerSet(rest);
		Set<Set<Card>> pow = new HashSet<>(powNoFirst);
		for(Set<Card> sub : powNoFirst) {
			Set<Card> nSub = new HashSet<>(sub);
			nSub.add(first);
			pow.add(nSub);
		}
		return pow;
	}
	public Set<Set<Card>> fifteens(Card starter){
		List<Card> all = new ArrayList<>(this.cards);
        all.add(starter);
        Set<Set<Card>> subsets = powerSet(all);
        return subsets.stream()
        .filter(subset -> subset.stream()
        .mapToInt(card -> CARD_VALUES.get(card.getRank()))
        .sum() == 15)
         .collect(Collectors.toSet());
	}
}

