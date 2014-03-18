package regiment.vista;

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

public abstract class PilaGrafica {

	private Stack<CartaRegiment> cartas = new Stack<>();
	private JPanel contenedor;
	private JLabel fondo;
	private Pila pila;
	private Point punto = new Point();
	private String path = UtilVista.NAME_NOCARTA ;
	
	public PilaGrafica(Pila pila) {
		this.pila = pila;
	}

	private void agregarFondo(JPanel tablero, Point punto) 
	{
		fondo = new JLabel();
		fondo.setIcon( UtilVista.crearImagenIcono( UtilVista.PATH_FOLDER + path ) );
		fondo.setSize(fondo.getMaximumSize());
		fondo.setLocation(punto);
		tablero.add(fondo); 
	}

	public void agregrarPila(TableroGrafico tablero, Point punto ) {
		this.contenedor = tablero;
		this.punto = punto;
		this.agregarCartas(tablero, punto);
		this.agregarFondo(tablero, punto);
	}
	
	protected void agregarCartas(TableroGrafico tablero, Point punto) 
	{
		CartaRegiment cartaGrafica;
		int orden = 1;
		
		for(Carta carta: pila.getCartas())
		{
			cartaGrafica = new CartaRegiment(carta, this);
			cartas.push(cartaGrafica);
			cartaGrafica.setLocation(punto);
			cartaGrafica.setPosicionAnterior(punto);
			cartaGrafica.agregarManejadorDeEventos(new EventoCartaRegiment(cartaGrafica, tablero));
			cartaGrafica.setOrden(orden);
			tablero.add(cartaGrafica);
			orden++;
		}
	}
	
	public void agregarManejadorDeEventos( MouseAdapter manejador ) {
		
		for(CartaGrafica carta: cartas)
			carta.agregarManejadorDeEventos(manejador);
	}
	
	protected Stack<CartaRegiment> getCartas() {
		return cartas;
	}

	protected JPanel getContenedor() {
		return contenedor;
	}
	
	public abstract void reordenarDibujado();

	void moverCarta(CartaRegiment carta) throws CartaException {
		
		carta.getPila().getPila().moverUltimaCartaA( this.pila );
		carta.setLocation(this.punto);
		carta.setPosicionAnterior(this.punto);
		agregarCarta(carta);
		reordenarDibujado();			
	}
	
	boolean sePuedeMoverCarta(CartaRegiment carta) throws CartaException {
		
		return carta.getPila().getPila().sePuedeMoverCarta( this.pila );
	}
	
	boolean estaDentroDeLaPila( int x, int y ) {
		
		int minX = this.punto.x - TableroGrafico.MARGEN_CASILLA;
		int maxX = this.punto.x + fondo.getWidth() + TableroGrafico.MARGEN_CASILLA;
		int minY = this.punto.y - TableroGrafico.MARGEN_CASILLA;
		int maxY = this.punto.y + fondo.getHeight() + TableroGrafico.MARGEN_CASILLA; 
		
		return (x >= minX && x <= maxX && y >= minY && y <= maxY);
	}

	public Pila getPila() {
		return pila;
	}
	
	private void agregarCarta( CartaRegiment carta ) {
		carta.getPila().getCartas().pop();
		carta.setOrden(cartas.size());
		cartas.push(carta);
		carta.setPila(this);
	}
	
	protected void dibujarFondoAtras() {
		contenedor.setComponentZOrder(fondo, cartas.size());
	}
	
	protected Point getPunto() {
		return punto;
	}
	
	protected void setPath(String path) {
		this.path = path;
	}
}