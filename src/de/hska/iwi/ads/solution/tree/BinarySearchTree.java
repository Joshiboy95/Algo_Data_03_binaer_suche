package de.hska.iwi.ads.solution.tree;

import java.util.AbstractMap.SimpleEntry;

/**
 * a binary tree search
 * 
 * @author Stephanie Thiele-Bergmann - thst1012 - 68244
 */

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {
	
	
	
	@Override
	public V get(Object o) {
		
		@SuppressWarnings("unchecked")
		
		K key = (K) o;
		
		Node temp = root;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				return temp.entry.getValue();
				
			} else if ( < temp.entry.getKey()) {
				
				return temp.entry.left;
			
			
			//else for > 
			}else {
				return temp.entry.right;
			}

			
		}return null;
}
	
	
	@Override
	public V put(K key, V value) {
		
		//if there is  value with the key, overwrite with value and return oldValue
		Node temp = root;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				V oldValue = temp.entry.getValue();
				
				temp.entry.setValue(value);
				
				return oldValue;
			}
			
			
		}
		
		//puts value in a new leaf
		@SuppressWarnings("unchecked")     
		Node newRoot = new Node(null, (V) this.root);
		
		if (this.key < this.root) {
			  newRoot= root.left;
		}
	
		if (this.key > this.root) {
			newRoot =  root.right;
		}
	
	}

	
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("Not yet done.");
		}

}

