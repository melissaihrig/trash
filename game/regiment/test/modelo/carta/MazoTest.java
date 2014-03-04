package modelo.carta;

import static org.junit.Assert.*;


import modelo.BarajaInglesa;
import modelo.Carta;
import modelo.Mazo;
import modelo.PaloDeCartaInglesa;
import modelo.Tablero;

import org.junit.Test;

import regiment.modelo.DistribuidorRegiment;


public class MazoTest {

	@Test
	public void testMezclar() {
		
		Mazo mazo = new BarajaInglesa(2);
		assertEquals(2*4*13, mazo.getCantidadDeCartas());
		
		mazo.mezclar();
		assertEquals(2*4*13, mazo.getCantidadDeCartas());
		
		for (PaloDeCartaInglesa palo : PaloDeCartaInglesa.values()) 
			for (int valor = 1; valor <= 13; valor++ )
				assertEquals(2, mazo.tieneLaCarta(new Carta(valor, palo)));
		
		Tablero tablero = mazo.repartirCartas( new DistribuidorRegiment() );
		assertEquals(0, mazo.getCantidadDeCartas());
	}

}
