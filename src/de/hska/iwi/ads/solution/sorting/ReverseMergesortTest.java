package de.hska.iwi.ads.solution.sorting;

/*
 * @author Stephanie Thiele-Bergmann thst1012
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ReverseMergesortTest {
	
	@Test
	void testReverseMergesortGeneral() {
		ReverseMergesort<Integer> merge = new ReverseMergesort<Integer>();
		Integer[] a = { 2, 1, 7, 12, 5, 9, 8, 10 };
		Integer[] result = { 1, 2, 5, 7, 8, 9, 10, 12 };
		merge.sort(a);
		assertArrayEquals(result, a);
	}
	

	@Test
	void testReverseMergesortLarge() {
		ReverseMergesort<Integer> merge = new ReverseMergesort<Integer>();
		
		Integer[] a = new Integer[100000];
		Integer[] result = new Integer[100000];
		
		for(int i = 0; i<100000; i++) {
			a[i] = i;
		}
		
		for(int i = 0; i<100000; i++) {
			result[i]= i;
		}
		
		long time = System.currentTimeMillis();
		
		merge.sort(a);
		
		long time2 = System.currentTimeMillis();
		
		long time3 = time2-time;
		
		System.out.println(time3 + " ms");
		
		assertTrue(time3 < 1000);
		
		assertArrayEquals(result, a);
		
	}

	@Test
	void testReverseMergesortIntArrayIntEmtpy() {
		ReverseMergesort<Integer> merge = new ReverseMergesort<Integer>();
		Integer[] a = {};
		Integer[] result = {};
		merge.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testReverseMergesortOneElement() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5 };
		Integer[] result = { 5 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testReverseMergesortTwoElements() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 3 };
		Integer[] result = { 3, 5 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testReverseMergesortAlreadySortedList() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 1, 2, 3, 4, 5, 6 };
		Integer[] result = { 1, 2, 3, 4, 5, 6 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}


	@Test
	void testReverseMergesortReverseSortedList() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 6, 5, 4, 3, 2, 1, };
		Integer[] result = { 1, 2, 3, 4, 5, 6, };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testReverseMergesortAllSameElement() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 7, 7, 7, 7, 7 };
		Integer[] result = { 7, 7, 7, 7, 7 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testReverseMergesortArrayEvenNumber() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1 };
		Integer[] result = { 1, 3, 4, 5, 6, 7, 8 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	@Test
	void testReverseMergesortArrayOddNumber() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1, 10 };
		Integer[] result = { 1, 3, 4, 5, 6, 7, 8, 10 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	void testReverseMergesortDuplicates() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1, 10, 3, 8, 5, };
		Integer[] result = { 1, 3, 3, 4, 5, 5, 6, 7, 8, 8, 10 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

}
