package de.hska.iwi.ads.solution.tree;

import java.util.AbstractMap.SimpleEntry;

/**
 * a binary tree search
 * 
 * @author Stephanie Thiele-Bergmann - thst1012 - 68244
 */

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object o) {
		
		K key = (K) o;
		
		Node temp = root;
	
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				return temp.entry.getValue();
				
				
			//key ist kleiner als root key
			} else if (temp.left.entry.getKey().compareTo(key) < 0) {
				
				temp = temp.left;
				
		
			//else for > 
			}else {
				
				temp = temp.right;
			}

		}
		
		return null;
}
	

	
	@Override
	public V put(K key, V value) {
		
		
		//if there is a value with the key, overwrite with value and return oldValue
		Node temp = root;
		
		Node newEntry = new Node(key, value);
		
		if(root == null) {
			
			root = newEntry;
			
			return value;
		}

		while(temp != null) {

			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				V oldValue = temp.entry.getValue();
				
				temp.entry.setValue(value);
				
				return oldValue;
				
			}
			
			//puts value in a new leaf
	
			if (temp.entry.getKey().compareTo(key) < 0 ) {
				
				if(temp.left == null) {
					
					temp.left = newEntry;
					
					return newEntry.entry.getValue();//should return this or null?
				}
			
				temp = temp.left;
					
			}
		
			if (temp.entry.getKey().compareTo(key) > 0) {
				
				if(temp.right == null) {
					
					temp.right = newEntry;
					
					return newEntry.entry.getValue();//should return this or null?
				}
			
				temp = temp.right;
			}	
			
		}

		return null;
	}

	
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("Not yet done.");
		}

}

