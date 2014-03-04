package regiment.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

import org.junit.Before;
import org.junit.Test;

import regiment.modelo.Pila;
import regiment.modelo.TableroRegiment;

/*
 * TABLERO DE PRUEBA
 * 
 * Arriba 
 [Valor: 1 Palo: DIAMANTE] [Valor: 8 Palo: DIAMANTE] [Valor: 2 Palo: CORAZON] [Valor: 12 Palo: TREBOL] [Valor: 7 Palo: DIAMANTE] [Valor: 10 Palo: CORAZON] [Valor: 10 Palo: PICA] [Valor: 1 Palo: PICA]
 
 Medio 
 [Valor: 3 Palo: DIAMANTE, Valor: 1 Palo: CORAZON, Valor: 10 Palo: CORAZON, Valor: 12 Palo: PICA, Valor: 12 Palo: DIAMANTE, Valor: 7 Palo: PICA, Valor: 9 Palo: CORAZON, Valor: 1 Palo: TREBOL, Valor: 11 Palo: TREBOL, Valor: 8 Palo: CORAZON, Valor: 12 Palo: DIAMANTE]
 [Valor: 7 Palo: TREBOL, Valor: 9 Palo: DIAMANTE, Valor: 6 Palo: TREBOL, Valor: 6 Palo: CORAZON, Valor: 3 Palo: TREBOL, Valor: 9 Palo: CORAZON, Valor: 5 Palo: DIAMANTE, Valor: 3 Palo: CORAZON, Valor: 13 Palo: DIAMANTE, Valor: 10 Palo: PICA, Valor: 13 Palo: PICA]
 [Valor: 4 Palo: CORAZON, Valor: 1 Palo: TREBOL, Valor: 11 Palo: DIAMANTE, Valor: 4 Palo: TREBOL, Valor: 13 Palo: PICA, Valor: 1 Palo: PICA, Valor: 3 Palo: TREBOL, Valor: 12 Palo: CORAZON, Valor: 6 Palo: DIAMANTE, Valor: 10 Palo: DIAMANTE, Valor: 11 Palo: CORAZON]
 [Valor: 8 Palo: TREBOL, Valor: 7 Palo: PICA, Valor: 5 Palo: PICA, Valor: 4 Palo: PICA, Valor: 2 Palo: PICA, Valor: 8 Palo: PICA, Valor: 2 Palo: TREBOL, Valor: 8 Palo: PICA, Valor: 8 Palo: CORAZON, Valor: 9 Palo: PICA, Valor: 12 Palo: PICA]
 [Valor: 3 Palo: CORAZON, Valor: 5 Palo: CORAZON, Valor: 5 Palo: TREBOL, Valor: 12 Palo: CORAZON, Valor: 13 Palo: DIAMANTE, Valor: 4 Palo: DIAMANTE, Valor: 2 Palo: TREBOL, Valor: 11 Palo: CORAZON, Valor: 13 Palo: TREBOL, Valor: 7 Palo: TREBOL, Valor: 3 Palo: PICA]
 [Valor: 13 Palo: CORAZON, Valor: 5 Palo: PICA, Valor: 6 Palo: TREBOL, Valor: 6 Palo: DIAMANTE, Valor: 1 Palo: DIAMANTE, Valor: 2 Palo: PICA, Valor: 10 Palo: DIAMANTE, Valor: 9 Palo: DIAMANTE, Valor: 4 Palo: TREBOL, Valor: 4 Palo: PICA, Valor: 6 Palo: PICA]
 [Valor: 10 Palo: TREBOL, Valor: 9 Palo: PICA, Valor: 13 Palo: TREBOL, Valor: 2 Palo: DIAMANTE, Valor: 11 Palo: TREBOL, Valor: 7 Palo: CORAZON, Valor: 9 Palo: TREBOL, Valor: 5 Palo: CORAZON, Valor: 2 Palo: CORAZON, Valor: 4 Palo: DIAMANTE, Valor: 2 Palo: DIAMANTE]
 [Valor: 8 Palo: TREBOL, Valor: 5 Palo: TREBOL, Valor: 12 Palo: TREBOL, Valor: 7 Palo: CORAZON, Valor: 5 Palo: DIAMANTE, Valor: 11 Palo: DIAMANTE, Valor: 4 Palo: CORAZON, Valor: 11 Palo: PICA, Valor: 10 Palo: TREBOL, Valor: 1 Palo: CORAZON, Valor: 7 Palo: DIAMANTE]

 Bajo 
 [Valor: 3 Palo: PICA] [Valor: 6 Palo: PICA] [Valor: 13 Palo: CORAZON] [Valor: 9 Palo: TREBOL] [Valor: 11 Palo: PICA] [Valor: 3 Palo: DIAMANTE] [Valor: 6 Palo: CORAZON] [Valor: 8 Palo: DIAMANTE]
 */

