package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

/* Se puede colocar una carta en esta pila si:  
 *   - no hay carta en el espacio que se quiere agregar la carta y la que se va a agregar es un As
 *   - si la carta que se quiere agregar es mayor en 1 que la carta que está en el espacio,
 *   tienen que ser del mismo palo
 *   
 * No deja sacar una carta en ningún caso
 */

public class PilaDeAses extends PilaDeAcumulacionConPalo {
	
	public PilaDeAses(int fila, int columna, PaloDeCartaInglesa palo) {
		super(fila, columna, palo);
	}

	@Override
	public void verificarRecibirCarta(Pila origen) throws CartaException {
		
		Carta cartaAAgregar = origen.getUltimaCarta();
		
		if (!esDelMismoPalo(cartaAAgregar))
			throw new CartaException("Se esperaba una carta de " + this.getPalo());
		
		if ( this.estaVacia() ) 
		{
			if ( cartaAAgregar.getValor() != As )
				throw new CartaException("Se esperaba un As de " + cartaAAgregar.getPaloDeCarta());
		
			return;
		}
		
		Carta cartaDeArriba = this.getUltimaCarta();
		
		verificarSiMismoPalo( cartaDeArriba, cartaAAgregar );
		
		if ( cartaDeArriba.getValor() - cartaAAgregar.getValor() != -1 ) 
			throw new CartaException("Se esperaba un " + (cartaDeArriba.getValor() + 1) + " de " + cartaDeArriba.getPaloDeCarta());		
	}

	@Override
	public void verificarSacarUltimaCarta(Pila pilaDestino) throws CartaException {
		throw new CartaException("No se puede sacar la carta de esta pila");
	}
}
