package de.hska.iwi.ads.solution.tree;

import java.util.AbstractMap.SimpleEntry;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {
	
	
	
	@Override
	public V get(Object o) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		
		K key = (K) o;
		
		Node temp = root;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				return temp.entry.getValue();
			}
			
			temp = temp.left;
			
		}return null;
		
	}
	
	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		Node temp = root;
		
		while(temp != null) {
			
			if(temp.entry.getKey().compareTo(key) == 0){
				
				V oldValue = temp.entry.getValue();
				
				temp.entry.setValue(value);
				
				return oldValue;
			}
			
			temp = temp.right;
		}
		
		@SuppressWarnings("unchecked")     
		Node newRoot = new Node(null, (V) this.root);
		
		
		
		
		
		return null;
		
	}
	
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub

		throw new UnsupportedOperationException("Not yet done.");
		}
	}


