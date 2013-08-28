package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class TableroSecundarioGrafico extends JPanel {

	private ContenedorDeCartas contenedorSec[][];

	public TableroSecundarioGrafico() 
	{
		super();

		this.contenedorSec = new ContenedorDeCartas[TableroRegiment.CANTIDAD_DE_FILAS_SEC][TableroRegiment.CANTIDAD_DE_COLUMNAS_SEC];
		this.inicializarLayout();
		this.inicializarTableroSec();
	}
	
	private void inicializarLayout()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		
		setLayout(gridBagLayout);
	}

	private void inicializarTableroSec()
	{
		for (int fila = 0; fila < TableroRegiment.CANTIDAD_DE_FILAS_SEC; fila++)
			for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_SEC; columna++)
				contenedorSec[fila][columna] = new ContenedorDeCartas();
		
		for ( int fila = 0; fila < TableroRegiment.CANTIDAD_DE_FILAS_SEC; fila++ )
		{
			for ( int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_SEC; columna++ )
			{
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);
				gbc.gridx = columna;
				gbc.gridy = fila;
				add( contenedorSec[fila][columna], gbc);
			}
		}	
	}
}
