package de.hska.iwi.ads.solution.sorting;

/**
 * Base class for creating a merge sorting algorithm. 
 * The entire array can be sorted or only a given range.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public abstract class MergesortBasis<E extends Comparable<E>> extends de.hska.iwi.ads.sorting.AbstractMergesort<E>{
	
	@Override
	protected void mergesort(E [] a, int left, int right) {
		
		int middle;
		
		if(left < right) {
			middle = (left + right) / 2;
			mergesort(a, left , middle);
			mergesort(a, middle+1, right);
			merge(a, left, middle, right);
		}
		
	}
	
	/**
	 * Implemented in {@link Mergesort} and in {@link ReverseMergesort}
	 */
	protected abstract void merge(E [] a, int left, int middle, int right);  
	

	
	/**
	 * Compares two {@link Comparable} elements and returns if the first element is
	 * less or equal than the second element.
	 * @param firstElement of type {@link Comparable}
	 * @param secondElement of type {@link Comparable}
	 * @return true if the firstElement is less than the secondElement
	 */
	protected boolean isLessOrEqual(E firstElement, E secondElement) {
		return (firstElement.compareTo(secondElement) <= 0);
	}


}
