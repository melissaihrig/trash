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
}
