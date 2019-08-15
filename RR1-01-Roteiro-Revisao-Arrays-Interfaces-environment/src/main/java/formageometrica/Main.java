package formageometrica;

public class Main {
 
	public Main() {
		FormaGeometrica q = new Quadrado(5);
		FormaGeometrica r = new Retangulo(5, 10);
		FormaGeometrica t = new Triangulo(5, 10);
		FormaGeometrica c = new Circulo(15);
		
		System.out.println(q.calculaArea());
		System.out.println(r.calculaArea());
		System.out.println(t.calculaArea());
		System.out.println(c.calculaArea());
	}
}
