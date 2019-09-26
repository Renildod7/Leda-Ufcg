package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if(isEmpty()) return 0;
		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if(isEmpty()) return null;
		if(element.equals(this.data)) return element;
		return this.next.search(element);
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(element.equals(this.data)) {
				if(this.next.isEmpty()) {
					this.next = null;
					this.data = null;
				
				} else {
					this.data = this.next.getData();
					this.next.remove(this.next.getData());
				}

			}
			
			if(this.next.getData().equals(element)) {
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
			
		}
	}

	@Override
	public T[] toArray() {
		T[] array =(T[]) new Comparable[size()];
		int index = 0;
		
		if(!isEmpty()) {
			return toArray(array, index);
		} else {
			return array;
		}
		
	}
	
	public T[] toArray(T[] array, int index) {
		if(!isEmpty()) {
			array[index] = this.data;
			return this.next.toArray(array, index + 1);
		
		} else {
			return array;
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
