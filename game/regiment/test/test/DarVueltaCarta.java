package test;

import vista.UtilVista;
import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;

@SuppressWarnings("serial")
public class DarVueltaCarta extends JPanel {
	
	private CartaGrafica  carta;
	
	public DarVueltaCarta() {
		super();
		this.setLayout(null);
		
		carta = new CartaInglesaGrafica(new Carta(5, PaloDeCartaInglesa.CORAZON));
		carta.setLocation(50, 50);
		add(carta);
		
		JButton boton = new JButton("dar vuelta");
		boton.setBounds(30, 200, 100, 35);
		boton.addMouseListener(new EventoDarVuelta(carta));
		add(boton);
		
	}
	
	public class EventoDarVuelta extends MouseAdapter {
		
		private CartaGrafica carta;

		public EventoDarVuelta(CartaGrafica carta) {
			this.carta = carta;
		}
		
		public void mouseClicked(MouseEvent evt) {
			
			if (carta.getCarta().estaCaraArriba()) {
				carta.setIcon( UtilVista.crearImagenIcono(UtilVista.PATH_FOLDER +
						 "c5.png"));
			}
			else {
				carta.setIcon( UtilVista.crearImagenIcono(UtilVista.PATH_FOLDER +
			 "b2fv.png"));
			}
			carta.darVuelta();
		}
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new DarVueltaCarta());
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
