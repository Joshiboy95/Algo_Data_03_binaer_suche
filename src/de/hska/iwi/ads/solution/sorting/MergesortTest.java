package de.hska.iwi.ads.solution.sorting;

/*
 * @author Stephanie Thiele-Bergmann thst1012
 */

import static org.junit.Assert.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MergesortTest {

	// general test
	@Test
	void testMergesortGeneral() {
		Mergesort<Integer> mergesort = new Mergesort<Integer>();
		Integer[] a = { 2, 1, 7, 12, 5, 9, 8, 10 };
		Integer[] result = { 1, 2, 5, 7, 8, 9, 10, 12 };
		mergesort.sort(a);
		assertArrayEquals(result, a);
	}
	
		//empty list
		@Test
		void testMergesortIntArrayIntEmtpy() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { };
			Integer [] result = { };
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		// one element
		@Test
		void testMergesortOneElement() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { 5 };
			Integer[] result = { 5 };
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}	
		
		//two elements
		@Test
		void testMergesortTwoElements() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { 5, 3 };
			Integer[] result = { 3, 5 };
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		 //already sorted list
		@Test
		void testMergesortAlreadySortedList() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { 1, 2, 3, 4, 5, 6};
			Integer[] result = { 1, 2, 3, 4, 5, 6};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		// reverse sorted list
		@Test
		void testMergesortReverseSortedList() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = {6, 5, 4, 3, 2, 1,};
			Integer[] result = {1, 2, 3, 4, 5, 6,};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		 // list all same element
		@Test
		void testMergesortAllSameElement() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { 7, 7, 7, 7, 7};
			Integer[] result = { 7, 7, 7, 7, 7};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		 //array halves have even/odd number
		@Test
		void testMergesortArrayEvenNumber() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = { 5, 7, 6, 4, 8, 3, 1};
			Integer[] result = { 1, 3, 4, 5, 6 ,7, 8};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		@Test
		void testMergesortArrayOddNumber() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = {5, 7, 6, 4, 8, 3, 1, 10};
			Integer[] result = { 1, 3, 4, 5, 6 ,7, 8, 10};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
		
		 //duplicates
		void testMergesortDuplicates() {
			Mergesort<Integer> mergesort = new Mergesort<Integer>();
			Integer[] a = {5, 7, 6, 4, 8, 3, 1, 10, 3, 8, 5,};
			Integer[] result = { 1, 3, 3, 4, 5, 5, 6 ,7, 8, 8, 10};
			mergesort.sort(a);
			assertArrayEquals(result, a);
		}
	
}