public class TableroTest {

	private TableroRegiment tablero;
	
	/* Genera el tablero de prueba respetando la especificación de arriba */
	@Before
    public void setUp() throws Exception {
		
		tablero = new TableroRegiment();
		
		try {
			this.setCartasDeArriba();
			this.setCartasDeAbajo();
			this.setCartasDelMedio();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Test  
	public void testInicializacionDeTablero() throws CartaException  {
		
		assertTrue( tablero.subtableroPpal.getPila(0, 0).getUltimaCarta().getValor() == 1 );
		assertTrue( tablero.subtableroPpal.getPila(0, 0).getUltimaCarta().getPaloDeCarta() ==  PaloDeCartaInglesa.DIAMANTE );
	}
	
	/* Prueba: 
	 * 	intento colocar el As de diamanete que se encuentra en la posicón (0,0) arriba
	 * 	del 8 de diamanete que se encuentra en la posición (0,1). 
	 * 
	 * Resultado:
	 * 	el movimiento no puede realizarse ya que arriba del 8 de diamente solo se puede
	 * 	colocar un 9 ó un 7 de diamante*/
	
	@Test (expected = CartaException.class) 
	public void testMoviementoErroneo1a8MismoPalo() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(0, 0);
		Carta diamante_as = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroPpal.getPila(0, 1);
		Carta diamante_8 = mazoDestino.getUltimaCarta();
		
		assertTrue( diamante_as.equals( new Carta( 1, PaloDeCartaInglesa.DIAMANTE ) ) );
		assertTrue( diamante_8.equals( new Carta( 8, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
	}
	
	/* Prueba: 
	 * 	intento colocar el 10 de pica que se encuentra en la posicón (0,6) arriba
	 * 	de la J de pica que se encuentra en la posición (0,4). 
	 * 
	 * Resultado:
	 * 	el movimiento puede realizarse ya que arriba de la J puede colocarse un 10
	 * 	ó una Q de pica*/
	
	@Test 
	public void testMoviementoCorrecto10alJMismoPalo() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(0, 6);
		Carta pica_10 = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroPpal.getPila(2, 4);
		Carta pica_11 = mazoDestino.getUltimaCarta();
		
		assertTrue( pica_10.equals( new Carta( 10, PaloDeCartaInglesa.PICA ) ) );
		assertTrue( pica_11.equals( new Carta( 11, PaloDeCartaInglesa.PICA ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		
		assertTrue( mazoDestino.getCantidadDeCartas() == 2 );
		assertTrue( mazoOrigen.getCantidadDeCartas() == 0 );
	}

	/* Prueba: 
	 * 	intento colocar el 8 de diamanete que se encuentra en la posicón (0,1) en el
	 * 	tablero secundario donde se juntan las cartas en orden creciente. 
	 * 
	 * Resultado:
	 * 	el movimiento no puede realizarse ya que al estar vacío el mazo correspondiente
	 *  solo acepta un As */
	
	@Test (expected = CartaException.class) 
	public void testMoviementoIncorrecto8alTableroSec() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(0, 1);
		Carta diamante_8  = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroSec.getPila(0, 0);
		
		assertTrue( diamante_8.equals( new Carta( 8, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		
		assertFalse( tablero.subtableroPpal.getPila(0, 1).getCantidadDeCartas() == 0 );
	}

	/* Prueba: 
	 * 	intento colocar el As de diamanete que se encuentra en la posicón (0,0) en el
	 * 	tablero secundario donde se juntan las cartas en orden creciente. 
	 * 
	 * Resultado:
	 * 	el movimiento puede realizarse ya que al estar vacío el mazo correspondiente
	 *  solo acepta un As */
	
	@Test 
	public void testMoviementoCorrectoAsalTableroSec() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(0, 0);
		Carta pica_AS = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroSec.getPila(0, 0);
		
		assertTrue( pica_AS.equals( new Carta( 1, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		
		assertTrue( mazoOrigen.getCantidadDeCartas() == 0 );
		assertTrue( mazoDestino.getCantidadDeCartas() == 1 );
	}
	
	/* Prueba: 
	 * 	intento colocar el 3 de pica que se encuentra en la posicón (2,0) en el
	 * 	tablero secundario donde se juntan las cartas en orden decreciente. 
	 * 
	 * Resultado:
	 * 	el movimiento no puede realizarse ya que al estar vacío el mazo correspondiente
	 *  solo acepta una K */
	
	@Test (expected = CartaException.class) 
	public void testMoviementoIncorrecto3alTableroSec() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(2, 0);
		Carta pica_3 = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroSec.getPila(0, 0);
		
		assertTrue( pica_3.equals( new Carta( 3, PaloDeCartaInglesa.PICA ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		
		assertTrue( mazoOrigen.getCantidadDeCartas() == 0 );
		assertTrue( mazoDestino.getCantidadDeCartas() == 1 );
	}

	/* Prueba: 
	 * 	intento colocar la K de corazón que se encuentra en la posicón (2,2) en el
	 * 	tablero secundario donde se juntan las cartas en orden decreciente. 
	 * 
	 * Resultado:
	 * 	el movimiento puede realizarse ya que al estar vacío el mazo correspondiente
	 *  solo acepta una K */
	
	@Test 
	public void testMoviementoCorrectoKalTableroSec() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(2, 2);
		Carta corazon_K = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroSec.getPila(0, 1);
		
		assertTrue( corazon_K.equals( new Carta( 13, PaloDeCartaInglesa.CORAZON ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
		
		assertTrue( mazoOrigen.getCantidadDeCartas() == 0 );
		assertTrue( mazoDestino.getCantidadDeCartas() == 1 );
	}
	
	/* Prueba: 
	 * 	intento colocar el 2 de diamanete que se encuentra en la posicón (1,6), es decir,
	 * 	en uno de los masos del medio, arriba del 3 de diamanete que se encuentra en 
	 * 	la posición (2,5)
	 * 	 
	 * 
	 * Resultado:
	 * 	el movimiento no puede realizarse porque no se puede mandar una carta que se encuentra
	 * 	en el medio, encima de otra.*/
	
	@Test (expected = CartaException.class) 
	public void testMoviementoIncorrectoMasoDelMedio() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(1, 6);
		Carta diamante_2 = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroPpal.getPila(2, 5);
		Carta diamante_3 = mazoDestino.getUltimaCarta();
		
		assertTrue( diamante_2.equals( new Carta( 2, PaloDeCartaInglesa.DIAMANTE ) ) );
		assertTrue( diamante_3.equals( new Carta( 3, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
	}

	/* Prueba: 
	 * 	intento colocar el 8 de diamanete que se encuentra en la posicón (0,1) arriba del
	 * 	7 de diamante que se encuentra en (1,7), es decir, en el maso del medio.
	 * 	 
	 * Resultado:
	 * 	el movimiento no puede realizarse porque no se puede mandar una carta al medio.*/
	
	@Test (expected = CartaException.class) 
	public void testMoviementoIncorrectoMasoDestinoElMedio() throws CartaException  {
		
		Pila mazoOrigen = tablero.subtableroPpal.getPila(0, 1);
		Carta diamante_8 = mazoOrigen.getUltimaCarta();
		Pila mazoDestino = tablero.subtableroPpal.getPila(1, 7);
		Carta diamante_7 = mazoDestino.getUltimaCarta();
		
		assertTrue( diamante_8.equals( new Carta( 8, PaloDeCartaInglesa.DIAMANTE ) ) );
		assertTrue( diamante_7.equals( new Carta( 7, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen.moverUltimaCartaA(mazoDestino);
	}	
	
	/* Prueba: 
	 * 	mando el As de diamante al tablero secundario. Lo que deja un espacio libre en (0,0)
	 * 	Muevo la Q de diamante que está en (1,0) a (0,0)
	 * 
	 * Resultado:
	 * 	el movimiento puede realizarse.*/

	@Test
	public void testMoviementoCorrectoMasoDelMedio() throws CartaException  {
		
		Pila mazoOrigen1 = tablero.subtableroPpal.getPila(0, 0);
		Pila mazoOrigen2 = tablero.subtableroPpal.getPila(1, 0);
		Carta diamante_1 = mazoOrigen1.getUltimaCarta();
		Carta diamante_Q = mazoOrigen2.getUltimaCarta();
		Pila mazoDestino1 = tablero.subtableroSec.getPila(0, 0);
		Pila mazoDestino2 = mazoOrigen1;
		
		assertTrue( diamante_1.equals( new Carta( 1, PaloDeCartaInglesa.DIAMANTE ) ) );
		assertTrue( diamante_Q.equals( new Carta( 12, PaloDeCartaInglesa.DIAMANTE ) ) );

		mazoOrigen1.moverUltimaCartaA(mazoDestino1);
		assertTrue( mazoOrigen1.estaVacio() == true );
		
		mazoOrigen2.moverUltimaCartaA(mazoDestino2);
		assertTrue( mazoDestino2.getCantidadDeCartas() == 1 );
	}
	
	@Test
	public void testJuegoNormal() throws CartaException  {
		
		Pila pilaOrigen, pilaDestino;
		
		pilaOrigen = tablero.subtableroPpal.getPila(0, 0);
		pilaDestino = tablero.subtableroSec.getPila(0, 0);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 1, PaloDeCartaInglesa.DIAMANTE ) ) );
		
		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		pilaOrigen = tablero.subtableroPpal.getPila(0, 7);
		pilaDestino = tablero.subtableroSec.getPila(1, 0);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 1, PaloDeCartaInglesa.PICA ) ) );
	
		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		pilaOrigen = tablero.subtableroPpal.getPila(1, 0);
		pilaDestino = tablero.subtableroPpal.getPila(0, 0);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 12, PaloDeCartaInglesa.DIAMANTE ) ) );
		
		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 8, PaloDeCartaInglesa.CORAZON ) ) );
		
		pilaOrigen = tablero.subtableroPpal.getPila(1, 7);
		pilaDestino = tablero.subtableroPpal.getPila(0, 7);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 7, PaloDeCartaInglesa.DIAMANTE ) ) );
		
		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		pilaOrigen = tablero.subtableroPpal.getPila(2, 2);
		pilaDestino = tablero.subtableroSec.getPila(2, 1);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 13, PaloDeCartaInglesa.CORAZON ) ) );
		
		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		pilaOrigen = tablero.subtableroPpal.getPila(1,  2);
		pilaDestino = tablero.subtableroPpal.getPila(2, 2);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 11, PaloDeCartaInglesa.CORAZON ) ) );

		pilaOrigen.moverUltimaCartaA(pilaDestino);
		
		pilaOrigen = tablero.subtableroPpal.getPila(2,  7);
		pilaDestino = tablero.subtableroPpal.getPila(0, 7);
		
		assertTrue( pilaOrigen.getUltimaCarta().equals( new Carta( 8, PaloDeCartaInglesa.DIAMANTE ) ) );
		assertTrue( pilaDestino.getUltimaCarta().equals( new Carta( 7, PaloDeCartaInglesa.DIAMANTE ) ) );

		pilaOrigen.moverUltimaCartaA(pilaDestino);


	}
	
	
	private void setCartasDeArriba() throws CartaException
	{
		tablero.subtableroPpal.setCarta(0, 0, new Carta(1, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(0, 1, new Carta(8, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(0, 2, new Carta(2, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(0, 3, new Carta(12, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(0, 4, new Carta(7, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(0, 5, new Carta(10, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(0, 6, new Carta(10, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(0, 7, new Carta(1, PaloDeCartaInglesa.PICA));
	}

	private void setCartasDeAbajo() throws CartaException
	{
		tablero.subtableroPpal.setCarta(2, 0, new Carta(3, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(2, 1, new Carta(6, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(2, 2, new Carta(13, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(2, 3, new Carta(9, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(2, 4, new Carta(11, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(2, 5, new Carta(3, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(2, 6, new Carta(6, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(2, 7, new Carta(8, PaloDeCartaInglesa.DIAMANTE));		
	}
	
	private void setCartasDelMedio() throws CartaException
	{
		tablero.subtableroPpal.setCarta(1, 0, new Carta(3, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(1, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(10, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(12, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(12, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(7, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(9, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(1, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(11, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(8, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 0, new Carta(12, PaloDeCartaInglesa.DIAMANTE));
		
		tablero.subtableroPpal.setCarta(1, 1, new Carta(7, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(9, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(6, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(6, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(3, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(9, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(5, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(3, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(13, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(10, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 1, new Carta(13, PaloDeCartaInglesa.PICA));
		
		tablero.subtableroPpal.setCarta(1, 2, new Carta(4, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(1, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(11, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(4, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(13, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(1, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(3, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(12, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(6, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(10, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 2, new Carta(11, PaloDeCartaInglesa.CORAZON));
		
		tablero.subtableroPpal.setCarta(1, 3, new Carta(8, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(7, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(5, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(4, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(2, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(8, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(2, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(8, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(8, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(9, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 3, new Carta(12, PaloDeCartaInglesa.PICA));
			
		tablero.subtableroPpal.setCarta(1, 4, new Carta(3, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(5, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(5, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(12, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(13, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(4, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(2, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(11, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(13, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(7, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 4, new Carta(3, PaloDeCartaInglesa.PICA));
		
		tablero.subtableroPpal.setCarta(1, 5, new Carta(13, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(5, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(6, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(6, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(1, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(2, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(10, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(9, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(4, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(4, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 5, new Carta(6, PaloDeCartaInglesa.PICA));
		
		tablero.subtableroPpal.setCarta(1, 6, new Carta(10, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(9, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(13, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(2, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(11, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(7, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(9, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(5, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(2, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(4, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 6, new Carta(2, PaloDeCartaInglesa.DIAMANTE));
		
		tablero.subtableroPpal.setCarta(1, 7, new Carta(8, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(5, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(12, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(7, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(5, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(11, PaloDeCartaInglesa.DIAMANTE));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(4, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(11, PaloDeCartaInglesa.PICA));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(10, PaloDeCartaInglesa.TREBOL));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(1, PaloDeCartaInglesa.CORAZON));
		tablero.subtableroPpal.setCarta(1, 7, new Carta(7, PaloDeCartaInglesa.DIAMANTE));
		
	}

}
