package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;

import regiment.evento.EventoCartaRegiment;
import regiment.modelo.Pila;

import modelo.Carta;
import modelo.CartaException;

import vista.UtilVista;
import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;

public abstract class PilaGrafica {

	private Stack<CartaInglesaGrafica> cartas = new Stack<>();
	private JPanel contenedor;
	private JLabel fondo;
	private Pila pila;
	private Point punto;
	
	public PilaGrafica() {} //TODO borrar
	
	public PilaGrafica(Pila pila) {
		this.pila = pila;
	}

	private void agregarFondo(JPanel tablero, Point punto) 
	{
		fondo = new JLabel();
		fondo.setIcon( UtilVista.crearImagenIcono( UtilVista.PATH_FOLDER + UtilVista.NAME_NOCARTA ) );
		fondo.setSize(fondo.getMaximumSize());
		
		fondo.setLocation(punto);
		tablero.add(fondo); 
	}
	
	public void agregrarPila(JPanel tablero, GridBagConstraints gbc) {
//		this.agregarCartas(tablero, gbc);
//		this.agregarFondo(tablero, gbc);
	}

	public void agregrarPila(TableroGrafico tablero, Point punto ) {
		this.contenedor = tablero;
		this.punto = punto;
		this.agregarCartas(tablero, punto);
		this.agregarFondo(tablero, punto);
	}
	
	private void agregarCartas(TableroGrafico tablero, Point punto) 
	{
		CartaRegiment cartaGrafica;
		
		for(Carta carta: pila.getCartas())
		{
			cartaGrafica = new CartaRegiment(carta, this);
			cartas.push(cartaGrafica);
			cartaGrafica.setLocation(punto);
			cartaGrafica.setPosicionAnterior(punto);
			cartaGrafica.agregarManejadorDeEventos(new EventoCartaRegiment(cartaGrafica, tablero));
			tablero.add(cartaGrafica);
		}
	}
	
	public void agregarManejadorDeEventos( MouseAdapter manejador ) {
		
		for(CartaGrafica carta: cartas)
			carta.agregarManejadorDeEventos(manejador);
	}
	
	protected Stack<CartaInglesaGrafica> getCartas() {
		return cartas;
	}

	protected JPanel getContenedor() {
		return contenedor;
	}
	
	public abstract void reordenarDibujado();

	public void moverCarta(CartaRegiment carta) throws CartaException {
		
		int x = carta.getX() + carta.getWidth() / 2;
		int y = carta.getY() + carta.getHeight() / 2;
		
		if ( estaDentroDeLaPila(x, y) ) {
			System.out.println("pila: " + this.pila.getColumna() + " " + this.pila.getFila());
			carta.getPila().getPila().moverUltimaCartaA( this.pila );
			carta.setPila( this );
			carta.setLocation(this.punto);
		}
	}
	
	private boolean estaDentroDeLaPila( int x, int y ) {
		
		int minX = this.punto.x - TableroGrafico.MARGEN;
		int maxX = this.punto.x + fondo.getWidth() + TableroGrafico.MARGEN;
		int minY = this.punto.y - TableroGrafico.MARGEN;
		int maxY = this.punto.y + fondo.getHeight() + TableroGrafico.MARGEN; 
		
		return (x >= minX && x <= maxX && y >= minY && y <= maxY);
	}

	public Pila getPila() {
		return pila;
	}
}