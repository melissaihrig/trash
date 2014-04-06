package regiment.modelo;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;
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
	
	public boolean ganoElJuego() {
		return subtableroPpal.getCantidadDeCartas() == 0;
	}

	public boolean perdioElJuego() {
		System.out.println("=============================*****===================");

		boolean a = algunMovimientoEnFila(0) || algunMovimientoEnFila(2);
		
		
		System.out.println("mov disponible: " +  a + " ");
		System.out.println("================================================");

		return !a;
	}
	
	private boolean algunMovimientoEnFila(int fila) {
		
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++) {
			
			Pila pilaOrigen = subtableroPpal.getPila(fila, columna);
			Pila pilaMedio = subtableroPpal.getPila(1, columna);

			System.out.println("..PILA ORIGEN: " + pilaOrigen.getFila() + " " + pilaOrigen.getColumna() + " -> " + pilaOrigen.getUltimaCarta());
			
			if ( pilaOrigen.estaVacia() && !pilaMedio.estaVacia()) {
				System.out.println("Pila origen vacía");
				return true;
			} 
			
			if ( puedeIrEnElTableroPrincipal(pilaOrigen) || puedeIrEnElTableroSecundario(pilaOrigen) ) {
				System.out.println("pila origen de mov valido: " + pilaOrigen.getFila() + " " + pilaOrigen.getColumna() + " -> " + pilaOrigen.getUltimaCarta());
				return true;
			}
		}
		return false;
	}
	
	private boolean puedeIrEnElTableroPrincipal(Pila pilaOrigen) {
		
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++) {
			
			Pila pilaDestinoArriba = subtableroPpal.getPila(0, columna);
			Pila pilaDestinoAbajo = subtableroPpal.getPila(2, columna);
				
			if ( sePuedeMoverDesde(pilaOrigen, pilaDestinoArriba) )
			{
				System.out.println("destino: " + pilaDestinoArriba.getFila() + " " + pilaDestinoArriba.getColumna() + " -> " + pilaDestinoArriba.getUltimaCarta());
				return true;
			}
			else if ( sePuedeMoverDesde(pilaOrigen, pilaDestinoAbajo) )
			{
				System.out.println("destino: " + pilaDestinoAbajo.getFila() + " " + pilaDestinoAbajo.getColumna() + " -> " + pilaDestinoAbajo.getUltimaCarta());
				return true;
			}
		}
		
		return false;
	}
	
	private boolean puedeIrEnElTableroSecundario(Pila pilaOrigen) {
		
		for (int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++)
		{
			for (int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++) {
				
				Pila pilaDestino = subtableroSec.getPila(fila, columna);
			
				if ( sePuedeMoverDesde(pilaOrigen, pilaDestino) )
					return true;
			}
		}
		return false;
	}

	private boolean sePuedeMoverDesde(Pila pilaOrigen, Pila pilaDestino) {
		
		System.out.println("pila DEST: " + pilaDestino.getFila() + " " + pilaDestino.getColumna()+ " -> " + pilaDestino.getUltimaCarta());
		boolean mover = false;
		try {
			if (pilaOrigen.sePuedeMoverCarta(pilaDestino))
				mover = true;
		} 
		catch (CartaException e) {}
		
		return mover;
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
		
		public int getCantidadDeCartas() {
			
			int cantidadDeCartas = 0;
			
			for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
				for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
					cantidadDeCartas += tablero[fila][columna].getCantidadDeCartas(); 
			
			return cantidadDeCartas;
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
				tablero[fila][0] = new PilaDeAses(fila, 0, PaloDeCartaInglesa.values()[fila]);
			
			/* columna de Kes */
			for ( int fila = 0; fila < CANTIDAD_DE_FILAS; fila++ )
				tablero[fila][1] = new PilaDeKes(fila, 1, PaloDeCartaInglesa.values()[fila]);		
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
