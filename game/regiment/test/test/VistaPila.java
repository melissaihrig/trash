package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import regiment.modelo.Pila;
import regiment.vista.PilaGrafica;
import regiment.vista.PilaJunta;

import modelo.Carta;
import modelo.CartaException;
import modelo.PaloDeCartaInglesa;

@SuppressWarnings("serial")
public class VistaPila extends JPanel {
	
	public VistaPila()
	{
		super();

		this.setSize(100,100);
		this.setBackground(new Color(100,50,80));
		PilaGrafica pila = new PilaJunta( new PilaAcumulacion() );
		this.setLayout(new BorderLayout());
		this.add(pila, BorderLayout.CENTER);
		this.add(new JLabel("."), BorderLayout.EAST);
		this.add(new JLabel("."), BorderLayout.NORTH);
		this.add(new JLabel("."), BorderLayout.SOUTH);
		this.add(new JLabel("."), BorderLayout.WEST);
		this.add(new JLabel("."), BorderLayout.WEST);

	}
	
	private class PilaAcumulacion extends Pila {
		
		public PilaAcumulacion() {
			super(0, 0);
			
			try {
				this.agregarCarta(new Carta(3, PaloDeCartaInglesa.CORAZON));
				this.agregarCarta(new Carta(3, PaloDeCartaInglesa.PICA));
				this.agregarCarta(new Carta(13, PaloDeCartaInglesa.TREBOL));
				this.agregarCarta(new Carta(7, PaloDeCartaInglesa.DIAMANTE));
				this.agregarCarta(new Carta(1, PaloDeCartaInglesa.CORAZON));
			} catch (CartaException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void verificarRecibirCarta(Pila origen) throws CartaException {
		}

		@Override
		public void verificarSacarUltimaCarta(Pila pilaDestino)
				throws CartaException {
		}
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();

		frame.getContentPane().add(new VistaPila(), BorderLayout.CENTER);
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
