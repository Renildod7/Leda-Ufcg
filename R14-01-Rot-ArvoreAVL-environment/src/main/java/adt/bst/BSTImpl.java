package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

   protected BSTNode<T> root;

   public BSTImpl() {
      root = new BSTNode<T>();
   }

   public BSTNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return root.isEmpty();
   }

   @Override
   public int height() {
      return height(this.root);
   }

   protected int height(BSTNode<T> node) {
      if (node.isEmpty())
         return -1;
      return 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
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
               if (element.compareTo(aux.getData()) < 0) {
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

         if (element.compareTo(node.getData()) < 0) {
            insert(element, (BSTNode<T>) node.getLeft());
         } else {
            insert(element, (BSTNode<T>) node.getRight());
         }
      }
   }

   @Override
   public BSTNode<T> maximum() {
      if (this.root.isEmpty()) {
         return null;
      } else {
         return maximum(this.root);
      }
   }

   private BSTNode<T> maximum(BSTNode<T> node) {
      if (node.getRight().isEmpty()) {
         return (BSTNode<T>) node;
      } else {
         return maximum((BSTNode<T>) node.getRight());
      }
   }

   @Override
   public BSTNode<T> minimum() {
      if (this.root.isEmpty()) {
         return null;
      } else {
         return minimum(this.root);
      }
   }

   private BSTNode<T> minimum(BSTNode<T> node) {
      if (node.getLeft().isEmpty()) {
         return (BSTNode<T>) node;
      } else {
         return minimum((BSTNode<T>) node.getLeft());
      }
   }

   @Override
   public BSTNode<T> sucessor(T element) {

      BSTNode<T> node = (BSTNode<T>) search(element);

      if (node.isEmpty()) {
         return null;

      } else if (!node.getRight().isEmpty()) {
         return minimum((BSTNode<T>) node.getRight());

      } else {

         BSTNode<T> nodeAux = (BSTNode<T>) node.getParent();

         while (nodeAux != null && node.equals(nodeAux.getRight())) {
            node = nodeAux;
            nodeAux = (BSTNode<T>) node.getParent();
         }

         return nodeAux;
      }

   }

   @Override
   public BSTNode<T> predecessor(T element) {

      BSTNode<T> node = search(element);

      if (node.isEmpty()) {
         return null;
      }

      else if (!node.getLeft().isEmpty()) {
         return maximum((BSTNode<T>) node.getLeft());
      }

      else {
         BSTNode<T> nodeAux = (BSTNode<T>) node.getParent();

         while (nodeAux != null && node.equals(nodeAux.getLeft())) {
            node = nodeAux;
            nodeAux = (BSTNode<T>) node.getParent();
         }

         return nodeAux;
      }
   }

   @Override
   public void remove(T element) {

      BSTNode<T> node = search(element);

      if (!node.isEmpty()) {

         int grau = grau(node);

         if (grau == 0) {
            node.setData(null);
            ;

         } else if (grau == 1) {
            removeGrau1(node);

         } else if (grau == 2) {
            removeGrau2(node);
         }
      }

   }

   private void removeGrau2(BSTNode<T> node) {
      BSTNode<T> sucessor = (BSTNode<T>) sucessor(node.getData());

      int grauSucessor = grau(sucessor);

      node.setData(sucessor.getData());

      if (grauSucessor == 0) {
         sucessor.setData(null);
      } else if (grauSucessor == 1) {
         removeGrau1(sucessor);
      } else if (grauSucessor == 2) {
         removeGrau2(sucessor);
      }

   }

   private void removeGrau1(BSTNode<T> node) {
      if (node.getParent() == null) {

         if (!node.getLeft().isEmpty()) {
            node.getLeft().setParent(null);
            this.root = (BSTNode<T>) node.getLeft();
            return;

         } else {
            node.getRight().setParent(null);
            this.root = (BSTNode<T>) node.getRight();
            return;
         }
      }

      BSTNode<T> nodeAux;

      if (!node.getRight().isEmpty()) {
         nodeAux = (BSTNode<T>) node.getRight();
      } else {
         nodeAux = (BSTNode<T>) node.getLeft();
      }

      nodeAux.setParent(node.getParent());

      if (node.equals(node.getParent().getLeft())) {
         node.getParent().setLeft(nodeAux);

      } else if (node.equals(node.getParent().getRight())) {
         node.getParent().setRight(nodeAux);
      }

   }

   protected int grau(BSTNode<T> node) {
      int grau = -1;
      if (node == null || node.isEmpty()) {
         grau = -1;
      } else if (node.isLeaf()) {
         grau = 0;
      } else if (twoSons(node)) {
         grau = 2;
      } else {
         grau = 1;
      }

      return grau;

   }

   private boolean twoSons(BSTNode<T> node) {
      boolean twoSons = true;
      if (node.getLeft().isEmpty() || node.getRight().isEmpty() || node.getLeft() == null || node.getRight() == null) {
         twoSons = false;
      }

      return twoSons;
   }

   @Override
   public T[] preOrder() {
      ArrayList<T> list = new ArrayList<>();
      preOrder(list, this.root);

      int tamanho = size();

      T[] retorno = (T[]) new Comparable[tamanho];

      for (int i = 0; i < tamanho; i++) {
         retorno[i] = list.get(i);
      }

      return retorno;
   }

   private void preOrder(ArrayList<T> list, BSTNode<T> node) {
      if (!node.isEmpty()) {

         list.add(node.getData());
         if (!node.getLeft().isEmpty())
            preOrder(list, ((BSTNode<T>) node.getLeft()));
         if (!node.getRight().isEmpty())
            preOrder(list, ((BSTNode<T>) node.getRight()));
      }

   }

   @Override
   public T[] order() {
      ArrayList<T> list = new ArrayList<>();
      order(list, this.root);

      int tamanho = size();

      T[] retorno = (T[]) new Comparable[tamanho];

      for (int i = 0; i < tamanho; i++) {
         retorno[i] = list.get(i);
      }

      return retorno;
   }

   private void order(ArrayList<T> list, BSTNode<T> node) {
      if (!node.isEmpty()) {

         if (!node.getLeft().isEmpty())order(list, ((BSTNode<T>) node.getLeft()));
         list.add(node.getData());
         if (!node.getRight().isEmpty())order(list, ((BSTNode<T>) node.getRight()));
      }

   }

   @Override
   public T[] postOrder() {
      ArrayList<T> list = new ArrayList<>();
      postOrder(list, this.root);

      int tamanho = size();

      T[] retorno = (T[]) new Comparable[tamanho];

      for (int i = 0; i < tamanho; i++) {
         retorno[i] = list.get(i);
      }

      return retorno;
   }

   private void postOrder(ArrayList<T> list, BSTNode<T> node) {
      if (!node.isEmpty()) {

         if (!node.getLeft().isEmpty())
            postOrder(list, ((BSTNode<T>) node.getLeft()));
         if (!node.getRight().isEmpty())
            postOrder(list, ((BSTNode<T>) node.getRight()));
         list.add(node.getData());
      }

   }

   /**
    * This method is already implemented using recursion. You must understand
    * how it work and use similar idea with the other methods.
    */
   @Override
   public int size() {
      return size(root);
   }

   private int size(BSTNode<T> node) {
      int result = 0;
      // base case means doing nothing (return 0)
      if (!node.isEmpty()) { // indusctive case
         result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
      }
      return result;
   }

}
