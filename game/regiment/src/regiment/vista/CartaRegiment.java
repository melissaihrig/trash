package regiment.vista;

import modelo.Carta;
import vista.carta.CartaInglesaGrafica;

@SuppressWarnings("serial")
public class CartaRegiment extends CartaInglesaGrafica {

	private PilaGrafica pila;
	private int orden = 0;
	
	public CartaRegiment(Carta carta, PilaGrafica pila) {
		super(carta);
		this.pila = pila;
	}

	public PilaGrafica getPila() {
		return pila;
	}

	void setPila(PilaGrafica pilaGrafica) {
		this.pila = pilaGrafica;
		
	}

	int getOrden() {
		return orden;
	}

	void setOrden(int orden) {
		this.orden = orden;
	}
}
