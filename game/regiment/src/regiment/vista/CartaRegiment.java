package regiment.vista;

import modelo.Carta;
import vista.carta.CartaInglesaGrafica;

@SuppressWarnings("serial")
public class CartaRegiment extends CartaInglesaGrafica {

	private PilaGrafica pila;
	
	public CartaRegiment(Carta carta, PilaGrafica pila) {
		super(carta);
		this.pila = pila;
	}

	public PilaGrafica getPila() {
		return pila;
	}
}
