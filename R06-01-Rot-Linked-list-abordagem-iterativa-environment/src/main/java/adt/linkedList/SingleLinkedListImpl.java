package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> aux = this.head;
		int size = 0;
		
		while(aux != null) {
			if(!aux.isNIL()) {
				size++;
			}
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;
		T retorno = null;
		boolean encontrou = false;
		
		while(aux != null && !encontrou) {
			T auxData = aux.getData();
			if(element.equals(auxData)) {
				retorno = auxData;
				encontrou = true;
			}
			
		}
		
		return retorno;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
		
		if(isEmpty()) {
			this.head = newNode;
		} else {
			
			SingleLinkedListNode<T> aux = this.head;
			
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.next = newNode;
		}
		
	}

	@Override
	public void remove(T element) {
		boolean encontrou = false;
		if(!isEmpty()) {
			if(this.head.getData().equals(element)) {
				this.head = head.getNext();
				
			}
			SingleLinkedListNode<T> anterior = new SingleLinkedListNode<>();
			SingleLinkedListNode<T> atual = this.head;
			
			while(atual != null && !encontrou) {
				if(!atual.getData().equals(element)) {
					anterior = atual;
					atual = atual.getNext();
				} else {
					encontrou  = true;
				}	
			}
			anterior.setNext(atual.getNext());
			
		}
	}

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[this.size()];
		int cont = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(aux != null) {
			if(!aux.isNIL()) {
				retorno[cont] = aux.getData();				
				cont++;				
			}
			aux = aux.getNext();
		}
		
		return retorno;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
