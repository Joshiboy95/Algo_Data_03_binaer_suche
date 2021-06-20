package de.hska.iwi.ads.solution.list;

import java.util.Map.Entry;

/**
 * A doubly linked list
 * 
 * @author Stephanie Thiele-Bergmann - thst1012 - 68244
 */

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;


public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {

	@Override
	public V get(Object o) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked") 
		K key = (K) o;
		
		
		//goes through list, returns null if no key with that value
		ListElement temp = head;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				return temp.entry.getValue();
			}
			
			temp = temp.next;
			
		}return null;
		
		
	}
		

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		
		
		//overwrites oldValue with value, if there is a value with that key, returns oldValue
		ListElement temp = head;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				V oldValue = temp.entry.getValue();
				temp.entry.setValue(value);
				
				return oldValue;
			}
			
			temp = temp.next;
		}
			
		//puts value at beginning of list, returns null
		ListElement newHead = new ListElement(new SimpleEntry<K, V>(key, value), null, this.head);
		
		
		if(this.head == null) {
			this.head = newHead;
			
		}else {
			this.head.previous = newHead;
			this.head = newHead;
		}
		
		this.head.previous = newHead;
		this.head = newHead;
		
		size++;
		
		return null;
	
	}
	
	@Override
	public V remove(Object key) {
        throw new UnsupportedOperationException("Not yet done.");
		
	}
}
