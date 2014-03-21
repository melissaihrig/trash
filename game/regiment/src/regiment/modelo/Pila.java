package regiment.modelo;

import java.util.Stack;

import modelo.Carta;
import modelo.CartaException;

public abstract class Pila {
	
	public static int As = 1;
	public static int K = 13;
	
	private Stack<Carta> cartas = new Stack<>();
	private int fila;
	private int columna;
	
	public Pila ( int fila, int columna ) 
	{
		this.fila = fila;
		this.columna = columna;
	}

	public final void moverUltimaCartaA( Pila pilaDestino ) throws CartaException 
	{
		if (sePuedeMoverCarta(pilaDestino) == false)
			throw new CartaException("La pila destino y origen son las mismas."); 
		
		pilaDestino.agregarCarta(getUltimaCarta());
		sacarUltimaCarta();
	}

	public final boolean sePuedeMoverCarta( Pila pilaDestino ) throws CartaException 
	{
		if (pilaDestino == this)
			return false;
		
		verificarSacarUltimaCarta( pilaDestino );
		pilaDestino.verificarRecibirCarta( this );
		
		return true;
	}
	
	public abstract void verificarRecibirCarta( Pila origen ) throws CartaException;
	
	public abstract void verificarSacarUltimaCarta( Pila pilaDestino ) throws CartaException;
	

	protected void setCartas( Stack<Carta> cartas ) {
		this.cartas = cartas;
	}

	public void agregarCarta( Carta carta ) throws CartaException {
		this.cartas.push( carta );
	}

	protected void verificarSiMismoPalo( Carta cartaDeArriba, Carta cartaAAgregar ) throws CartaException {
		if ( !cartaDeArriba.esDelMismoPaloQue( cartaAAgregar ) ) 
			throw new CartaException("No se puede colocar esa carta. Tienen que ser del mismo palo. Carta de arriba: " + cartaDeArriba.toString() + " carta a agregar: " + cartaAAgregar.toString() );
	}	
	
	public Carta sacarUltimaCarta() {
		return this.cartas.pop();
	}
	
	public Carta getUltimaCarta() {
		return this.cartas.peek();
	}
	
	public int getCantidadDeCartas() {
		return this.cartas.size();
	}

	public Stack<Carta> getCartas() {
		return cartas;
	}
	
	public String toString() {
		return cartas.toString(); 
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public boolean estaVacio() {
		return this.cartas.empty();
	}
}
