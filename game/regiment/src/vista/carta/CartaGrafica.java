package vista.carta;

import vista.UtilVista;

import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

import modelo.Carta;

@SuppressWarnings("serial")
public abstract class CartaGrafica extends JLabel {
	
	private Carta carta;
	private Point posicionAnterior;
	
	public CartaGrafica( Carta carta )
	{
		super();
		this.carta = carta;
	}

	protected void setImagenCarta( String pathImagen ) {
		this.setIcon( UtilVista.crearImagenIcono( pathImagen ) );
	}

	public Carta getCarta() {
		return carta;
	}

	public void agregarManejadorDeEventos( MouseAdapter manejador )
	{
		this.addMouseListener( manejador );
		this.addMouseMotionListener( manejador );
	}

	public Point getPosicionAnterior() {
		return posicionAnterior;
	}

	public void setPosicionAnterior(Point posicionAnterior) {
		this.posicionAnterior = posicionAnterior;
	}

}
