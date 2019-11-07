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
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return 0;
		}

		int alturaLeft = height(getLeft(node));
		int alturaRight = height(getRight(node));

		return alturaLeft - alturaRight;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (balance < -1) {
			if (calculateBalance(getRight(node)) > 0) {
				rightRotation(getRight(node));
			}
			leftRotation(node);

		} else if (balance > 1) {
			if (calculateBalance(getLeft(node)) < 0) {
				leftRotation(getLeft(node));
			}
			rightRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			rebalance(node);
			rebalanceUp(getParent(node));
		}
	}

	private BSTNode<T> getLeft(BSTNode<T> node) {
		return (BSTNode<T>) node.getLeft();
	}

	private BSTNode<T> getRight(BSTNode<T> node) {
		return (BSTNode<T>) node.getRight();
	}

	private BSTNode<T> getParent(BSTNode<T> node) {
		return (BSTNode<T>) node.getParent();
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

	@Override
	public void remove(T element) {

		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {

			int grau = grau(node);

			if (grau == 0) {
				node.setData(null);
				rebalanceUp(node);

			} else if (grau == 1) {
				removeGrau1(node);

			} else if (grau == 2) {
				removeGrau2(node);
			}
		}

	}

	private void removeGrau2(BSTNode<T> node) {
		BSTNode<T> sucessor = (BSTNode<T>) sucessor(node.getData());

		int grauSucessor = grau(sucessor);

		node.setData(sucessor.getData());

		if (grauSucessor == 0) {
			sucessor.setData(null);
		} else if (grauSucessor == 1) {
			removeGrau1(sucessor);
		} else if (grauSucessor == 2) {
			removeGrau2(sucessor);
		}

	}

	private void removeGrau1(BSTNode<T> node) {
		if (node.getParent() == null) {

			if (!node.getLeft().isEmpty()) {
				node.getLeft().setParent(null);
				this.root = (BSTNode<T>) node.getLeft();
				rebalanceUp(this.root);
				return;

			} else {
				node.getRight().setParent(null);
				this.root = (BSTNode<T>) node.getRight();
				rebalanceUp(this.root);
				return;
			}
		}

		BSTNode<T> nodeAux;

		if (!node.getRight().isEmpty()) {
			nodeAux = (BSTNode<T>) node.getRight();
		} else {
			nodeAux = (BSTNode<T>) node.getLeft();
		}

		nodeAux.setParent(node.getParent());

		if (node.equals(node.getParent().getLeft())) {
			node.getParent().setLeft(nodeAux);

		} else if (node.equals(node.getParent().getRight())) {
			node.getParent().setRight(nodeAux);
		}

		rebalanceUp(nodeAux);

	}

	@Override
	public void insert(T element) {
		insert(element, this.root);
	}

	private void insert(T element, BSTNode<T> node) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
			
			rebalanceUp(node);

		} else {

			if (element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode<T>) node.getLeft());
			} else {
				insert(element, (BSTNode<T>) node.getRight());
			}
		}
	}
}
