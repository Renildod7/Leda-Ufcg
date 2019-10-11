package adt.linkedList.set;


import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			
			while(!aux.getNext().isNIL()) {
				T auxData = aux.getData();
				
				SingleLinkedListNode<T> anterior = aux;
				SingleLinkedListNode<T> atual = aux.getNext();
				
				while(!atual.isNIL()) {
					if(auxData.equals(atual.getData())) {
						anterior.setNext(atual.getNext());
					}
					anterior = anterior.getNext();
					atual = anterior.getNext();
				}
				
				aux = aux.getNext();
			}
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedList<T> auxSet = new SetLinkedListImpl<T>();
		
		SingleLinkedListNode<T> auxThisNode = this.head;
		while(!auxThisNode.isNIL()) {
			auxSet.insert(auxThisNode.getData());
			auxThisNode = auxThisNode.getNext();
		}
		
		SingleLinkedListNode<T> auxOtherNode = ((SetLinkedListImpl<T>)otherSet).getHead();
		while(!auxOtherNode.isNIL()) {
			auxSet.insert(auxOtherNode.getData());
			auxOtherNode = auxOtherNode.getNext();
		}
		
		auxSet.removeDuplicates();
		
		return auxSet;
		
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedList<T> intersection = new SetLinkedListImpl<T>();
		
		
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {
			intersection.insert(otherSet.search(aux.getData()));
			aux = aux.getNext();
		}
		
		return intersection;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		SingleLinkedListNode<T> otherSetHead = ((SetLinkedListImpl<T>) otherSet).getHead();
		
		SingleLinkedListNode<T> thisSetNode = this.head;
		if(!isEmpty()) {
			while (!thisSetNode.getNext().isNIL()) {
				thisSetNode = thisSetNode.getNext();
			}

		} else {
			this.head = otherSetHead;
		}
		
		thisSetNode.setNext(otherSetHead);
		
		this.removeDuplicates();
	}
	
	@Override
	public void insert(T element) {
		if(this.search(element) == null) {
			super.insert(element);
		}
	}

}
