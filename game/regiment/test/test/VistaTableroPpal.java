package test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;
import vista.carta.CartaInglesaGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class VistaTableroPpal extends JPanel {

	public VistaTableroPpal() 
	{
		super();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100, 100};
		gridBagLayout.rowHeights = new int[] {100, 100, 100};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
				
		setLayout(gridBagLayout);
		
		
		for ( int fila = 0; fila < 3; fila++ )
		{
			for ( int columna = 0; columna < 8; columna++ )
			{
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(8, 8, 8, 8);
				gbc.gridx = columna;
				gbc.gridy = fila;
				gbc.fill = GridBagConstraints.BOTH;
				JPanel panel = new JPanel();
				panel.setLayout(null);
				JLabel carta = new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) );
				carta.setBounds(10,10,50,50);
				panel.add(carta);
				panel.setBackground(new Color(200, 100, 50));
				add(panel, gbc);
			}
		}

	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new VistaTableroPpal());
		
		frame.setSize(900, 500);
		frame.setMinimumSize(new Dimension(750, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
