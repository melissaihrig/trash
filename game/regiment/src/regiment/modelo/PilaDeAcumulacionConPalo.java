package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

public abstract class PilaDeAcumulacionConPalo extends Pila {
	
	private PaloDeCartaInglesa palo;

	public PilaDeAcumulacionConPalo(int fila, int columna, PaloDeCartaInglesa palo) {
		super(fila, columna);
		this.palo = palo;
	}

	protected boolean esDelMismoPalo(Carta carta) throws CartaException {
		if ( this.palo != carta.getPaloDeCarta()) 
			throw new CartaException("Tienen que ser del mismo palo.");
		
		return true;
	}

	final protected boolean esPilaAcumulacion() {
		return true;
	}
	
	public PaloDeCartaInglesa getPalo() {
		return palo;
	}

}
