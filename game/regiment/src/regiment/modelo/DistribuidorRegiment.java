package regiment.modelo;

import modelo.DistribuidorDeCartas;
import modelo.Mazo;
import modelo.Tablero;

public class DistribuidorRegiment implements DistribuidorDeCartas {

	@Override
	public Tablero ejecutarLogica( Mazo mazo )
	{
		TableroRegiment tablero = new TableroRegiment();
		
		this.setCartasDeArriba(tablero, mazo);
		this.setCartasDeAbajo(tablero, mazo);
		this.setCartasDelMedio(tablero, mazo);

		
		return tablero;
	}
	
	private void setCartasDeArriba( TableroRegiment tablero, Mazo mazo )
	{
		for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++)
			tablero.setTableroPpal(0, columna, mazo.getCartaDeArriba());
	}

	private void setCartasDeAbajo( TableroRegiment tablero, Mazo mazo )
	{
		for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++)
			tablero.setTableroPpal(2, columna, mazo.getCartaDeArriba());
	}
	
	private void setCartasDelMedio( TableroRegiment tablero, Mazo mazo )
	{
        int cantDeCartasPorPosicion = (mazo.getCantidadDeCartas() / TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL);

		for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++)
			for (int num = 0; num < cantDeCartasPorPosicion; num++)
				tablero.setTableroPpal(1, columna, mazo.getCartaDeArriba());
	}
}
