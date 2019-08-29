package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int iPivot = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, iPivot-1);
			sort(array, iPivot+1, rightIndex);
		}
	}

	private int particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int iAtual = leftIndex + 1;
		int iFinal = rightIndex;
		
		while(iAtual <= iFinal) {
			if(array[iAtual].compareTo(pivot) < 0) {
				iAtual++;
			
			}else if(array[iFinal].compareTo(pivot) >= 0) {
				iFinal--;
			
			}else {
				Util.swap(array, iAtual, iFinal);
				iAtual++;
				iFinal--;
			}
		}
		Util.swap(array, leftIndex, iFinal);
		return iFinal;
	}
}
