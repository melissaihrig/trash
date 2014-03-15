package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;

/* Solo deja recibir una carta si: 
 *   - no hay carta en el espacio que se quiere agregar la carta
 *   - si la carta que se quiere agregar es mayor en 1 que la carta que está en el espacio,
 *   tienen que ser del mismo palo
 *   - si la carta que se quiere agregar es menor en 1 que la carta que está en el espacio,
 *   tienen que ser del mismo palo 
 *   
 * Deja sacar la carta en cualquier caso.
 */

public class PilaDeRelaciones extends Pila {

	public PilaDeRelaciones(int fila, int columna) {
		super(fila, columna);
	}

	@Override
	public void verificarRecibirCarta(Pila origen) throws CartaException {
		
		verificarSiEsOtraPilaDeRelaciones( origen );
		
		if ( this.estaVacio() ) 
			return;
		
		Carta cartaDeArriba = this.getUltimaCarta();
		Carta cartaAAgregar = origen.getUltimaCarta();
		
		verificarSiMismoPalo( cartaDeArriba, cartaAAgregar );
		
		/* es la carta inmediatamente superior/inferior de la carta de más arriba */
		if ( Math.abs( cartaDeArriba.getValor() - cartaAAgregar.getValor() ) != 1 ) 
			throw new CartaException("No se puede agregar la carta porque no son inmediatamente consecuentes. Carta de arriba: " + cartaDeArriba.toString() + " carta a agregar: " + cartaAAgregar.toString() );		
	}

	private void verificarSiEsOtraPilaDeRelaciones(Pila origen) throws CartaException {
		
		if ( this.estaVacio() && (origen.getFila() == 0 || origen.getFila() == 2))
			throw new CartaException("Movimiento inválido.");		
	}

	@Override
	public void verificarSacarUltimaCarta(Pila pilaDestino) throws CartaException {
		return;
	}

	



}
