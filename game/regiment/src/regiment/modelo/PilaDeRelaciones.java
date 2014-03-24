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

		/*no puedo recibir una carta de la pila de acumulación*/
		verificarSiEsPilaAcumulacion( origen );

		if (esPilaDelMedio(origen)) 
		{
			if (!this.estaVacia()) {
				/* si es la pila del medio, solo puede colocar una carta si la pila
				 * esta vacía*/
				throw new CartaException("Lugar ocupado");
			}
		}
		else 
		{
			/*no es una pila ni del medio ni de acumulación => es una pila  
			 *de relación*/
			if (this.estaVacia()) {
				/*si está vacía no puedo colocar una carta que sea de otra pila
				 * de relación*/
				throw new CartaException("Movimiento inválido");
			} 
			else {
				Carta cartaDeArriba = this.getUltimaCarta();
				Carta cartaAAgregar = origen.getUltimaCarta();
				
				verificarSiMismoPalo( cartaDeArriba, cartaAAgregar );
				
				/* es la carta inmediatamente superior/inferior de la carta de más arriba */
				if ( Math.abs( cartaDeArriba.getValor() - cartaAAgregar.getValor() ) != 1 ) 
					throw new CartaException("No se puede agregar la carta porque no son inmediatamente consecuentes. Carta de arriba: " + cartaDeArriba.toString() + " carta a agregar: " + cartaAAgregar.toString() );				
			}
		}
		
	}

	private void verificarSiEsPilaAcumulacion(Pila origen) throws CartaException {
		if (origen.esPilaAcumulacion())
			throw new CartaException("Movimiento inválido");
	}

	private boolean esPilaDelMedio(Pila origen) {
		return origen.getFila() == 1;
	}
	@Override
	public void verificarSacarUltimaCarta(Pila pilaDestino) throws CartaException {
		return;
	}
}
