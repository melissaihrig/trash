package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

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

public class TableroDePrueba {

	TableroRegiment tablero;
	
	public TableroDePrueba() {
		tablero = new TableroRegiment();

		try {
			this.setCartasDeArriba();
			this.setCartasDeAbajo();
			this.setCartasDelMedio();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public TableroRegiment getTablero() {
		return tablero;
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
