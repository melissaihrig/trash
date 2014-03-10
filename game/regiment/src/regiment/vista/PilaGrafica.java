package regiment.vista;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JPanel;

import regiment.evento.ManejadorDeEventosDeCarta;
import regiment.modelo.Pila;

import modelo.Carta;

import vista.UtilVista;
import vista.carta.CartaInglesaGrafica;

@SuppressWarnings("serial")
public class PilaGrafica extends JPanel {

	private Stack<CartaInglesaGrafica> cartas = new Stack<>();
	private JLabel fondo;
	private Pila pila;
	
	public PilaGrafica() {
		
		super();
		this.iniciliazarGrafica();
	}
	
	public PilaGrafica(LayoutManager layout) {
		
		super(layout);
		this.iniciliazarGrafica();
	}

	public PilaGrafica(LayoutManager layout, Pila pila) {
		
		this(layout);
		this.agregarCartas(pila);
	}

	private void iniciliazarGrafica() 
	{
		fondo = new JLabel();
		fondo.setIcon( UtilVista.crearImagenIcono( UtilVista.PATH_FOLDER + UtilVista.NAME_NOCARTA ) );
		fondo.setSize(fondo.getMaximumSize());
		
		this.setSize(fondo.getSize());
		this.agregarComponente(fondo);
		
	}
	
	public void agregarCartas(Pila pila) 
	{
		this.pila = pila;
		
		CartaInglesaGrafica cartaGrafica;
		
		for(Carta carta: pila.getCartas())
		{
			cartaGrafica = new CartaInglesaGrafica(carta);
			this.cartas.push(cartaGrafica);
			this.agregarComponente(cartaGrafica);
			cartaGrafica.agregarManejadorDeEventos( new ManejadorDeEventosDeCarta(cartaGrafica) );
		}
		
	}
	
	protected void agregarComponente(Component componente) {
		this.add(componente);
	}

}