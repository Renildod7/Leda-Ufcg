package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

	@Override
	public T head() {
		if(!isEmpty()) {
			return this.array[0];
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return(this.tail == -1);
	}

	@Override
	public boolean isFull() {
		return(this.tail == this.array.length-1);
	}

	private void shiftLeft() {
		for(int i = 1; i <= this.tail; i++) {
			this.array[i-1] = this.array[i];
		}
		this.tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			this.array[++this.tail] = element;
		}else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			T retorno = this.array[0];
			shiftLeft();

			return retorno;
		}else {
			throw new QueueUnderflowException();
		}
	}

}
