package vista.carta;

import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

import modelo.Carta;

import vista.UtilVista;

@SuppressWarnings("serial")
public abstract class CartaGrafica extends JLabel {
	
	private Carta carta;
	
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

	public void addManejadorDeEventos( MouseAdapter manejador )
	{
		this.addMouseListener( manejador );
		this.addMouseMotionListener( manejador );
	}
}
