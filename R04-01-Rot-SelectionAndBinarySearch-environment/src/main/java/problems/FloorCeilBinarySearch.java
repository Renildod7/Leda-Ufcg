package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return floor(array, x, 0, array.length-1);
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			
			int meio = (leftIndex + rightIndex) / 2;
			
			if(array[meio] == x) {
				return array[meio-1];
				
			}else if(array[meio] < x) {
				return floor(array, x, meio + 1, rightIndex, array[meio]);
				
			}else {
				return floor(array, x, leftIndex, meio -1);
			}
		
		} else {
			return null;
		}
		
	}

	private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex, int menorAtual) {
		
		
		if(leftIndex == rightIndex) {
			
			if(array[leftIndex] < x) {
				return array[leftIndex];
			
			}else {
				return menorAtual;
			}
		}
		
		
		
			
		int meio = (leftIndex + rightIndex) / 2;
		
		if(array[meio] == x) {
			return array[meio-1];
			
		}else if(array[meio] < x) {
			return floor(array, x, meio + 1, rightIndex, array[meio]);
		
		}else {
			return floor(array, x, leftIndex, meio-1, menorAtual);
		}
			

	}
	
	
	
	

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		// TODO implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
