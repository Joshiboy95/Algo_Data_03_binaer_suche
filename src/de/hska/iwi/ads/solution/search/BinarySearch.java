package de.hska.iwi.ads.solution.search;


import de.hska.iwi.ads.search.Search;

/**
 * Searches a sorted array for a given value. 
 * The entire array can be searched or only a given range.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class BinarySearch<E extends Comparable<E>> implements Search<E>{

	@Override
	public int search(E [] a, E key, int left, int right) {
		System.out.println("Searching for " + key);

		int index = -42;
		int middle = (left + right) / 2;
		
		// If array is empty throw exception
		if (a.length == 0) { 
			throw new IllegalArgumentException();
		} 
		
		// 
		if (isEqual(key, a[left])) {
			index = left;
		} else if (isEqual(key, a[right])) {
			index = right;
		}
		
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
			System.out.println("Case: left > right  \n left: " + left + ", right: " + right);
			
			//TODO
		} else {
						
			if (isEqual(key,a[middle])) { // key is same as middle element
				index = middle;
				if (((middle-1) >= 0) && (isEqual(a[middle], a[middle-1]))) {
					index = search(a, key, left, middle -1);
				}

			} else if (isLessThan(key,a[middle])) { // key is smaller than middle element
				index = search(a, key, left, middle - 1);

			} else if (isLessThan(a[middle],key)) {// key is larger than middle element
				index = search(a, key, middle + 1, right);

				System.out.println("Searching right of " + middle);
			}
		}
		
		
		if (index < left){
			return left;
		} else if (right < index) {
			return right;
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
