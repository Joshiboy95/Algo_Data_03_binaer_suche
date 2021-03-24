package de.hska.iwi.ads.solution.search;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import de.hska.iwi.ads.solution.search.BinarySearch;

import org.junit.jupiter.api.Test;

/**
 * Tests for class BinarySearch
 * 
 * @author Stephanie Thiele-Bergmann - thst1012 - 68244
 */

public class BinarySearchTest extends SearchTest {

	@Override
	public <E extends Comparable<E>> Search<E> createSearch() {
		return new BinarySearch<E>();
	}

	@Test // if empty
	void testBinarySearchEmptyArray() {
		Search<Integer> search = createSearch();
		Integer[] a = {};
		assertThrows(IllegalArgumentException.class, () -> search.search(a, 6));
	}

	@Test // out of bounds
	void testBinarySearchFalseBorders() {
		Search<Integer> search = createSearch();
		// Index 0 1
		Integer[] a = { 1, 3 };
		assertThrows(IndexOutOfBoundsException.class, () -> search.search(a, 1, -1, 1));
	}

	@Test // swapped borders
	void testBinarySearchSwapedBorders() {
		Search<Integer> search = createSearch();
		// Index 0 1 2 3
		Integer[] a = { 0, 1, 2, 3 };
		assertEquals(1, search.search(a, 1, 3, 0));
	}

	/*
	 * I tried :) Ich bin tatsächlich beim gleichen Code rausgekommen. Ich habe
	 * verschiedenes probiert, aber nur das, was du schon hattest, ging. Ich habe
	 * unten eine Frage zum Code an sich einkommentiert, damit ich die nicht
	 * vergesse. Außerdem ToDo: Die ganzen Kommentare entfernen vor der Abgabe!
	 */

	// key is larger than middle element - passt das so? Das testet doch eigentlich
	// nur für die 6....
	@Test
	void testBinarySearchLargerThanMiddle() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(5, search.search(a, 6));
	}

	// general search multiple elements
	@Test
	void testBinarySearchGeneral() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 3, 4, 5 };
		assertEquals(4, search.search(a, 5));
	}

	// general search single element
	@Test
	void testBinarySearchGeneralSongleElement() {
		Search<Integer> search = createSearch();
		Integer[] a = { 5 };
		assertEquals(0, search.search(a, 5));
	}

	// not found
	@Ignore
	@Test
	void testBinarySearchNotFound() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 3, 4, 5, 7, 8, 9 };
		assertEquals(5, search.search(a, 6));
	}

	// anywhere in array
	@Test
	void testBinarySearchAnyhere() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10 };
		assertEquals(7, search.search(a, 5));
		// geht das?
		Integer[] b = { 1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10 };
		assertEquals(9, search.search(b, 7));
	}

	// first in left, right, middle
	@Test
	void testBinarySearchFirstInLeft() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 3, 4, 4, 4, 5, 6, 7 };
		assertEquals(2, search.search(a, 4));
	}

	@Test
	void testBinarySearchFirstInMiddle() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 3, 4, 4, 4, 5, 6 };
		assertEquals(3, search.search(a, 4));
	}

	@Test
	void testBinarySearchFirstInRight() {
		Search<Integer> search = createSearch();
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(3, search.search(a, 4));
	}

	// single element left + right
	@Test
	void testBinarySearchSingleElementLeft() {
		Search<Integer> search = createSearch();
		Integer[] a = { 5 };
		assertEquals(-1, search.search(a, 3));
	}

	@Test
	void testBinarySearchSingleElementRight() {
		Search<Integer> search = createSearch();
		Integer[] a = { 5 };
		assertEquals(1, search.search(a, 7));
	}

	// in first half
	// key < a[left] nicht abgedeckt durch in first half???
	@Test
	void testBinarySearchInFirstHalf() {
		Search<Integer>/* Eclipse gefolgt, aber warum eigentlich? */ search = createSearch();
		Integer[] a = { 2, 3, 4, 5, 6, 7 };
		assertEquals(0, search.search(a, 2));
	}

	// in second half
	@Test
	void testBinarySearchInSecondHalf() {
		Search<Integer> search = createSearch();
		Integer[] a = { 2, 3, 4, 5, 6, 7 };
		assertEquals(3, search.search(a, 5));
	}

	// in middle
	@Test
	void testBinarySearchInMiddle() {
		Search<Integer> search = createSearch();
		Integer[] a = { 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(3, search.search(a, 5));
	}

}
