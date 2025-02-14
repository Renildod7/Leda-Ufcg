package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
        	
        	int menor = leftIndex;
        	int maior = rightIndex;
        	T pivo = array[leftIndex];
        	int i = leftIndex +1;
        	
        	
        	while(i <= maior) {
        		if(array[i].compareTo(pivo) < 0) {
        			Util.swap(array, i, menor);
        			menor++;
        			i++;
        		}else if(array[i].compareTo(pivo) > 0) {
        			Util.swap(array, i, maior);
        			maior--;
        		}else {
        			i++;
        		}
        	}
        	
        	/**
        	 * Ao terminar o loop, o indice referente a variavel menor comrresponde ao indice da primeira
        	 * ocorrencia do pivot, e a varicavel maior corresponde a ultima ocorrencia do pivot, todos os
        	 * elementos cujo indices estao entre menor e maior sao iguais ao pivot.
        	 */
        	
        	sort(array, leftIndex, menor-1);
        	sort(array, maior+1, rightIndex);
        	
        }
	}
}
