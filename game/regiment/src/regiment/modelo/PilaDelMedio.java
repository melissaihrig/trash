package regiment.modelo;

import regiment.modelo.TableroRegiment.Subtablero;
import modelo.CartaException;

public class PilaDelMedio extends Pila {

	private Subtablero subtablero;

	public PilaDelMedio(Subtablero subtablero, int fila, int columna) {
		super(fila, columna);
		this.subtablero = subtablero;
	}

	@Override
	public void verificarRecibirCarta(Pila origen) throws CartaException {
		throw new CartaException("No se puede colocar una carta acá");
		
	}
	
	//si el destino es una pila de acumulacion -> exception
	//si destino es arriba y está vacío, ok
	//si destino es abajo y está vacío, ok
	//si destino es arriba de otra col, está vacía la columnas del medio
	@Override
	public void verificarSacarUltimaCarta(Pila pilaDestino) throws CartaException {

		/*una carta del medio solo puede ir a alguna pila de arriba o a una de abajo*/
		if (pilaDestino.esPilaAcumulacion())
			throw new CartaException("Movimiento inválido");
		
		/*si no va al tablero secundario el destino tiene que estar vacío*/
		if (!pilaDestino.estaVacia())
			throw new CartaException("Lugar ocupado");
		
		/*si la columna no es la misma que esta pila tengo que ver que 
		 * las pilas del medio intermedias estén vacías*/ 
		if (!(pilaDestino.getColumna() == this.getColumna())) {
			verificarColumnaDistintaLugaresVacios(pilaDestino);
		}
	}

	private void verificarColumnaDistintaLugaresVacios(Pila pilaDestino) throws CartaException 
	{
		int colMazoOrigen = this.getColumna(), colMazoDestino = pilaDestino.getColumna();
		int columnaInicial = ( colMazoOrigen < colMazoDestino )? colMazoOrigen + 1: colMazoDestino;
		int columnaFinal = ( colMazoOrigen > colMazoDestino )? colMazoOrigen - 1: colMazoDestino;
		
		for ( int columna = columnaInicial; columna <= columnaFinal; columna++ ) 
		{
			if ( !subtablero.getPila(1, columna).estaVacia() ) 
				throw new CartaException("No se puede realizar el movimiento");
			
		}
	}

}
