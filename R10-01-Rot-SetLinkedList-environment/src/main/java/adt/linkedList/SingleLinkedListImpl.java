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
		int size = 0;
		
		SingleLinkedListNode<T> aux = this.head;
		
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
			if(aux.getData().equals(element)) {
				retorno = aux.getData();
				encontrou = true;
			}
			aux = aux.getNext();
		}
		
		return retorno;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			
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
		if(!isEmpty() && element != null) {
			
			if(element.equals(this.head.getData())) {
				this.head = this.head.getNext();
			
			} else {
				
				SingleLinkedListNode<T> anterior = this.head;
				SingleLinkedListNode<T> atual = this.head.getNext();
	
				
				while(!atual.isNIL()) {
					if(atual.getData().equals(element)) {
						anterior.setNext(atual.getNext());
						atual.setNext(new SingleLinkedListNode<T>());
						
					} else {
						anterior = atual;
						atual = atual.getNext();
					}
				}

			}
		}
	}

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[this.size()];
		int cont = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {

			retorno[cont] = aux.getData();				
			cont++;				

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
