package problems;


/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima estatistica de ordem 
 * da uniao ordenada deles. 
 * 
 * Restricoes:
 * - os arrays nao possuem elementos em comum e nem repetidos
 * - k eh um numero compreendido entre 1 e array1.length + array2.length
 * - caso o k-esima estatistica de ordem nao exista, o metodo deve retornar null
 * - voce nao pode usar memoria extra
 * - seu algoritmo deve ter complexidade O(array1.length + array2.length). 
 * - voce nao pode usar nenhum metodo pronto de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {
	public T statisticsOrder(T[] array1, T[] array2, int k) {
		
		if(k > 0 && k <= (array1.length + array2.length)) {
			
			T menor = array1[0];
			
			boolean encontrou = false;
			
			int i = 0; // Usado como indice na iteracao do primeiro array.
			int j = 0; // Usado como indice na iteracao do segundo array.
			
			
			// Existem elementos nos dois arrays que nao foram verificados
			// e a estatistica de ondem nao foi encontrda.
			
			while(i < array1.length && j < array2.length && !encontrou) {
				
				if(array1[i].compareTo(array2[j]) < 0) {
					menor = array1[i];
					i++;
					
				} else {
					menor = array2[j];
					j++;
				}
				
				if(k == 1) {
					encontrou = true;
				} else {
					k--;
				}
			}
			
			// Todos os elemntos do segundo array foram verificados 
			// e a estatistica de ordem nao foi encontrada.
			
			while(i < array1.length && !encontrou) {
				menor = array1[i];
				i++;
				
				if(k == 1) {
					encontrou = true;
				} else {
					k--;
				}
			}
			
			// Todos os elemntos do primeiro array foram verificados 
			// e a estatistica de ordem nao foi encontrada.
			while(j < array2.length && !encontrou) {
				menor = array2[j];
				j++;
				
				if(k == 1) {
					encontrou = true;
				} else {
					k--;
				}
			}
			
			if(encontrou) {
				return menor;
			} else {
				return null;
			}
			
			
			
		} else {
			return null;
		}
	
	}
	
	
}
