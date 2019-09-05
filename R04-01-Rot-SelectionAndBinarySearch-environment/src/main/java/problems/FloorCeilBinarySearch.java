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
		
		if(leftIndex == rightIndex){
			
			if(array[leftIndex] < x) {
				return array[leftIndex];
			
			}else {
				return null;
			}
			
		}
		
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			
			int meio = (leftIndex + rightIndex) / 2;
			
			if(array[meio] == x) {
				return array[meio-1];
				
			}else if(array[meio] < x) {
				return floor(array, x, meio + 1, rightIndex, array[meio]);
				
			}else {
				return floor(array, x, leftIndex, meio -1);
			}
			
		}else {
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
		return ceil(array, x, 0, array.length-1);
	}

	private Integer ceil(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		
		if(leftIndex == rightIndex){
			
			if(array[leftIndex] > x) {
				return array[leftIndex];
			
			}else {
				return null;
			}
			
		}
		
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			
			int meio = (leftIndex + rightIndex) / 2;
			
			if(array[meio] == x) {
				return array[meio+1];
				
			}else if(array[meio] > x) {
				return ceil(array, x, leftIndex, meio-1, array[meio]);
				
			}else {
				return ceil(array, x, meio+1, rightIndex);
			}
			
		}else {
			return null;
		}
		
	}

	private Integer ceil(Integer[] array, Integer x, int leftIndex, int rightIndex, int maiorAtual) {
		
		if(leftIndex == rightIndex) {
			
			if(array[leftIndex] > x) {
				return array[leftIndex];
			
			}else {
				return maiorAtual;
			}
		}
		
		int meio = (leftIndex + rightIndex) / 2;
		
		if(array[meio] == x) {
			return array[meio+1];
			
		}else if(array[meio] > x) {
			return floor(array, x, leftIndex, meio-1, array[meio]);
		
		}else {
			return floor(array, x, meio+1, rightIndex, maiorAtual);
		}
		
		
	}

}