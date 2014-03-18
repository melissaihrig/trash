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

	@Override
	public void verificarSacarUltimaCarta(Pila pilaDestino) throws CartaException {

		int colMazoOrigen = this.getColumna(), colMazoDestino = pilaDestino.getColumna();
		int columnaInicial = ( colMazoOrigen < colMazoDestino )? colMazoOrigen: colMazoDestino;
		int columnaFinal = ( colMazoOrigen > colMazoDestino )? colMazoOrigen: colMazoDestino;
		
		verSiLugaresVacios(columnaInicial, columnaFinal);
		
	}

	private void verSiLugaresVacios(int columnaInicial, int columnaFinal) throws CartaException 
	{
		for ( int columna = columnaInicial; columna <= columnaFinal; columna++ ) 
		{
			boolean vacio1 = subtablero.getPila(0, columna).estaVacio();
			boolean vacio2 = subtablero.getPila(2, columna).estaVacio();
			
			if ( !( vacio1 || vacio2 ) ) 
				throw new CartaException("No se puede realizar el movimiento");
			
		}
	}

}
