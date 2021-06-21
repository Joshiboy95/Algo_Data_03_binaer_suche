package de.hska.iwi.ads.solution.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;
import de.hska.iwi.ads.solution.list.DoubleLinkedList;

public class HashtableTest extends MapTest {

	private Map<Integer, String> commonTestMap;
	
	@SuppressWarnings("unchecked")
	@Override
	public <K extends Comparable<K>, V> Map<K, V> createMap() {
		return new DoubleLinkedList();//did we just copy that?
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
	void testRewriteValue(){
		commonTestMap = createMap();
		commonTestMap.put(2, "Zwei");
		String value = (String) commonTestMap.get(2);
		assertEquals("Zwei", value);
		assertEquals(1, commonTestMap.size());
		
		// Overwriting value
		String old = commonTestMap.put(2, "Dr�lf");
		assertEquals("Zwei", old);
		value = (String) commonTestMap.get(2);
		assertEquals("Dr�lf", value);
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
		//remove is not implemented yet
		commonTestMap = createMap();
		assertThrows(UnsupportedOperationException.class,() -> commonTestMap.remove(1));
	}
	
	@Test
	void testQuadraticProbing() {
		//TODO
	}

}