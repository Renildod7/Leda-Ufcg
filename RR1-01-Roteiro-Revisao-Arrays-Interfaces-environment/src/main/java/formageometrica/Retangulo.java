package formageometrica;

public class Retangulo implements FormaGeometrica{
	
	private double base;
	private double altura;
	
	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public double calculaArea() {
		return this.base * this.altura;
	}

}
