package de.hska.iwi.ads.solution.sorting;

/**
 * Sorts a given array using a merge sorting algorithm. 
 * The entire array can be sorted or only a given range.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class Mergesort<E extends Comparable<E>> extends de.hska.iwi.ads.solution.sorting.MergesortBasis<E> {
	
	/**
	 * Same as pseudocode of task sheet
	 */
	@Override
	public void merge(E [] a, int left, int middle, int right) {
		
		int l = left;
		int r = middle +1;
		
		for (int i = left; i <= right; i++) {

			if ((r > right) || 
					((l <= middle) && (isLessOrEqual(a[l], a[r])))) {
				b[i] = a[l];
				l++;
			} else {
				b[i] = a[r];
				r++;
			}
		}
		// assign values to a
		for (int i = left; i <= right; i++) {
			a[i] = b[i];
		}
	}

}
