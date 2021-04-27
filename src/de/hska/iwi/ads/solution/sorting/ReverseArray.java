package de.hska.iwi.ads.solution.sorting;

/*
 * @author Stephanie Thiele-Bergmann thst1012
 */

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {


	
	@Override
	public void reverse(E[] a, int from, int to) {
		
// in case from and to are switched
		if(from > to) {
			int f = 0;
			f = from;
			from  = to;
			to = f;
		}
		
		if(from >= a.length || to >= a.length) {
			
			from = (int) a[0]; //ich versuche hier a.start zu finden-ist das richtig so?
			to = a.length-1;
			
		}
		
		//(to-from+1)/2 to find middle
		for (int i = 0; i < (to-from+1)/2; i++) {
			
			//swapping out: first element (from+i) with last element(to-i)
			E reversed = a[i+from];
			a[i+from] = a[to -i];
			a[to -i] = reversed;
			
		
		}
		
	}
	
	
}
