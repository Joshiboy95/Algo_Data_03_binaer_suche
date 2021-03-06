package de.hska.iwi.ads.solution.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;

/**
 * Tests for {@link BinarySearchTree}
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class BinarySearchTreeTest extends MapTest {

	private Map<Integer, String> commonTestMap;
	
	@Override
	public <K extends Comparable<K>, V> Map<K, V> createMap() {
		return new DoubleLinkedList<K, V>();
	}
	
	@Test
	void testGetEmptyTable() {
		commonTestMap = createMap();
	    assertNotNull(commonTestMap);
		String value = (String) commonTestMap.get(1);
		assertEquals(null, value);
	}
	
	@Test
	void testPutEmptyTable() {
		commonTestMap = createMap();
		String value = (String) commonTestMap.put(2, "Zwei");
		//returned null if new head was added successfully
		assertEquals(null, value);
		assertEquals(1, commonTestMap.size());
	}
	
	@Test
	void testPutNewHead() {
		commonTestMap = createMap();
		String value = (String) commonTestMap.put(1, "old Head");
		//returned null if new head was added successfully
		assertEquals(null, value);
		
		value = (String) commonTestMap.put(2, "new Head");
		//returned null if new head was added successfully
		assertEquals(null, value);
		
		//should have two elements
		assertEquals(2, commonTestMap.size());
	}
	
	@Test
	void testPutChangeValue() {
		commonTestMap = createMap();
		String value = (String) commonTestMap.put(1, "old Head");
		//putting new value for existing key
		value = (String) commonTestMap.put(1, "new Head");
		//returned old value if new value was added successfully
		assertEquals("old Head", value);
		
		//should have only one element
		assertEquals(1, commonTestMap.size());
	}
		
	
	@Test
	void testRewriteValue(){
		commonTestMap = createMap();
		commonTestMap.put(2, "Zwei");
		String value = (String) commonTestMap.get(2);
		assertEquals("Zwei", value);
		assertEquals(1, commonTestMap.size());
		
		// Overriting value
		String old = commonTestMap.put(2, "Dr???lf");
		assertEquals("Zwei", old);
		value = (String) commonTestMap.get(2);
		assertEquals("Dr???lf", value);
		assertEquals(1, commonTestMap.size());
	}
	
	@Test
	void testNonExistingKey() {
		commonTestMap = createMap();
		commonTestMap.put(2, "Zwei");
		String value = (String) commonTestMap.get(1);
		assertEquals(null, value);
	}

	
	@Test
	void testRemoveException(){
		commonTestMap = createMap();
		assertThrows(UnsupportedOperationException.class,() -> commonTestMap.remove(1));
	}
	
	/**
	 * Tests the duration of adding a new entry to an already filled BinarySearchTree. <br>
	 * The duration should be {@code   O(log n)}. <br>
	 * Calculates the time to put and to get an entry. <br>
	 *  <br>
	 * TODO: Change NUMBER_OF_ELEMENTS if test takes tooooo long (only if "log n")
	 */
	@Test
	void testLogNDuration(){
		commonTestMap = createMap();
		int NUMBER_OF_ELEMENTS = 20000;
		int MAXIMUM_DURATION_MILISECONDS = 1000; 
		long timeBefore;
		long timeAfter;
		long duration;
		
		for(int i = 1; i < NUMBER_OF_ELEMENTS; i++) {
			commonTestMap.put(i, "I like " + i);
			System.out.println(i);
		}
		
		//put last element
		timeBefore = System.currentTimeMillis();
		assertEquals(null, commonTestMap.put(NUMBER_OF_ELEMENTS,"I like " + NUMBER_OF_ELEMENTS));
		timeAfter = System.currentTimeMillis();
		duration = (timeAfter - timeBefore);
		//assert duration below threshhold
		System.out.println(duration + "ms");
		assertTrue(duration <= MAXIMUM_DURATION_MILISECONDS);
		
		
		//get that last element
		timeBefore = System.currentTimeMillis();
		assertEquals("I like " + NUMBER_OF_ELEMENTS, commonTestMap.get(NUMBER_OF_ELEMENTS));
		timeAfter = System.currentTimeMillis();
		duration = (timeAfter - timeBefore);
		//assert duration below threshold
		assertTrue(duration <= MAXIMUM_DURATION_MILISECONDS);
		System.out.println(duration + "ms");
		
		assertEquals(NUMBER_OF_ELEMENTS+1, commonTestMap.size()+1);
	}
	
}
