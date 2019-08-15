package formageometrica;

public class Circulo implements FormaGeometrica{
	
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double calculaArea() {
		return Math.PI * this.raio * this.raio;
	}

}
