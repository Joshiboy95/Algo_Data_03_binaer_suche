package de.hska.iwi.ads.solution.tree;

import java.util.AbstractMap.SimpleEntry;

/**
 * a binary tree search
 * 
 * @author Stephanie Thiele-Bergmann - thst1012 - 68244
 */

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {
	
	
	//this is waaaaay too slow - 1 failing test
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object o) {
		
		
		K key = (K) o;
		
		Node temp = root;
		
		Node prev = null;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				return temp.entry.getValue();
				
				
			//key ist kleiner als root key
			} else if (temp.left.getKey().compareTo(key) < 0) {
				prev = temp;
				temp = temp.left;
				
				//recursiv weiter suchen
				return  get(temp.left, key);
			
			
			//else for > 
			}else {
				prev = temp;
				temp = temp.right;
				
				return get(temp.right, key);
				
			}

			//Versuch, value zurückzugeben
		}return temp.entry.getValue();
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
			
			Node prev = null;
			
			if (temp.entry.getKey().compareTo(key) < 0 ) {
				prev = temp;
				temp = temp.left;
				
				newRoot = root.left;
			}
		
			if (temp.entry.getKey().compareTo(key) > 0) {
				prev = temp;
				temp = temp.right;
				
				newRoot = root.right;
			}	
			
		}
		return null;//really null?
		
	}

	
	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("Not yet done.");
		}

}

