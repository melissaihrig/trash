package test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import regiment.evento.ManejadorDeEventosDeCarta;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;

import vista.carta.CartaGrafica;
import vista.carta.CartaInglesaGrafica;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class DragCartaPila extends JPanel {
	
	public DragCartaPila()
	{
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{99, 1, 1, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 1, 42, 1, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnHolaa = new JButton("holaa");
		btnHolaa.setBackground(SystemColor.info);
		GridBagConstraints gbc_btnHolaa = new GridBagConstraints();
		gbc_btnHolaa.insets = new Insets(0, 0, 5, 0);
		gbc_btnHolaa.gridx = 3;
		gbc_btnHolaa.gridy = 0;
		add(btnHolaa, gbc_btnHolaa);
		CartaGrafica carta9_corazon = new CartaInglesaGrafica( new Carta(9, PaloDeCartaInglesa.CORAZON) );
		
		carta9_corazon.agregarManejadorDeEventos( new ManejadorDeEventosDeCarta(carta9_corazon) ) ;
		GridBagConstraints gbc_carta9_corazon = new GridBagConstraints();
		gbc_carta9_corazon.anchor = GridBagConstraints.NORTHWEST;
		gbc_carta9_corazon.insets = new Insets(0, 0, 5, 5);
		gbc_carta9_corazon.gridx = 3;
		gbc_carta9_corazon.gridy = 1;
		add(carta9_corazon, gbc_carta9_corazon);
		
		JButton btnKoo = new JButton("koo");
		btnKoo.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_btnKoo = new GridBagConstraints();
		gbc_btnKoo.insets = new Insets(0, 0, 5, 5);
		gbc_btnKoo.gridx = 0;
		gbc_btnKoo.gridy = 2;
		add(btnKoo, gbc_btnKoo);
		
		CartaGrafica carta8_corazon = new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) );
		
		carta8_corazon.agregarManejadorDeEventos( new ManejadorDeEventosDeCarta(carta8_corazon) ) ;
		GridBagConstraints gbc_carta8_corazon = new GridBagConstraints();
		gbc_carta8_corazon.anchor = GridBagConstraints.NORTHWEST;
		gbc_carta8_corazon.insets = new Insets(0, 0, 0, 5);
		gbc_carta8_corazon.gridx = 1;
		gbc_carta8_corazon.gridy = 3;
		add(carta8_corazon, gbc_carta8_corazon);
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new DragCartaPila());
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
