package regiment.modelo;

import java.util.ArrayList;

import modelo.carta.Carta;
import modelo.carta.Tablero;




public class TableroRegiment implements Tablero {
	
	public static int CANTIDAD_DE_FILAS_PPAL = 3;
	public static int CANTIDAD_DE_COLUMNAS_PPAL = 8;
	
	public static int CANTIDAD_DE_FILAS_SEC = 4;
	public static int CANTIDAD_DE_COLUMNAS_SEC = 2;
	
	private ArrayList<Carta> tableroPpal[][];
	private ArrayList<Carta> tableroSec[][];
	
	public TableroRegiment() 
	{
		this.tableroPpal = new ArrayList[CANTIDAD_DE_FILAS_PPAL][CANTIDAD_DE_COLUMNAS_PPAL];
		this.tableroSec = new ArrayList[CANTIDAD_DE_FILAS_SEC][CANTIDAD_DE_COLUMNAS_SEC];
		
		this.inicializarTablero(CANTIDAD_DE_FILAS_PPAL, CANTIDAD_DE_COLUMNAS_PPAL, tableroPpal);
		this.inicializarTablero(CANTIDAD_DE_FILAS_SEC, CANTIDAD_DE_COLUMNAS_SEC, tableroSec);
	}

	public void setTableroPpal( int fila, int columna, Carta carta) {
		this.tableroPpal[fila][columna].add(carta);
	}

	public ArrayList<Carta> getTableroPpal( int fila, int columna) {
		return this.tableroPpal[fila][columna];
	}
	
	public ArrayList<Carta> getTableroSec( int fila, int columna) {
		return this.tableroSec[fila][columna];
	}
	
	private void inicializarTablero( int cantidadDeFilas, int cantidadDeColumnas, ArrayList<Carta>[][] tablero)
	{
		for (int fila = 0; fila < cantidadDeFilas; fila++ )
			for (int columna = 0; columna < cantidadDeColumnas; columna++)
				tablero[fila][columna] = new ArrayList<>();
	}
}
