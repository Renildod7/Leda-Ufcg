package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em
 * suas funcionalidades e possui um metodo de ordenar um array dado como
 * parametro, retornando o resultado do percurso desejado que produz o array
 * ordenado.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

   private Comparator<T> comparator;

   public SortComparatorBSTImpl(Comparator<T> comparator) {
      super();
      this.comparator = comparator;
   }

   @Override
   public T[] sort(T[] array) {
      while (!this.isEmpty()) {
         this.remove(this.getRoot().getData());
      }

      for (T t : array)
         this.insert(t);

      return this.order();

   }

   @Override
   public T[] reverseOrder() {
      ArrayList<T> list = new ArrayList<>();
      reverseOrder(list, this.root);

      int tamanho = size();

      T[] retorno = (T[]) new Comparable[tamanho];

      for (int i = 0; i < tamanho; i++) {
         retorno[i] = list.get(i);
      }

      return retorno;
   }

   private void reverseOrder(ArrayList<T> list, BSTNode<T> node) {
      if (!node.isEmpty()) {

         if (!node.getRight().isEmpty())
            reverseOrder(list, ((BSTNode<T>) node.getRight()));
         list.add(node.getData());
         if (!node.getLeft().isEmpty())
            reverseOrder(list, ((BSTNode<T>) node.getLeft()));
      }

   }

   public Comparator<T> getComparator() {
      return comparator;
   }

   public void setComparator(Comparator<T> comparator) {
      this.comparator = comparator;
   }

   @Override
   public BSTNode<T> search(T element) {
      BSTNode<T> retorno = (BSTNode<T>) new BSTNode();

      if (element != null) {
         BSTNode<T> aux = this.root;
         boolean encontrou = false;

         while (!aux.isEmpty() && !encontrou) {
            if (aux.getData().equals(element)) {
               retorno = aux;
               encontrou = true;
            } else {
               if (this.comparator.compare(element, aux.getData()) < 0) {
                  aux = (BSTNode<T>) aux.getLeft();
               } else {
                  aux = (BSTNode<T>) aux.getRight();
               }
            }
         }
      }

      return retorno;
   }

   @Override
   public void insert(T element) {
      insert(element, this.root);
   }

   private void insert(T element, BSTNode<T> node) {

      if (node.isEmpty()) {
         node.setData(element);
         node.setLeft(new BSTNode<T>());
         node.getLeft().setParent(node);
         node.setRight(new BSTNode<T>());
         node.getRight().setParent(node);

      } else {

         if (this.comparator.compare(element, node.getData()) < 0) {
            insert(element, (BSTNode<T>) node.getLeft());
         } else {
            insert(element, (BSTNode<T>) node.getRight());
         }
      }
   }

}
