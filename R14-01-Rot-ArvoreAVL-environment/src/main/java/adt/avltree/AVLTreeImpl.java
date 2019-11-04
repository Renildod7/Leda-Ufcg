package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if(node == null || node.isEmpty()) {
			return 0;
		}
		
		
		int alturaLeft = height(getLeft(node));
		int alturaRight = height(getRight(node));
		
		return alturaLeft - alturaRight;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		
		if(balance < -1) {
			if(calculateBalance(getRight(node)) > 0) {
				rightRotation(getRight(node));
			}
			leftRotation(node);
			
		} else if (balance > 1) {
			if(calculateBalance(getLeft(node)) < 0) {
				leftRotation(getLeft(node));
			}
			rightRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if(node != null) {
			rebalance(node);
			rebalanceUp(getParent(node));
		}
	}
	
	
	
	private BSTNode<T> getLeft(BSTNode<T> node) {
		return (BSTNode<T>)node.getLeft();
	}
	
	private BSTNode<T> getRight(BSTNode<T> node) {
		return (BSTNode<T>)node.getRight();
	}
	
	private BSTNode<T> getParent(BSTNode<T> node) {
		return (BSTNode<T>)node.getParent();
	}
	
	private void leftRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.leftRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}

	private void rightRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.rightRotation(node);
		if (newNode.getParent() == null) {
			this.root = newNode;
		}
	}
}
