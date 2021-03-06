package de.hska.iwi.ads.solution.search;


import de.hska.iwi.ads.search.Search;

/**
 * Searches a sorted array for a given value. 
 * The entire array can be searched or only a given range.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class BinarySearch<E extends Comparable<E>> implements Search<E>{

	/**
	 * Implementation of binary search which finds the index of 
	 * an {@link Comparable} element in a list of {@link Comparable} elements. <p> 
	 * If the element can't be found the method returns the 
	 * position where it should be added to keep the array sorted.
	 * 
	 * @param a an array with elements of type {@link Comparable}
	 * @param key of type {@link Comparable}
	 * @param left of type {@link Integer}
	 * @param right of type {@link Integer}
	 * @return <ul><li><code>index</code> of the element if found;
	 * 			<li><code>i=left{@literal -}1</code> if <code>key {@literal <} a[left] </code>
	 * 			<li><code>i=right{@literal +}1</code> if <code>a[right] {@literal <} key </code>
	 * 			</ul>
	 */
	@Override
	public int search(E [] a, E key, int left, int right) {
		
		int index = -42;
		int middle = (left + right) / 2;
		
		// If array is empty throw exception
		if (a.length == 0) { 
			throw new IllegalArgumentException("Array shouldn't be empty");
		} else if (left > right) {
			// Task doesn't state if swapping is a valid fix for IllegalArgument
			int temp = left;
			left = right;
			right = temp;
		}
		
		// Checks if a potential index is on the left or right border
		if (isEqual(key, a[left])) {
			index = left;
		} else if (isEqual(key, a[right])) {
			index = right;
		}
		
		// Checks if left is at the same index as right and the key is less than that element
		if (left-right == 0) {
			if (isLessThan(key, a[left])) {
				return left-1;
			}
		}
		

		if (isLessThan(key,a[left])) { // key < a[left]
			if(((left-1) >= 0 && (isLessThan(a[left-1], key))) || // a[left-1] < key
					(left-1) >= 0 && (isLessThan(key,a[left]) && isLessThan(a[left-1],key))) // a[left-1] < key < a[left] 
				return left;
			
			return (left-1);
		} else if (isLessThan(a[right],key)) { //a[right] < key
			return right+1;
		}

		
		
		if(left > right) {
			//This part isn't used because the algorithm fixes left and right errors
		} else {
						
			if (isEqual(key,a[middle])) { // key is same as middle element
				index = middle;
				if (((middle-1) >= 0) && (isEqual(a[middle], a[middle-1]))) { // checks if two of the same elements  are in a row
					index = search(a, key, left, middle -1);
				}

			} else if (isLessThan(key,a[middle])) { // key is smaller than middle element
				index = search(a, key, left, middle - 1);

			} else if (isLessThan(a[middle],key)) {// key is larger than middle element
				index = search(a, key, middle + 1, right);
			}
		}

		return index;
	}
	
	/**
	 * Compares two {@link Comparable} elements and returns if the first element is
	 * less than the second element.
	 * @param firstElement of type {@link Comparable}
	 * @param secondElement of type {@link Comparable}
	 * @return true if the firstElement is less than the secondElement
	 */
	private boolean isLessThan(E firstElement, E secondElement) {
		return (firstElement.compareTo(secondElement) < 0);
	}
	
	/**
	 * Compares two {@link Comparable} elements and returns if the elements are the same
	 * @param firstElement of type {@link Comparable}
	 * @param secondElement of type {@link Comparable}
	 * @return true if the firstElement is the same as the secondElement
	 */
	private boolean isEqual(E firstElement, E secondElement) {
		return (firstElement.compareTo(secondElement) == 0);
	}

}
