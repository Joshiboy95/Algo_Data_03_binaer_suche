package de.hska.iwi.ads.solution.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.hashtable.Hashtable;
import de.hska.iwi.ads.solution.tree.BinarySearchTree;

/**
 * Tests for {@link DoubleLinkedList}
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class DoubleLinkedListTest extends MapTest {	
	
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
		assertEquals("Zwei",commonTestMap.get(2));
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
		assertEquals("old Head", commonTestMap.get(1));
		assertEquals("new Head", commonTestMap.get(2));
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
		assertEquals("new Head", commonTestMap.get(1));
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
	
	// could take a while to complete
	//@Disabled
	@Test
	void testAlmostEndlessList(){
		commonTestMap = createMap();
		int AMOUNT_OF_ELEMENTS = 10000;
		
		for(int i = 1; i <= AMOUNT_OF_ELEMENTS; i++) {
			commonTestMap.put(i, "I like " + i);
		}
		// getting first (=head) element
		assertEquals("I like " + AMOUNT_OF_ELEMENTS, commonTestMap.get(AMOUNT_OF_ELEMENTS));
		//getting last element
		assertEquals("I like 1", commonTestMap.get(1));
		
		assertEquals(AMOUNT_OF_ELEMENTS, commonTestMap.size());
	}
	
	
}
