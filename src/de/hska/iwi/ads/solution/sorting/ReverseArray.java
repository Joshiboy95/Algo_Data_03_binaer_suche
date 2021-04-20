package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

	/*
	 * don't want to make new array, switch first element with last element (use
	 * indexes i), switch second element with second to last element and so on until
	 * it reaches middle of array a
	 * 
	 * rev just a variable name
	 */

	
	@Override
	public void reverse(E[] a, int from, int to) {
		
		// reverse for complete array of integer
		for (int i = 0; i < a.length /2; i++) {
			// E is the type here
			E rev = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - 1 - i] = rev;
		

		// reverse for left half
		for (int j = 0; j < to; j++) {
			E reve = a[j];
			a[j] = a[from - j - 1];
			a[to - 1 - j] = reve;
		}

		// reverse for right half
		for (int k = 0; k > from; k++) {
			E revex = a[k];
			a[k] = a[from - k - 1];
			a[to - 1 - k] = revex;
		}

		/*
		 * reverse for array of Strings reverse & for array of boolean: Sind die in der
		 * Aufgabe überhaupt gefordert und wenn ja, müsste das nicht einfach mit String,
		 * boolean statt int gehen?
		 */
	}
	}
}
