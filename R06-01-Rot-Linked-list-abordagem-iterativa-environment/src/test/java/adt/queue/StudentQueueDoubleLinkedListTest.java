package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueDoubleLinkedListTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;
	public Queue<Integer> queue5;
	public Queue<Integer> queue6;
	
	

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue4.enqueue(1);
		queue4.enqueue(2);
		queue4.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);
		queue5.enqueue(1);
		queue5.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<>(4);
		queue2 = new QueueDoubleLinkedListImpl<>(2);
		queue3 = new QueueDoubleLinkedListImpl<>(1);
		queue4 = new QueueDoubleLinkedListImpl<>(4);
		queue5 = new QueueDoubleLinkedListImpl<>(2);
		queue6 = new QueueDoubleLinkedListImpl<>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));;
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(4));
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
		assertEquals(new Integer(2), queue1.dequeue());
		assertEquals(new Integer(3), queue1.dequeue());
		assertEquals(new Integer(4), queue1.dequeue());
		queue1.dequeue();
		
	}
	
	
	@Test
	public void testHead2() {
		assertEquals(new Integer(1), queue4.head());
	}

	@Test
	public void testIsEmpty2() {
		assertFalse(queue4.isEmpty());
		assertTrue(queue6.isEmpty());
	}

	@Test
	public void testIsFull2() {
		assertFalse(queue4.isFull());
	}

	@Test
	public void testEnqueue2() {
		try {
			queue4.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro2() throws QueueOverflowException {
		queue4.enqueue(new Integer(4));
		queue4.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue2() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro2() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue4.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
		assertEquals(new Integer(2), queue4.dequeue());
		assertEquals(new Integer(3), queue4.dequeue());
		assertEquals(new Integer(4), queue4.dequeue());
		queue4.dequeue();
		
	}
}