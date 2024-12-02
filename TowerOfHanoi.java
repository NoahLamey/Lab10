import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerOfHanoi {
private Map<Peg, Deque<Integer>> diskStacks = new HashMap<>();
	
	public TowerOfHanoi(int numDisks, Peg start) {
		if(numDisks <= 0) {
			throw new IllegalArgumentException();
		}
		if(start == null) {
			throw new NullPointerException();
		}
		for(Peg peg : Peg.values()) {
			diskStacks.put(peg, new ArrayDeque<>());
		}
		for(int i = numDisks; i > 0; --i) {
			diskStacks.get(start).push(i);
		}
	}
	
	public Deque<Integer> getDiskStack(Peg peg) {
		if(peg == null) {
		throw new NullPointerException();
		}
		Deque<Integer> returnStack = new ArrayDeque<>(diskStacks.get(peg));
		return returnStack;
	}
	
	public void moveDisk(Move move) {
		if(move == null) {
			throw new NullPointerException();
		}
		if(diskStacks.get(move.from).isEmpty()) {
			throw new IllegalArgumentException();
		}
		if(!diskStacks.get(move.to).isEmpty() && diskStacks.get(move.to).peek() < diskStacks.get(move.from).peek()) {
			throw new IllegalArgumentException();
		}
		Integer disk = diskStacks.get(move.from).pop();
		diskStacks.get(move.to).push(disk);
	}
	
	@Override
	public String toString() {
		Deque<Integer> leftDeque = new ArrayDeque<>();
		Deque<Integer> leftDeque2 = new ArrayDeque<>(diskStacks.get(Peg.LEFT));
		Deque<Integer> middleDeque = new ArrayDeque<>();
		Deque<Integer> middleDeque2 = new ArrayDeque<>(diskStacks.get(Peg.MIDDLE));
		Deque<Integer> rightDeque = new ArrayDeque<>();
		Deque<Integer> rightDeque2 = new ArrayDeque<>(diskStacks.get(Peg.RIGHT));
		
		while (!leftDeque2.isEmpty()){
			leftDeque.push(leftDeque2.pop());
		}
		while (!middleDeque2.isEmpty()) {
			middleDeque.push(middleDeque2.pop());
		}
		while (!rightDeque2.isEmpty()){
			rightDeque.push(rightDeque2.pop());
		}
		StringBuilder builder = new StringBuilder();
		builder.append("  LEFT: ").append(new ArrayList<>(leftDeque)).append(System.lineSeparator());
		builder.append("MIDDLE: ").append(new ArrayList<>(middleDeque)).append(System.lineSeparator());
		builder.append(" RIGHT: ").append(new ArrayList<>(rightDeque));
		return builder.toString();
	}
	
	public static List<Move> solve(int numDisks, Peg start, Peg end) {
		List<Move> solver = new ArrayList<>();
		
		if(numDisks < 0) {
			throw new IllegalArgumentException();
		}
		if(start == null || end == null) {
			throw new NullPointerException();
		}
		
		if(start == end) {
			return solver;
		}
		
		if(numDisks == 0) {
			return solver;
		}
		
		if(numDisks == 1) {
			solver.add(Move.move(start, end));
			return solver;
		}
		else {
		Peg otherPeg = Peg.other(start, end);
		solver = solve(numDisks - 1, start, otherPeg);
		List<Move> moves2 = solve(1, start, end);
		for(Move move : moves2) {
		solver.add(move);
			}
		
			moves2 = solve(numDisks - 1, otherPeg, end);
		
			for(Move move : moves2) {
				solver.add(move);
			}
		
			return solver;
			}
	}
}
