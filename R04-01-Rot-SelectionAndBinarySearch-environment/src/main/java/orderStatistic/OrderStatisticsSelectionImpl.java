package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if(k <= array.length && k > 0) {
			
		
			T menor = array[0];
			T maior = array[0];
			
			for(T i : array) {
				if(i.compareTo(menor) < 0) {
					menor = i;
				}
				if(i.compareTo(maior) > 0) {
					maior = i;
				}
			}
			
			if(k == 1) {
				return menor;
			} else {
				return getOrderStatistics(array, k-1, maior, menor);
			}
		
		
		
		
		} else {
			return null;
		}
		
	}

	private T getOrderStatistics(T[] array, int k, T maiorDoArray, T menorAnterior) {
		T menor = maiorDoArray;
		
		for(T i : array) {
			if(i.compareTo(menor) < 0 && i.compareTo(menorAnterior) > 0) {
				menor = i;
			}
			
		}
		if(k == 1) {
			return menor;
		} else {
			return getOrderStatistics(array, k-1, maiorDoArray, menor);
		}
		
	}

}
