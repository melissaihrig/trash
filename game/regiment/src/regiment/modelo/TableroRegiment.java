package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;
import modelo.Tablero;

public class TableroRegiment implements Tablero {
	
	public final SubtableroPrincipal subtableroPpal;
	public final SubtableroSecundario subtableroSec;
	
	public TableroRegiment() 
	{
		this.subtableroPpal = new SubtableroPrincipal();
		this.subtableroSec = new SubtableroSecundario();
	}
	
	interface Subtablero {
		void setCarta( int fila, int columna, Carta carta) throws CartaException;
		Pila getPila( int fila, int columna);
	}
	
	public class SubtableroPrincipal implements Subtablero {

		public static final int CANTIDAD_DE_FILAS = 3;
		public static final int CANTIDAD_DE_COLUMNAS = 8;

		private Pila tablero[][];
		
		private SubtableroPrincipal() 
		{
			this.tablero = new Pila[CANTIDAD_DE_FILAS][CANTIDAD_DE_COLUMNAS];

			/* fila superior del tablero */
			for ( int columna = 0; columna < CANTIDAD_DE_COLUMNAS; columna++ ) 
				tablero[0][columna] = new PilaDeRelaciones(0, columna);
			
			/* fila inferior del tablero */
			for ( int columna = 0; columna < CANTIDAD_DE_COLUMNAS; columna++ ) 
				tablero[2][columna] = new PilaDeRelaciones(2, columna);
			
			/* fila del medio del tablero */
			for ( int columna = 0; columna < CANTIDAD_DE_COLUMNAS; columna++ )
				tablero[1][columna] = new PilaDelMedio(this, 1, columna);
			
		}

		public void setCarta( int fila, int columna, Carta carta) throws CartaException {
			this.tablero[fila][columna].agregarCarta(carta);
		}
		
		public Pila getPila( int fila, int columna) {
			return this.tablero[fila][columna];
		}
		
	}
	
	public class SubtableroSecundario implements Subtablero {
		
		public static final int CANTIDAD_DE_FILAS = 4;
		public static final int CANTIDAD_DE_COLUMNAS = 2;

		private Pila tablero[][];
		
		private SubtableroSecundario() 
		{
			this.tablero = new Pila[CANTIDAD_DE_FILAS][CANTIDAD_DE_COLUMNAS];

			/* columna de Ases */
			for ( int fila = 0; fila < CANTIDAD_DE_FILAS; fila++ )
				tablero[fila][0] = new PilaDeAses(fila, 0);
			
			/* columna de Kes */
			for ( int fila = 0; fila < CANTIDAD_DE_FILAS; fila++ )
				tablero[fila][1] = new PilaDeKes(fila, 1);		
		}

		public void setCarta( int fila, int columna, Carta carta) throws CartaException {
			this.tablero[fila][columna].agregarCarta(carta);
		}
		
		public Pila getPila( int fila, int columna) {
			return this.tablero[fila][columna];
		}
	}
	
	public String toString() {
		
		String tablero = "Arriba \n";
		for (int i = 0; i < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; i++) 			
			tablero += " " + subtableroPpal.getPila(0, i);
		
		tablero +=  "\n Medio \n";
		for (int i = 0; i < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; i++) 
			tablero += " " + subtableroPpal.getPila(1, i) + "\n";

		tablero +=  "\n Bajo \n";
		for (int i = 0; i < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; i++)			
			tablero += " " + subtableroPpal.getPila(2, i);

		return tablero;
	}

}
