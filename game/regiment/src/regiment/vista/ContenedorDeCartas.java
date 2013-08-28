package regiment.vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.carta.Carta;
import modelo.carta.PaloDeCartaInglesa;


import vista.UtilVista;
import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;


public class ContenedorDeCartas extends JPanel {

	private ArrayList<CartaInglesaGrafica> cartas = new ArrayList<>();
	
	public ContenedorDeCartas() {
		
		super();
		
		JLabel fondo = new JLabel();
		String la = UtilVista.PATH_FOLDER + UtilVista.NAME_NOCARTA;
		
		System.out.println("Arch: " + la);
		fondo.setIcon( UtilVista.crearImagenIcono( this, la ) );
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
