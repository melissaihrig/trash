package regiment.vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;


import vista.UtilVista;
import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;


public class ContenedorDeCartas extends JPanel {

	private ArrayList<CartaInglesaGrafica> cartas = new ArrayList<>();
	
	public ContenedorDeCartas() {
		
		super();
		
		JLabel fondo = new JLabel();
		
		fondo.setIcon( UtilVista.crearImagenIcono( UtilVista.PATH_FOLDER + UtilVista.NAME_NOCARTA ) );
		fondo.setSize(fondo.getMaximumSize());
		
//		this.setSize(fondo.getSize());
		this.add(fondo, BorderLayout.CENTER);
	}

	public ContenedorDeCartas( ArrayList<Carta> cartas ) 
	{
		this.addCartas(cartas);
	}
	
	public void addCartas( ArrayList<Carta> cartas )
	{
		for (Carta carta: cartas)
			this.cartas.add( new CartaInglesaGrafica( carta ) );
	}

}
