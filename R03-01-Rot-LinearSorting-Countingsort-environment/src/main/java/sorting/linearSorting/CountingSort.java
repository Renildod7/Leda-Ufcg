package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex < array.length && leftIndex >=0) {
			
			int maior = Integer.MIN_VALUE;
			for(int i : array) {
				if(i > maior) maior = i;
			}
			
			int[] a = new int[maior];
			int[] b = new int[rightIndex - leftIndex +1];
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				a[array[i]-1]++; 
			}
			
			
			for(int i = 1; i < a.length; i++) {
				a[i] += a[i-1];
			}
			
			
			
			for(int i = rightIndex; i >=leftIndex ; i--) {
				b[a[array[i]-1]-1] = array[i];
				a[array[i]-1]--;				
			}

			
			int j = 0;
			for(int i = 0; i<array.length; i++) {
				if(i >= leftIndex && i <= rightIndex) {
					array[i] = b[j];
					j++;
				}
			}
			
		}
	}

}
