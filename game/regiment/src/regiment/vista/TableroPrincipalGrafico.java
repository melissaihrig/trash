package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class TableroPrincipalGrafico extends JPanel {

	private ContenedorDeCartas contenedorPpal[][];
	//private TableroRegiment tablero;

	public TableroPrincipalGrafico() 
	{
		super();

		this.contenedorPpal = new ContenedorDeCartas[TableroRegiment.CANTIDAD_DE_FILAS_PPAL][TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL];
		this.inicializarLayout();
		this.inicializarTableroPpalVacio();
	}
	
	public void repartirCartas(TableroRegiment tablero)
	{
		for (int fila = 0; fila < TableroRegiment.CANTIDAD_DE_FILAS_PPAL; fila++)
			for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++)
				contenedorPpal[fila][columna].addCartas(tablero.getTableroPpal(fila, columna));
	}

	private void inicializarLayout()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
	}

	private void inicializarTableroPpalVacio()
	{
		for (int fila = 0; fila < TableroRegiment.CANTIDAD_DE_FILAS_PPAL; fila++)
			for (int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++)
				contenedorPpal[fila][columna] = new ContenedorDeCartas();
		
		for ( int fila = 0; fila < TableroRegiment.CANTIDAD_DE_FILAS_PPAL; fila++ )
		{
			for ( int columna = 0; columna < TableroRegiment.CANTIDAD_DE_COLUMNAS_PPAL; columna++ )
			{
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(8, 8, 8, 8);
				gbc.gridx = columna;
				gbc.gridy = fila;
				add( contenedorPpal[fila][columna], gbc);
			}
		}
	}
}
