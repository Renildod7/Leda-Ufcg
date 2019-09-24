package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if(isEmpty()) {
			DoubleLinkedListNode<T> next = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> prev = new DoubleLinkedListNode<T>();
			
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, next, prev);
			
			this.head = aux;
			this.last = aux;
		
		} else {
			DoubleLinkedListNode<T> prev = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
			
			((DoubleLinkedListNode<T>) this.head).setPrevious(newNode);
			newNode.setData(element);
			newNode.setPrevious(prev);
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			if(this.last.equals(this.head)) {
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
				this.head = aux;
				this.last = aux;
			
			} else {
				DoubleLinkedListNode<T> newHead = (DoubleLinkedListNode<T>) this.head.getNext();
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
				
				aux.setNext(newHead);
				newHead.setPrevious(aux);
				this.head = newHead;
				
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(this.last.equals(this.head)) {
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
				this.head = aux;
				this.last = aux;
			
			} else {
				DoubleLinkedListNode<T> prev = this.last.getPrevious();
				DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
				aux.setPrevious(prev);
				prev.setNext(aux);
				this.last = prev;
			}
		}
	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()) {
			DoubleLinkedListNode<T> next = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> prev = new DoubleLinkedListNode<T>();
			
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>(element, next, prev);
			
			prev.setNext(aux);
			next.setPrevious(aux);
			
			this.head = aux;
			this.last = aux;
		
		} else {
			DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) this.last.getNext();
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<T>();
			
			newLast.setData(element);
			newLast.setNext(aux);
			aux.setPrevious(newLast);
			this.last = newLast;
		}
	}
	
	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(this.head.getData().equals(element)) {
				removeFirst();
			
			} else {
				
				boolean encontrou = false;
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head.getNext();
				
				while(!aux.isNIL() && !encontrou) {
					if(aux.getData().equals(element)) {
						encontrou = true;
					} else {
						aux = (DoubleLinkedListNode<T>) aux.getNext();
					}
				}
				
				if(encontrou) {
					if(this.last.equals(aux)){
						removeLast();
					
					} else {
						
						DoubleLinkedListNode<T> prev = aux.getPrevious();
						DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) aux.getNext();
						
						prev.setNext(next);
						next.setPrevious(prev);
						
					}
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
