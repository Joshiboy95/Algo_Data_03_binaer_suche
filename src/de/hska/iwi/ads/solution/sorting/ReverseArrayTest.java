package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Tests for {@link ReverseArray} class.
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
class ReverseArrayTest {

	private ReverseArray<Integer> reverseIntArray;
	private ReverseArray<String> reverseStringArray;
	private ReverseArray<Boolean> reverseBooleanArray;

	
    /**
     * Test setup
     */
	
    @BeforeEach
    void init() {
    	reverseIntArray = new ReverseArray<Integer>();
    	reverseStringArray = new ReverseArray<String>();
    	reverseBooleanArray = new ReverseArray<Boolean>();
    }

    @AfterEach
    void teardown() {
    	//shouldn't need to tear down
    }
	
    /**
     * Start Tests
     * 
     * Reversing the full array
     */

	@Test 
	void testReverseAscendingFull() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4, 5};
		Integer[] descendingArray = new Integer[] {5, 4, 3, 2, 1, 0};
		reverseIntArray.reverse(ascendingArray,0,5);
		assertArrayEquals(descendingArray, ascendingArray);
	}
	
	@Test 
	void testReverseDescendingFull() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4, 5};
		Integer[] descendingArray = new Integer[] {5, 4, 3, 2, 1, 0};
		reverseIntArray.reverse(descendingArray,0,5);
		assertArrayEquals(ascendingArray, descendingArray);
	}
	
	@Test 
	void testReverseRandomFull() {
		Integer[] randomArray = new Integer[] {5, 1, 4, 3, 0, 2};
		reverseIntArray.reverse(randomArray,0,5);
		assertArrayEquals(new Integer[] {2, 0, 3, 4, 1, 5}, randomArray);
	}

	
	/*@Test 
	void testReverseStringFull() {
		String[] stringArray = new String[] {"Otto", "Anna", "Bob","Hannah"};
		reverseStringArray.reverse(stringArray,0,3);
		assertArrayEquals(new String[] {"Hannah","Bob", "Anna", "Otto"}, stringArray);
	}
	
	@Test 
	void testReverseBooleanFull() {
		Boolean[] boolArray = new Boolean[] {true, false, true, false};
		reverseBooleanArray.reverse(boolArray,0,3);
		assertArrayEquals(new Boolean[] {false, true, false, true}, boolArray);
	}*/
	
	@Test 
	void testReverseReuseReverseObject() {
		Integer[] array = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(array,0,5);
		assertArrayEquals(new Integer[] {5, 4, 3, 2, 1, 0}, array);
		reverseIntArray.reverse(array,0,5); // back to original
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5}, array);
		reverseIntArray.reverse(array,1,4);
		assertArrayEquals(new Integer[] {0, 4, 3, 2, 1, 5}, array);
	}
	
    /**
     * Reversing only a range
     */
	
	@Test 
	void testReverseRangeLeft() {
		Integer[] array = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(array,0,2);
		assertArrayEquals(new Integer[] {2, 1, 0, 3, 4, 5}, array);
	}
	
	@Test 
	void testReverseRangeMiddleEven() {
		Integer[] array = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(array,2,3);
		assertArrayEquals(new Integer[] {0, 1, 3, 2, 4, 5}, array);
	}
	@Test 
	void testReverseRangeMiddleUneven() {
		Integer[] array = new Integer[] {0, 1, 2, 3, 4};
		reverseIntArray.reverse(array,1,3);
		assertArrayEquals(new Integer[] {0, 3, 2, 1, 4}, array);
	}
	
	@Test 
	void testReverseRangeRight() {
		Integer[] array = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(array,3,5);
		assertArrayEquals(new Integer[] {0, 1, 2, 5, 4, 3}, array);
	}
	
	/**
	 * Reversing a single element (from = to):
	 * Array should stay unchanged
	 */
	
	@Test 
	void testReverseSingleLeft() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(ascendingArray,0,0);
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5}, ascendingArray);
	}
	
	@Test 
	void testReverseSingleMiddle() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4};
		reverseIntArray.reverse(ascendingArray,2,2);
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4}, ascendingArray);
	}
	
	@Test 
	void testReverseSingleRight() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(ascendingArray,5,5);
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5}, ascendingArray);
	}
	
	@Test 
	void testReverseSingleOnlyElement() {
		Integer[] array = new Integer[] {42};
		reverseIntArray.reverse(array,0,0);
		assertArrayEquals(new Integer[] {42}, array);
	}
	
	/**
	 * Testing false parameters:
	 * Should all throw IllegalArgumentExceptions
	 * Array should stay unchanged
	 * TODO kl�ren mit @Stephanie
	 * k�nnen wir noch �ndern wenn du denkst es soll was anderes passieren
	 */
	
	@Test 
	void testReverseWrongFromTo() {
		Integer[] array = new Integer[] {0,1,2};
		reverseIntArray.reverse(array,42,42);
		System.out.println("array: "+ array); // array should stay the same
		assertThrows(IllegalArgumentException.class, () -> reverseIntArray.reverse(array,42,42));
		assertEquals(new Integer[] {0,1,2}, array);
	}
			
	/**
	 * Reversing with swapped from and to
	 * TODO kl�ren mit @Stephanie
	 * soll das dann noch korrekt funktionieren? 
	 * erwartet momentan dass die werte getauscht werden
	 */
	@Test 
	void testReverseSwapped() {
		Integer[] ascendingArray = new Integer[] {0, 1, 2, 3, 4, 5};
		reverseIntArray.reverse(ascendingArray,4,1);
		assertArrayEquals(new Integer[] {0, 4, 3, 2, 1, 5}, ascendingArray);
	}
	
}
