package problems;

import static org.junit.jupiter.api.Assertions.*;

class Test {
	
	OrderStatisticsSortedUnion<Integer> ossuInt = new OrderStatisticsSortedUnion<>();
	OrderStatisticsSortedUnion<String> ossuStr = new OrderStatisticsSortedUnion<>();
	OrderStatisticsSortedUnion<Comparavel> ossuEnum = new OrderStatisticsSortedUnion<>();
	
	
	Integer[] arrayInt1 = new Integer[] {1,3,5,7,9,11,13,15,17,19};
	Integer[] arrayInt2 = new Integer[] {2,4,6,8,10,12,14,16,18,20};
	
	String[] arrayStr1 = new String[] {"a", "c", "e","g","i","m"};
	String[] arrayStr2 = new String[] {"b","d", "f","h","l","n"};
	
	Comparavel[] arrayEnum1 = new Comparavel[] {Comparavel.PRIMEIRO, Comparavel.TERCEIRO,
												Comparavel.QUINTO, Comparavel.SETIMO,
												Comparavel.NONO};
	Comparavel[] arrayEnum2 = new Comparavel[] {Comparavel.SEGUNDO, Comparavel.QUARTO,
												Comparavel.SEXTO, Comparavel.OITAVO,
												Comparavel.DECIMO};
	
	
	
	
	// Testes com array de Integer
	
	
	@org.junit.jupiter.api.Test
	void testInteger1() {
		Integer v = new Integer(5);
		
		// primeiro array1 depois array2
		assertEquals(v, ossuInt.statisticsOrder(arrayInt1, arrayInt2, 5));
		
		// primeiro array2 depois array1
		assertEquals(v, ossuInt.statisticsOrder(arrayInt2, arrayInt1, 5));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger2() {
		Integer v = new Integer(10);
		
		// primeiro array1 depois array2
		assertEquals(v, ossuInt.statisticsOrder(arrayInt1, arrayInt2, 10));
		
		// primeiro array2 depois array1
		assertEquals(v, ossuInt.statisticsOrder(arrayInt2, arrayInt1, 10));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger3() {
		Integer v = new Integer(20);
		
		// primeiro array1 depois array2
		assertEquals(v, ossuInt.statisticsOrder(arrayInt1, arrayInt2, 20));
		
		// primeiro array2 depois array1
		assertEquals(v, ossuInt.statisticsOrder(arrayInt2, arrayInt1, 20));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger4() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuInt.statisticsOrder(arrayInt1, arrayInt2, 100));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuInt.statisticsOrder(arrayInt2, arrayInt1, 100));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger5() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuInt.statisticsOrder(arrayInt1, arrayInt2, -10));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuInt.statisticsOrder(arrayInt2, arrayInt1, -10));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger6() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuInt.statisticsOrder(arrayInt1, arrayInt2, 0));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuInt.statisticsOrder(arrayInt2, arrayInt1, 0));
		
	}
	
	@org.junit.jupiter.api.Test
	void testInteger() {
		Integer i = new Integer(0);
		Integer k = new Integer(1);
		Integer j = new Integer(this.arrayInt1.length + this.arrayInt2.length);
		
		
		for(i = k; i < j; i+=k) {
			assertEquals(i ,ossuInt.statisticsOrder(arrayInt2, arrayInt1, i));
			
			assertEquals(i ,ossuInt.statisticsOrder(arrayInt1, arrayInt2, i));
		}
	}
	
	
	
	
	
	
	
	
	// Testes com array de String
	
	@org.junit.jupiter.api.Test
	void testString1() {
		
		// primeiro array1 depois array2
		assertEquals("a", ossuStr.statisticsOrder(arrayStr1, arrayStr2, 1));
		
		// primeiro array2 depois array1
		assertEquals("a", ossuStr.statisticsOrder(arrayStr2, arrayStr1, 1));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString2() {
		
		// primeiro array1 depois array2
		assertEquals("l", ossuStr.statisticsOrder(arrayStr1, arrayStr2, 10));
		
		// primeiro array2 depois array1
		assertEquals("l", ossuStr.statisticsOrder(arrayStr2, arrayStr1, 10));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString3() {
		
		// primeiro array1 depois array2
		assertEquals("e", ossuStr.statisticsOrder(arrayStr1, arrayStr2, 5));
		
		// primeiro array2 depois array1
		assertEquals("e", ossuStr.statisticsOrder(arrayStr2, arrayStr1, 5));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString4() {
		
		// primeiro array1 depois array2
		assertEquals("b", ossuStr.statisticsOrder(arrayStr1, arrayStr2, 2));
		
		// primeiro array2 depois array1
		assertEquals("b", ossuStr.statisticsOrder(arrayStr2, arrayStr1, 2));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString5() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuStr.statisticsOrder(arrayStr1, arrayStr2, 100));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuStr.statisticsOrder(arrayStr2, arrayStr1, 100));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString6() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuStr.statisticsOrder(arrayStr1, arrayStr2, -10));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuStr.statisticsOrder(arrayStr2, arrayStr1, -10));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString7() {
		// estatistica de ordem invalida
		
		// primeiro array1 depois array2
		assertEquals(null, ossuStr.statisticsOrder(arrayStr1, arrayStr2, 0));
		
		// primeiro array2 depois array1
		assertEquals(null, ossuStr.statisticsOrder(arrayStr2, arrayStr1, 0));
		
	}
	
	@org.junit.jupiter.api.Test
	void testString() {

	
		String[] s = new String[] {"a", "b", "c", "d","e", "f", "g", "h","i","l","m","n"};
		
		Integer i = new Integer(0);
		Integer k = new Integer(1);
		Integer j = new Integer(this.arrayStr1.length + this.arrayStr2.length);
		
		for(i = k; i<j; i+=k) {
			
			// i-1 porque o array começa de 0

			assertEquals(s[i-1], ossuStr.statisticsOrder(arrayStr1, arrayStr2, i));
			
			assertEquals(s[i-1], ossuStr.statisticsOrder(arrayStr2, arrayStr1, i));
		}
		
	}
	
	
	
	
	
	
	
	// Testes com Array de Enum
	
	
	@org.junit.jupiter.api.Test
	void testEnum1() {
		
		Comparavel[] array = new Comparavel[] {Comparavel.PRIMEIRO, Comparavel.SEGUNDO,
													Comparavel.TERCEIRO, Comparavel.QUARTO,
													Comparavel.QUINTO, Comparavel.SEXTO,
													Comparavel.SETIMO, Comparavel.OITAVO,
													Comparavel.NONO, Comparavel.DECIMO};
		
		Integer i = new Integer(0);
		Integer k = new Integer(1);
		Integer j = new Integer(this.arrayEnum1.length + this.arrayEnum2.length);
		
		for(i = k; i < j; i+=k) {
			
			// i-1 porque o array começa de 0
			
			// primeiro array1 depois array2
			assertEquals(array[i-1], ossuEnum.statisticsOrder(arrayEnum1, arrayEnum2, i));
			
			// primeiro array2 depois array1
			assertEquals(array[i-1], ossuEnum.statisticsOrder(arrayEnum2, arrayEnum1, i));
			
		}
		
		
	}
	

}
