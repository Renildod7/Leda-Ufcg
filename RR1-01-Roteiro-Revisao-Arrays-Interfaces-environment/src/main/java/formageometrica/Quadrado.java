package formageometrica;

public class Quadrado implements FormaGeometrica{
	
	private double lado;
	
	public Quadrado(double lado) {
		this.lado = lado;
	}
	
	public double calculaArea() {
		return this.lado * this.lado;
	}
}
