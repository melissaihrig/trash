package modelo;

import static org.junit.Assert.*;

import modelo.BarajaInglesa;
import modelo.Carta;
import modelo.PaloDeCartaInglesa;

import org.junit.Test;

import regiment.modelo.DistribuidorRegiment;

public class BarajaTest {

	@Test
	public void testMezclar() {
		
		Baraja baraja = new BarajaInglesa(2);
		assertEquals(2*4*13, baraja.getCantidadDeCartas());
		
		baraja.mezclar();
		assertEquals(2*4*13, baraja.getCantidadDeCartas());
		
		for (PaloDeCartaInglesa palo : PaloDeCartaInglesa.values()) 
			for (int valor = 1; valor <= 13; valor++ )
				assertEquals(2, baraja.tieneLaCarta(new Carta(valor, palo)));
		
		baraja.repartirCartas( new DistribuidorRegiment() );
		assertEquals(0, baraja.getCantidadDeCartas());
	}

}
