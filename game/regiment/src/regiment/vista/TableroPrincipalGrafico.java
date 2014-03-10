package regiment.vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment.SubtableroPrincipal;

@SuppressWarnings("serial")
public class TableroPrincipalGrafico extends JPanel {

	private PilaGrafica contenedorPpal[][];

	public TableroPrincipalGrafico() 
	{
		super();

		this.contenedorPpal = new PilaGrafica[SubtableroPrincipal.CANTIDAD_DE_FILAS][SubtableroPrincipal.CANTIDAD_DE_COLUMNAS];
		this.inicializarLayout();
		this.inicializarContenedorVacio();
		this.inicializarVista();
	}
	
	public TableroPrincipalGrafico(SubtableroPrincipal subtableroPpal) 
	{
		super();
		this.contenedorPpal = new PilaGrafica[SubtableroPrincipal.CANTIDAD_DE_FILAS][SubtableroPrincipal.CANTIDAD_DE_COLUMNAS];
		this.inicializarLayout();
		this.inicializarContenedor(subtableroPpal);
		this.inicializarVista();	
		this.inicializarTablero(subtableroPpal);
	}

	private void inicializarVista() 
	{
		for ( int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++ )
		{
			for ( int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++ )
			{
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(TableroGrafico.MARGEN, TableroGrafico.MARGEN, TableroGrafico.MARGEN, TableroGrafico.MARGEN);
				gbc.fill = GridBagConstraints.BOTH;
				gbc.gridx = columna;
				gbc.gridy = fila;
				add( contenedorPpal[fila][columna], gbc);
			}
		}		
	}

	private void inicializarContenedor(SubtableroPrincipal subtableroPpal)
	{
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			contenedorPpal[0][columna] =  new PilaEscalera(subtableroPpal.getPila(0, columna));
		
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			contenedorPpal[1][columna] = new PilaJunta(subtableroPpal.getPila(1, columna));	
		
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			contenedorPpal[2][columna] = new PilaEscalera(subtableroPpal.getPila(2, columna));
	}

	private void inicializarContenedorVacio() {
		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[fila][columna] = new PilaJunta();
	}
	
	private void inicializarLayout()
	{
		int altoCasilla = 2 * TableroGrafico.MARGEN + TableroGrafico.ALTO_CASILLA;
		int anchoCasilla = 2 * TableroGrafico.MARGEN + TableroGrafico.ANCHO_CASILLA;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{anchoCasilla, anchoCasilla, anchoCasilla, anchoCasilla, anchoCasilla, anchoCasilla, anchoCasilla, anchoCasilla};
		gridBagLayout.rowHeights = new int[]{altoCasilla, altoCasilla, altoCasilla};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
	}
	
	private void inicializarTablero(SubtableroPrincipal subtableroPpal)
	{
		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[fila][columna].agregarCartas(subtableroPpal.getPila(fila, columna));
	}

}
