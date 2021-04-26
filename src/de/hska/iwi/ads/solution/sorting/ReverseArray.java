package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

<<<<<<< HEAD
	
	@Override
	public void reverse(E[] a, int from, int to) {
		
// in case from and to are switched
		if(from > to) {
			int f = 0;
			f = from;
			from  = to;
			to = f;
		}
		
		//(to-from)/2 to find middle
		for (int i = 0; i < (to-from+1)/2; i++) {
			
			//swapping out: first element (from+i) with last element(to-i)
			E reversed = a[i+from];
			a[i+from] = a[to -i];
			a[to -i] = reversed;
			
		
		}
		
	}
	
	
=======
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
>>>>>>> 13c8646f15892813b368b51ad449b15ce9bd4acf
}
