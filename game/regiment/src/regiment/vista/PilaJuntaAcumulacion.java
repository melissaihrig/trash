package regiment.vista;

import modelo.CartaException;
import modelo.PaloDeCarta;
import modelo.PaloDeCartaInglesa;
import regiment.modelo.Pila;

public class PilaJuntaAcumulacion extends PilaJunta {

	private PaloDeCartaInglesa palo;
	
	public PilaJuntaAcumulacion(Pila pila, PaloDeCartaInglesa palo) {
		super(pila);
		this.palo = palo;
		this.cambiarPathIcono(palo);
	}
	
	private void cambiarPathIcono(PaloDeCartaInglesa palo) {
		String path = palo.name().toLowerCase().substring(0, 1) + ".png";
		super.setPath(path);
	}
	
	public PaloDeCarta getPalo() {
		return palo;
	}
	
	void moverCarta(CartaRegiment carta) throws CartaException {
		
		if (carta.getCarta().getPaloDeCarta() != palo)
			throw new CartaException("Movimiento inválido");
		
		super.moverCarta(carta);
	}
}
