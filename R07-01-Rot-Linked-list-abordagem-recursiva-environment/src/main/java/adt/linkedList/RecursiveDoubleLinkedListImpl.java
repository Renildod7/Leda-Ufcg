package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(!isEmpty()) {
			T aux = this.data;
			this.data = element;
			
			((RecursiveDoubleLinkedListImpl<T>) this.next).insertFirst(aux);
					
		} else {
			this.data = element;
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
			aux.setPrevious(this);
			this.setNext(aux);
			
			
		}
	}

	@Override
	public void removeFirst() {
		if(this.next.isEmpty()) {
			this.next = null;
			this.data = null;
			
		} else {
			this.data = this.next.getData();
			((RecursiveDoubleLinkedListImpl<T>) this.next).removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(this.next.isEmpty()) {
				this.data = null;
				this.next = null;
			
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
			aux.setPrevious(this);
			this.setNext(aux);
		} else {
			this.next.insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			
			if(element.equals(this.data)) {
				removeFirst();
			}
			
			if(this.next.getData().equals(element)) {
				RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) this.next.getNext();
				this.next = aux;
				aux.setPrevious(this);
				
			} else {
				this.next.remove(element);
			}
			
		}
		
	}
	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}
	
	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
