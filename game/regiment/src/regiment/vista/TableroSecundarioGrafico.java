package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment.SubtableroSecundario;

@SuppressWarnings("serial")
public class TableroSecundarioGrafico extends JPanel {

	private PilaGrafica contenedorSec[][];

	public TableroSecundarioGrafico() 
	{
		super();

		this.contenedorSec = new PilaGrafica[SubtableroSecundario.CANTIDAD_DE_FILAS][SubtableroSecundario.CANTIDAD_DE_COLUMNAS];
		this.inicializarLayout();
		this.inicializarTableroSec();
	}
	
	public TableroSecundarioGrafico(SubtableroSecundario subtableroSec) 
	{
		super();

		this.contenedorSec = new PilaGrafica[SubtableroSecundario.CANTIDAD_DE_FILAS][SubtableroSecundario.CANTIDAD_DE_COLUMNAS];
		this.inicializarLayout();
		this.inicializarTableroSec();
	}
	
	private void inicializarLayout()
	{
		int altoCasilla = 2 * TableroGrafico.MARGEN + TableroGrafico.ALTO_CASILLA;
		int anchoCasilla = 2 * TableroGrafico.MARGEN + TableroGrafico.ANCHO_CASILLA;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{anchoCasilla, anchoCasilla};
		gridBagLayout.rowHeights = new int[] {altoCasilla, altoCasilla, altoCasilla, altoCasilla};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		
		setLayout(gridBagLayout);
	}

	private void inicializarTableroSec()
	{
		for (int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorSec[fila][columna] = new PilaGrafica();
		
		for ( int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++ )
		{
			for ( int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++ )
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
