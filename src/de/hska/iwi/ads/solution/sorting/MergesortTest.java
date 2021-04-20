package de.hska.iwi.ads.solution.sorting;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.solution.search.BinarySearch;

public class MergesortTest{

	
	public <E extends Comparable<E>> Sort<E> createSorting() {
		return new Mergesort<E>();
	}
	
	//general test
	@Test
	void testMergesortGeneral() {
			Integer[] a = { 2, 1, 7, 12, 5, 9, 8, 10 };
			Integer[] result = { 1, 2, 5, 7, 8, 9, 10, 12 };
			Mergesort<Integer> ms = new Mergesort<Integer>();
			ms.sort(a);
			assertTrue(Sort.equals(a, result));
		}
	//empty list
	@Test
	void testMergesortIntArrayIntEmtpy() {
		Integer[] a = null;
		Mergesort<Integer> ms = new Mergesort<Integer>();
		assertThrows(NullPointerException.class, () -> ms.sort(a));
	}
	
	// one element
	@Test
	void testMergesortOneElement() {
		Integer[] a = { 5 };
		Integer[] result = { 5 };
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	//two elements
	@Test
	void testMergesortTwoElements() {
		Integer[] a = { 5, 3 };
		Integer[] result = { 3, 5 };
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	 //already sorted list
	@Test
	void testMergesortAlreadySortedList() {
		Integer[] a = { 1, 2, 3, 4, 5, 6};
		Integer[] result = { 1, 2, 3, 4, 5, 6};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	// reverse sorted list
	@Test
	void testMergesortReverseSortedList() {
		Integer[] a = {6, 5, 4, 3, 2, 1,};
		Integer[] result = {1, 2, 3, 4, 5, 6,};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	 // list all same element
	@Test
	void testMergesortAllSameElement() {
		Integer[] a = { 7, 7, 7, 7, 7};
		Integer[] result = { 7, 7, 7, 7, 7};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	 //array halves have even/odd number
	@Test
	void testMergesortArrayEvenNumber() {
		Integer[] a = { 5, 7, 6, 4, 8, 3, 1};
		Integer[] result = { 1, 3, 4, 5, 6 ,7, 8};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	@Test
	void testMergesortArrayOddNumber() {
		Integer[] a = {5, 7, 6, 4, 8, 3, 1, 10};
		Integer[] result = { 1, 3, 4, 5, 6 ,7, 8, 10};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
	
	 //duplicates
	void testMergesortDuplicates() {
		Integer[] a = {5, 7, 6, 4, 8, 3, 1, 10, 3, 8, 5,};
		Integer[] result = { 1, 3, 3, 4, 5, 5, 6 ,7, 8, 8, 10};
		Mergesort<Integer> ms = new Mergesort<Integer>();
		ms.sort(a);
		assertTrue(/*?*/.equals(a, result));

	}
		
		
		
	}


