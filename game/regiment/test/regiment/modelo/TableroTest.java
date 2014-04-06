package regiment.modelo;

import static org.junit.Assert.assertTrue;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

import org.junit.Test;

import regiment.modelo.Pila;
import regiment.modelo.TableroRegiment;

public class TableroTest {

	/* Prueba: 
	 * 	mando una carta que se encuentra en la posición (1,0) (fila del medio) a
	 * 	la pila (0,7)
	 * 	el resto de las pilas están vacías.
	 * 
	 * 
	 * Resultado:
	 * 	el movimiento puede realizarse.*/
	@Test
	public void testMovimientoMedioPilaVacia() throws CartaException {
		TableroRegiment tablero = new TableroRegiment();
		
		tablero.subtableroPpal.setCarta(1, 0, new Carta(7, PaloDeCartaInglesa.DIAMANTE));
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(1, 0);
		Pila mazoDestino = tablero.subtableroPpal.getPila(0, 7);

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		assertTrue( mazoOrigen.getCantidadDeCartas() == 0 );	
	}
	
	/* Prueba: 
	 * 	mando una carta que se encuentra en la posición (1,0) (fila del medio) a
	 * 	la pila (0,7)
	 * 	la pila del medio (1,4) se encuentra ocupada
	 * 
	 * 
	 * Resultado:
	 * 	el movimiento no puede realizarse.*/
	@Test (expected = CartaException.class) 
	public void testMovimientoMedioPilaLlena() throws CartaException {
		TableroRegiment tablero = new TableroRegiment();
		
		tablero.subtableroPpal.setCarta(1, 0, new Carta(7, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(8, PaloDeCartaInglesa.DIAMANTE));
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(1, 0);
		Pila mazoDestino = tablero.subtableroPpal.getPila(0, 7);

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		assertTrue( mazoOrigen.getCantidadDeCartas() == 1 );	
	}
	
	/* Prueba: 
	 * 	me fijo si teniendo una K de trebol en el trablero perdió el juego
	 * 
	 * Resultado:
	 * 	no perdió*/
	@Test
	public void testVerificarSiSePerdio() throws CartaException {
		TableroRegiment tablero = new TableroRegiment();
		
		tablero.subtableroPpal.setCarta(0, 0, new Carta(13, PaloDeCartaInglesa.TREBOL));
		
		assertTrue( tablero.perdioElJuego() == false );	
	}
	
	/* Prueba: 
	 * 	me fijo si teniendo una K de trebol en el trablero  principal si perdió el juego. 
	 * Además, de que en el tablero de acumulación ya está la K de trebol colocada
	 * 
	 * Resultado:
	 * 	perdió*/
	@Test
	public void testVerificarSiSePerdioDosKes() throws CartaException {
		TableroRegiment tablero = new TableroRegiment();
		
		tablero.subtableroPpal.setCarta(0, 0, new Carta(13, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroSec.setCarta(2, 1, new Carta(13, PaloDeCartaInglesa.TREBOL));
		
		assertTrue( tablero.perdioElJuego() == true );	
	}
}
