package de.hska.iwi.ads.solution.sorting;

/**
 * Sorts a given array using a reverse merge sorting algorithm. 
 * The entire array can be sorted or only a given range.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class ReverseMergesort<E extends Comparable<E>> extends de.hska.iwi.ads.solution.sorting.MergesortBasis<E> {

	/**
	 * Using mergesort method from {@link MergesortBasis} class
	 */
	
	/**
	 * Reverses the right half of array {@code a} 
	 */
	@Override
	protected void merge(E [] a, int left, int middle, int right) {
		
		int l = left;
		int r = right; // strarting at the right end
		
		// reversing right half
		ReverseArray<E> rev = new ReverseArray<E>();
		rev.reverse(a, middle+1, right);
		
		for (int i = left; i <= right; i++) {

			if ((r > right) || 
					((l <= middle) && (isLessOrEqual(a[l], a[r])))) {
				b[i] = a[l];
				l++;
			} else {
				b[i] = a[r];
				r--; // going left
			}
		}
		// assign values to a
		for (int i = left; i <= right; i++) {
			a[i] = b[i];
		}
	}

}
