package regiment.modelo;

import regiment.modelo.TableroRegiment.SubtableroPrincipal;
import modelo.Baraja;
import modelo.DistribuidorDeCartas;
import modelo.Tablero;

public class DistribuidorRegiment implements DistribuidorDeCartas {

	@Override
	public Tablero repartir( Baraja baraja )
	{
		TableroRegiment tablero = new TableroRegiment();
		
		try
		{
			this.setCartasDeArriba(tablero, baraja);
			this.setCartasDeAbajo(tablero, baraja);
			this.setCartasDelMedio(tablero, baraja);
		}
		catch (Exception e) {
			/* no debería saltar la excepción, sino es que el distribuidor está mal programado*/
			e.printStackTrace();
		}
		
		
		return tablero;
	}
	
	private void setCartasDeArriba( TableroRegiment tablero, Baraja baraja ) throws Exception
	{
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			tablero.subtableroPpal.setCarta(0, columna, baraja.getCartaDeArriba());
	}

	private void setCartasDeAbajo( TableroRegiment tablero, Baraja baraja ) throws Exception
	{
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			tablero.subtableroPpal.setCarta(2, columna, baraja.getCartaDeArriba());
	}
	
	private void setCartasDelMedio( TableroRegiment tablero, Baraja baraja ) throws Exception
	{
        int cantDeCartasPorPosicion = (baraja.getCantidadDeCartas() / SubtableroPrincipal.CANTIDAD_DE_COLUMNAS);

		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			for (int num = 0; num < cantDeCartasPorPosicion; num++)
				tablero.subtableroPpal.setCarta(1, columna, baraja.getCartaDeArriba());
	}
}
