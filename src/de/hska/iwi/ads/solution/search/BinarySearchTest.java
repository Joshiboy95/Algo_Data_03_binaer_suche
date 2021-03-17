package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.*;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;
import de.hska.iwi.ads.solution.search.BinarySearch;

import org.junit.jupiter.api.Test;

class BinarySearchTest extends SearchTest{

	@Override
    public <E extends Comparable<E>> Search<E> createSearch() {
	  return new BinarySearch<E>();
	}
	
	@Test
	void testBinarySearchEmptyArray() {
	    Search<Integer> search = createSearch();
	    Integer [] a = {};
	    assertThrows(IllegalArgumentException.class, () -> search.search(a, 6));
	}
	
	@Test
	void testBinarySearchFalseBorders() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1
	    Integer [] a = {1 , 3};
	    assertThrows(IndexOutOfBoundsException.class, () -> search.search(a, 1, -1, 1));
	}
	
	@Test
	void testBinarySearchSwapedBorders() {
	    Search<Integer> search = createSearch();
	    //Index   		0  1  2  3
	    Integer [] a = {0, 1, 2 ,3};
	    assertEquals(1, search.search(a, 1, 3, 0));
	}
	
	@Test
	void testBinarySearchFindElementLeftOfBorder() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2
	    Integer [] a = {1 , 3, 4};
	    assertEquals(0, search.search(a, 1, 1, 1));
	}
	
	@Test
	void testBinarySearchFindElementRightOfBorder() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2
	    Integer [] a = {1 , 3, 4};
	    assertEquals(2, search.search(a, 4, 1, 1));
	}
	
	@Test
	void testBinarySearchFindFirstOccuranceMiddle() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6  7  8
	    Integer [] a = {1 , 2, 3, 3, 3, 3, 3, 4, 5};
	    assertEquals(2, search.search(a, 3));
	}
	
	@Test
	void testBinarySearchFindFirstOccuranceleft() {
	    Search<Integer> search = createSearch();
	    //Index   		0  1  2  3  4  5  6  7  8
	    Integer [] a = {3, 3, 3, 3, 4, 5, 6, 7, 8};
	    assertEquals(0, search.search(a, 3));
	}
	
	@Test
	void testBinarySearchFindFirstOccuranceright() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1   2   3  4  5  6  7  
	    Integer [] a = {-1, -1, -1, 0, 3, 3, 3, 3 };
	    assertEquals(4, search.search(a, 3));
	}
	
	@Test
	void testBinarySearchSingleElementArrayMissingKeyLeft() {
	    Search<Integer> search = createSearch();
	    //Index   		0   
	    Integer [] a = {42};
	    assertEquals(-1, search.search(a, 40));
	}
	
	@Test
	void testBinarySearchSingleElementArrayMissingKeyRight() {
	    Search<Integer> search = createSearch();
	    //Index   		0   
	    Integer [] a = {42};
	    assertEquals(1, search.search(a, 44));
	}
	
	@Test
	void testBinarySearchSingleElementArrayContainingKey() {
	    Search<Integer> search = createSearch();
	    //Index   		0   
	    Integer [] a = {42};
	    assertEquals(0, search.search(a, 42));
	}
	
	@Test
	void testBinarySearchContainingKey() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6
	    Integer [] a = {-2, 0, 2, 4, 6, 7, 10};
	    assertEquals(4, search.search(a, 6));
	}
	
	@Test
	void testBinarySearchMissingKeyInsideBorders() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6
	    Integer [] a = {-2, 0, 2, 4, 6, 7, 10};
	    assertEquals(4, search.search(a, 5));
	}
	
	@Test
	void testBinarySearchMissingKeyInsideBordersCenter() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6
	    Integer [] a = {-2, 0, 2, 3, 6, 7, 10};
	    assertEquals(4, search.search(a, 4));
	}
	
	@Test
	void testBinarySearchMissingKeyInsideBordersLeftOfCenter() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6   7
	    Integer [] a = {-2, 0, 2, 3, 6, 7, 10, 12,};
	    assertEquals(4, search.search(a, 4));
	}
	
	@Test
	void testBinarySearchMissingKeyInsideBordersRightOfCenter() {
	    Search<Integer> search = createSearch();
	    //Index   		0  1  2  3  4 
	    Integer [] a = {2, 3, 6, 8, 10};
	    assertEquals(3, search.search(a, 7));
	}
	
	
	@Test
	void testBinarySearchMissingKeyLeftOfBorder() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6
	    Integer [] a = {-2, 0, 2, 4, 6, 7, 10};
	    assertEquals(-1, search.search(a, -5));
	}
	
	@Test
	void testBinarySearchMissingKeyRightOfBorder() {
	    Search<Integer> search = createSearch();
	    //Index   		0   1  2  3  4  5  6
	    Integer [] a = {-2, 0, 2, 4, 6, 7, 10};
	    assertEquals(7, search.search(a, 15));
	}
	

	
	

}
