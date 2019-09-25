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
		
		while(!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T retorno = null;
		boolean encontrou = false;
		
		SingleLinkedListNode<T> aux = this.head;
		
		while(!aux.isNIL() && !encontrou) {
			T auxData = aux.getData();
			if(element.equals(auxData)) {
				retorno = auxData;
				encontrou = true;
			}
			aux = aux.getNext();
			
		}
		
		return retorno;
	}

	@Override
	public void insert(T element) {
		
		if(isEmpty()) {
			this.head.setData(element);
			this.head.setNext(new SingleLinkedListNode<T>());
		} else {
			
			SingleLinkedListNode<T> aux = this.head;
			
			while(!aux.isNIL()) {
				aux = aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
		}
		
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(this.head.getData().equals(element)) {
				this.head = head.getNext();
				
			}
		
			SingleLinkedListNode<T> anterior = this.head;
			SingleLinkedListNode<T> atual = this.head.getNext();
			
	
			boolean encontrou = false;
			while(!atual.isNIL() && !encontrou) {
				if(!atual.getData().equals(element)) {
					anterior = atual;
					atual = atual.getNext();
				} else {
					encontrou  = true;
				}	
			}
			if(encontrou) {
				anterior.setNext(atual.getNext());				
			}
			
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
