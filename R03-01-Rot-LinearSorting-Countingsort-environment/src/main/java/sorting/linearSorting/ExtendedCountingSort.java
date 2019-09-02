package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      if (leftIndex < rightIndex && rightIndex < array.length && leftIndex >= 0) {

         int maior = Integer.MIN_VALUE;
         int menor = Integer.MAX_VALUE;
         for (int i : array) {
            if (i > maior)
               maior = i;
            if (i < menor)
               menor = i;
         }

         int acrescimo = menor * -1;

         int[] a = new int[maior + acrescimo + 1];
         int[] b = new int[rightIndex - leftIndex + 1];

         for (int i = leftIndex; i <= rightIndex; i++)
            a[array[i] + acrescimo]++;

         for (int i = 1; i < a.length; i++)
            a[i] += a[i - 1];

         for (int i = rightIndex; i >= leftIndex; i--) {
            b[a[array[i] + acrescimo] - 1] = array[i];
            a[array[i] + acrescimo]--;
         }

         int j = 0;
         for (int i = 0; i < array.length; i++) {
            if (i >= leftIndex && i <= rightIndex) {
               array[i] = b[j];
               j++;
            }
         }

      }

   }

}
