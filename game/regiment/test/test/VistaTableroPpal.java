package test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Carta;
import modelo.PaloDeCartaInglesa;
import vista.carta.CartaInglesaGrafica;

import java.awt.Dimension;

@SuppressWarnings("serial")
public class VistaTableroPpal extends JPanel {

	public VistaTableroPpal() 
	{
		super();

		CartaInglesaGrafica cartaPrueba = new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) );
		Dimension dimension = cartaPrueba.getSize();
		int margen = 8;
		
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100, 100};
//		gridBagLayout.rowHeights = new int[] {100, 100, 100};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
//				
//		setLayout(gridBagLayout);
		System.out.println("Dim: " + dimension);

		setLayout(null);
		
		int margenFila = margen;
		for ( int fila = 0; fila < 3; fila++ )
		{
			int margenColumna = margen;
			
			for ( int columna = 0; columna < 8; columna++ )
			{
				
//				GridBagConstraints gbc = new GridBagConstraints();
//				gbc.insets = new Insets(8, 8, 8, 8);
//				gbc.gridx = columna;
//				gbc.gridy = fila;
//				gbc.fill = GridBagConstraints.BOTH;
//				JPanel panel = new JPanel();
//				panel.setLayout(null);
				JLabel carta = new CartaInglesaGrafica( new Carta(8, PaloDeCartaInglesa.CORAZON) );
				carta.setLocation(margenColumna, margenFila);
				add(carta);
				System.out.println(margenColumna +" "+ margenFila);
				margenColumna += 2*margen + dimension.width;
			}
			
			margenFila += 2*margen + dimension.height;
		}

	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new VistaTableroPpal());
		
		frame.setSize(900, 500);
//		frame.setMinimumSize(new Dimension(750, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
