package test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import regiment.evento.ManejadorDeEventosDeCarta;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;

import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;

@SuppressWarnings("serial")
public class DragCarta extends JPanel {
	
	public DragCarta()
	{
		super();
		
		setLayout(null);
		
		CartaGrafica carta = new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) );
		
		carta.addManejadorDeEventos( new ManejadorDeEventosDeCarta(carta) ) ; 
		carta.setLocation(99, 93);
		add(carta);
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new DragCarta());
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
