package regiment.vista;

import java.awt.Point;

import regiment.modelo.Pila;

public class PilaEscaleraAbajo extends PilaEscalera{

	public PilaEscaleraAbajo(Pila pila) {
		super(pila);
	}
	
	protected void reposicionar() {
		
		int y = this.getPunto().y;
		int x = this.getPunto().x;
		
		for (CartaRegiment carta: this.getCartas()) 
		{ 
			carta.setLocation(new Point(x, y));
			carta.setPosicionAnterior(new Point(x, y));
			y += DIST_Y;
		}
	}
	
	protected void setAlto(CartaRegiment carta) {
		this.alto = carta.getHeight() + carta.getY() - this.getPunto().y;
	}
}
