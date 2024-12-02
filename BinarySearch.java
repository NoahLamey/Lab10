import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
			String target, int fromIdx, int toIdx) {
		 List<Integer> indicesChecked = new ArrayList<>();
		while (fromIdx <= toIdx) {
            int midIdx = (fromIdx + toIdx) / 2;
            indicesChecked.add(midIdx);

            if (strings.get(midIdx).equals(target)) {
                return indicesChecked;
            } else if (strings.get(midIdx).compareTo(target) < 0) {
                fromIdx = midIdx + 1;
            } else {
                toIdx = midIdx - 1;
            }
        }

        indicesChecked.add(-1);
        return indicesChecked;
 
	}
}
