package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			this.top.insert(element);
		
		} else {
			throw new StackOverflowException();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T retorno = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
			this.top.removeLast();
			return retorno;
		
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		T retorno = null;
		if(!isEmpty()) {
			retorno = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
		}
		
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
