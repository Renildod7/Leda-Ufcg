package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heigth(this.root);
	}

	private int heigth(BSTNode<T> node) {
		if(node.isEmpty()) return -1;
		return 1 + Math.max(heigth((BSTNode<T>) node.getLeft()), heigth((BSTNode<T>) node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> retorno = (BSTNode<T>) new BSTNode();
		
		if(element != null) {
			BSTNode<T> aux = this.root;
			boolean encontrou = false;
			
			while(!aux.isEmpty() && !encontrou) {
				if(aux.getData().equals(element)) {
					retorno = aux;
					encontrou = true;
				} else {
					if(element.compareTo(aux.getData()) < 0) {
						aux = (BSTNode<T>) aux.getLeft();
					} else {
						aux = (BSTNode<T>) aux.getLeft();
					}
				}
			}
		}
		
		return retorno;
	}

	@Override
	public void insert(T element) {
		insert(element, this.root);
	}

	private void insert(T element, BSTNode<T> node) {
		
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		
		} else {
			
			if(element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode<T>)node.getLeft());
			} else {
				insert(element, (BSTNode<T>)node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(this.root.isEmpty()) {
			return null;
		} else {
			return maximum(this.root);
		}
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if(node.getRight().isEmpty()) {
			return (BSTNode<T>)node;
		} else {
			return maximum((BSTNode<T>)node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if(this.root.isEmpty()) {
			return null;
		} else {
			return minimum(this.root);
		}
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if(node.getLeft().isEmpty()) {
			return (BSTNode<T>)node;
		} else {
			return minimum((BSTNode<T>)node.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		if(element.equals(this.maximum().getData())) {
			return null;
		} else {
			return minimum((BSTNode<T>) search(element).getRight());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if(element.equals(this.minimum().getData())) {
			return null;
		} else {
			return(maximum((BSTNode<T>) search(element).getLeft()));
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
