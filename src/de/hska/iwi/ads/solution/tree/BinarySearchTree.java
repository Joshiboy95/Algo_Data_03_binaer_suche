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
				
			//der cast hier kannn nicht stimmen
			//traversieren richtig??? Da überseh ich doch was
			} else if (((Entry<K, V>) temp.left).getKey().compareTo(key) < 0) {
				
				return ((Entry<K, V>) temp).getValue();
			
			
			//else for > 
			}else {
				return ((Entry<K, V>) temp).getValue();
			}

			
		}return null;
}
	
	
	@Override
	public V put(K key, V value) {
		
		
		//if there is a value with the key, overwrite with value and return oldValue
		Node temp = root;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				V oldValue = temp.entry.getValue();
				
				temp.entry.setValue(value);
				
				return oldValue;
				
			}
			
			//puts value in a new leaf
			@SuppressWarnings("unchecked")     
			Node newRoot = new Node(null, (V) this.root);
			
			if (temp.entry.getKey().compareTo(key) < 0 ) {
				  newRoot = root.left;
			}
		
			if (temp.entry.getKey().compareTo(key) > 0) {
				newRoot = root.right;
			}	
			
		}
		return null;
		
	}

	
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("Not yet done.");
		}

}

