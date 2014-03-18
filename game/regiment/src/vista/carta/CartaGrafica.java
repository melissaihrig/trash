package vista.carta;

import vista.UtilVista;

import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Carta;

@SuppressWarnings("serial")
public abstract class CartaGrafica extends JLabel {
	
	private Carta carta;
	private Point posicionAnterior;
	private ImageIcon imageCara;
	private ImageIcon imageContraCara;
	
	public CartaGrafica( Carta carta )
	{
		super();
		this.carta = carta;
	}

	protected void setImagenCarta( String pathImagen ) {
		imageCara = UtilVista.crearImagenIcono( pathImagen );
		this.setIcon(imageCara);
	}
	
	protected void setImagenCaraYContracara( String pathImagenCara, String pathImagenContracara ) {
		imageContraCara =  UtilVista.crearImagenIcono( pathImagenContracara );
		setImagenCarta( pathImagenCara );
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
	
	public Point getMedio() {
		int x_medio = getX() + getWidth() / 2;
		int y_medio = getY() + getHeight() / 2;
		
		return new Point(x_medio, y_medio);
	}

	public void darVuelta() {
			
		if (carta.estaCaraArriba())
			setIcon(imageContraCara);
		else 
			setIcon(imageCara);
		
		carta.darVuelta();
		
	}
}
