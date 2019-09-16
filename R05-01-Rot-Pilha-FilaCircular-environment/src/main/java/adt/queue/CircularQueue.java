package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			this.tail = (this.tail +1) % this.array.length;
			this.array[this.tail] = element;
			this.elements++;
			if(this.head == -1) {
				this.head++;
			}
		}else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			T retorno = this.array[this.head];
			this.elements--;
			this.head = (this.head + 1) % this.array.length;	
			if(this.elements == 0) {
				this.head = -1;
				this.tail = -1;
			}
			return retorno;
		}else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if(!isEmpty()) {
			return this.array[this.head];
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return(this.elements == 0);
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length == this.head);
	}

}
