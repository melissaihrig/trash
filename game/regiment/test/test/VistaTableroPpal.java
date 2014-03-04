package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;
import vista.carta.CartaInglesaGrafica;

import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class VistaTableroPpal extends JPanel {

	public VistaTableroPpal() 
	{
		super();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
				
		setLayout(gridBagLayout);
		
		for ( int fila = 0; fila < 3; fila++ )
		{
			for ( int columna = 0; columna < 8; columna++ )
			{
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(8, 8, 8, 8);
				gbc.gridx = columna;
				gbc.gridy = fila;
				add(new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) ), gbc);
			}
		}

	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new VistaTableroPpal());
		
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
