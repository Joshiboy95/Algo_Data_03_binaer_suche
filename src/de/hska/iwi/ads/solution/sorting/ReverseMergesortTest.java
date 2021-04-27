package de.hska.iwi.ads.solution.sorting;

/*
 * @author Stephanie Thiele-Bergmann thst1012
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ReverseMergesortTest {

	//kann ich hier die Tests von Mergesort wirklich wiederverwenden?
	@Test
	void testReverseMergesortGeneral() {
		ReverseMergesort<Integer> merge = new ReverseMergesort<Integer>();
		Integer[] a = { 2, 1, 7, 12, 5, 9, 8, 10 };
		Integer[] result = { 1, 2, 5, 7, 8, 9, 10, 12 };
		merge.sort(a);
		assertArrayEquals(result, a);
	}
	
	//HIER GROSSES FRAGEZEICHEN
	@Test
	void testReverseMergesortLarge() {
		ReverseMergesort<Integer> merge = new ReverseMergesort<Integer>();
		
		Integer[] a = new Integer[100000];
		Integer[] result = new Integer[100000];
		
		for(int i = 0; i<100000; i++) {
			a[i]=i;
		}
		
		for(int i = 0; i<100000; i++) {
			result[i]=i;
		}
			
		merge.sort(a);
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
	void testMergesortOneElement() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5 };
		Integer[] result = { 5 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testMergesortTwoElements() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 3 };
		Integer[] result = { 3, 5 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testMergesortAlreadySortedList() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 1, 2, 3, 4, 5, 6 };
		Integer[] result = { 1, 2, 3, 4, 5, 6 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}


	@Test
	void testMergesortReverseSortedList() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 6, 5, 4, 3, 2, 1, };
		Integer[] result = { 1, 2, 3, 4, 5, 6, };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testMergesortAllSameElement() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 7, 7, 7, 7, 7 };
		Integer[] result = { 7, 7, 7, 7, 7 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	@Test
	void testMergesortArrayEvenNumber() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1 };
		Integer[] result = { 1, 3, 4, 5, 6, 7, 8 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	@Test
	void testMergesortArrayOddNumber() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1, 10 };
		Integer[] result = { 1, 3, 4, 5, 6, 7, 8, 10 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

	
	void testMergesortDuplicates() {
		ReverseMergesort<Integer> mergesort = new ReverseMergesort<Integer>();
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1, 10, 3, 8, 5, };
		Integer[] result = { 1, 3, 3, 4, 5, 5, 6, 7, 8, 8, 10 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}

}
