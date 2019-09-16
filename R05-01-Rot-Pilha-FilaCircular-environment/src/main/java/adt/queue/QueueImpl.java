package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if(!isEmpty()) {
			return array[0];
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
		for(int i = 1; i <= tail; i++) {
			this.array[i-1] = this.array[i];
		}
		this.tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			array[++tail] = element;
		}else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()) {
			T retorno = array[0];
			shiftLeft();

			return retorno;
		}else {
			throw new QueueUnderflowException();
		}
	}

}
