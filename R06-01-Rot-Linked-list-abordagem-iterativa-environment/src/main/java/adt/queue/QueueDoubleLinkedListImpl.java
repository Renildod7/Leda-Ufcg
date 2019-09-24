package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

   protected DoubleLinkedList<T> list;
   protected int size;

   public QueueDoubleLinkedListImpl(int size) {
      this.size = size;
      this.list = new DoubleLinkedListImpl<T>();
   }

   @Override
   public void enqueue(T element) throws QueueOverflowException {
      if (!isFull()) {
         this.list.insert(element);
      } else {
         throw new QueueOverflowException();
      }
   }

   @Override
   public T dequeue() throws QueueUnderflowException {
      if (!isEmpty()) {
         T retorno = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
         this.list.removeFirst();
         return retorno;

      } else {
         throw new QueueUnderflowException();
      }
   }

   @Override
   public T head() {
      T retorno = null;

      if (!isEmpty()) {
         retorno = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
      }

      return retorno;
   }

   @Override
   public boolean isEmpty() {
      return this.list.isEmpty();
   }

   @Override
   public boolean isFull() {
      return this.list.size() == this.size;
   }

}
