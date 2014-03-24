package regiment.vista;

import java.awt.Point;

import regiment.modelo.Pila;

public class PilaEscaleraArriba extends PilaEscalera {
	
	public PilaEscaleraArriba(Pila pila) {
		super(pila);
	}
		
	protected void reposicionar() {
		
		int y = this.getPunto().y;
		int x = this.getPunto().x;
		
		for (CartaRegiment carta: this.getCartas()) 
		{ 
			carta.setLocation(new Point(x, y));
			carta.setPosicionAnterior(new Point(x, y));

			y -= DIST_Y;
		}
	}
	
	protected void setAlto(CartaRegiment carta) {
		this.alto = this.getPunto().y - carta.getY();
	}
	
	boolean estaDentroDeLaPila( int x, int y ) {
		
		int puntoX = this.getPunto().x;
		int puntoY = this.getPunto().y;
		int ancho = this.getFondo().getWidth();
		int alto = this.getFondo().getHeight();
		
		int minX = puntoX - TableroGrafico.MARGEN_CASILLA;
		int maxX = puntoX + ancho  + TableroGrafico.MARGEN_CASILLA;
		int minY = puntoY - this.alto - TableroGrafico.MARGEN_CASILLA;
		int maxY = puntoY + alto + TableroGrafico.MARGEN_CASILLA; 
		
		return (x >= minX && x <= maxX && y >= minY && y <= maxY);
	}
}
