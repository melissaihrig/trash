package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;
import regiment.modelo.TableroRegiment.SubtableroPrincipal;

@SuppressWarnings("serial")
public class TableroPrincipalGrafico extends JPanel {

	private ContenedorDeCartas contenedorPpal[][];
	//private TableroRegiment tablero;

	public TableroPrincipalGrafico() 
	{
		super();

		this.contenedorPpal = new ContenedorDeCartas[SubtableroPrincipal.CANTIDAD_DE_FILAS][SubtableroPrincipal.CANTIDAD_DE_COLUMNAS];
		this.inicializarLayout();
		this.inicializarTableroPpalVacio();
	}
	
	public void repartirCartas(TableroRegiment tablero)
	{
//		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
//			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
//				contenedorPpal[fila][columna].addCartas(tablero.subtableroPpal.getPila(fila, columna).get);
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
		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[fila][columna] = new ContenedorDeCartas();
		
		for ( int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++ )
		{
			for ( int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++ )
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
