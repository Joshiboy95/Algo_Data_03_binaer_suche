package de.hska.iwi.ads.solution.hashtable;

import java.util.AbstractMap;
import java.util.Map;

import de.hska.iwi.ads.dictionary.AbstractHashMap;
import de.hska.iwi.ads.dictionary.AbstractDictionary.DictionaryFullException;

/**
 * A basic Hashtable
 * 
 * @author Joshua Rosenberger - rojo1041 - 68336
 */
public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V>{
	
	//Only use prime numbers or police will come!
	public static int MAX_PROBING_AMOUNT;

	public Hashtable(int capacity) {
		super(capacity);
		MAX_PROBING_AMOUNT = 911;
	}
	
	// For tests to define probing prime
	public Hashtable(int capacity, int probingAmountPrime) {
		super(capacity);
		MAX_PROBING_AMOUNT = probingAmountPrime;
	}
	
	public V get(Object o) {
		@SuppressWarnings("unchecked")
		K key = (K) o;
		int i = 0;
		int j = 0;
		do {
			j = probe(key, i, MAX_PROBING_AMOUNT);
			
			if((hashtable[j] != null) && (hashtable[j].getKey().compareTo(key) == 0)) {
				return hashtable[j].getValue();
			}
			i++;
			
		} while (hashtable[j] != null && (i < MAX_PROBING_AMOUNT));
		
		// return null if object o was not found in hashtable
		return null;
	}
	
	
	public V put(K key, V value) {
		int i = 0;
		do {
			int j = probe(key, i, MAX_PROBING_AMOUNT);
			
			if(j >= hashtable.length) {
				i++;
				continue;
			}
			
			if(hashtable[j] == null) {
				hashtable[j] = new AbstractMap.SimpleEntry<K, V>(key, value);
				this.size++;
				return value; //task doesn't state what should be returned here
			} else {
				// If key is equal
				if(hashtable[j].getKey().compareTo(key) == 0) {
					V old = hashtable[j].getValue();
					hashtable[j] = new AbstractMap.SimpleEntry<K, V>(key, value);
					return old;
				}
			}
			
			i++;
			
		} while (i < MAX_PROBING_AMOUNT);
		
		throw new DictionaryFullException();
	}
	
	
	
	/**
	 * Not needed.
	 */
	public void remove(K key) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}
	
	
	/**
	 * Quadratic Probing
	 * @param key the key to be inserted
	 * @param i the current retry number
	 * @param m the maximum retry amount
	 * 
	 * @return the index of the next container to probe
	 */
	private int probe(K key, int i, int m) {
		int hash = key.hashCode();
		int nextIndex = Math.floorMod((hash + (int) Math.pow(i, 2)), m);
		//System.out.println("For key: " + key.toString() + " probe:" + nextIndex);
		return nextIndex;
	}
		

}
