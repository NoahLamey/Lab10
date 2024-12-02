enum Peg {
	
LEFT, MIDDLE, RIGHT;
	
	public static Peg other(Peg p1, Peg p2) {
		if(p1 == null || p2 == null) {
			throw new NullPointerException("Pegs cannot be null");
		}
		if(p1 == p2) {
			throw new IllegalArgumentException("Pegs cannot be equal");
		}
		for(Peg peg : Peg.values()) {
			if(peg != p1 && peg != p2) {
				return peg;
			}
		}throw new IllegalArgumentException("Invalid pegs provided");
	}
}
