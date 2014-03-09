package regiment.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
				gbc.insets = new Insets(8, 8, 8, 8);
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
			contenedorPpal[0][columna] = new PilaGrafica();
		
		inicializarMedio(subtableroPpal);
		
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			contenedorPpal[2][columna] = new PilaGrafica();
	}
	
	private void inicializarMedio(SubtableroPrincipal subtableroPpal) {
		for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
			//contenedorPpal[1][columna] = new PilaJunta(subtableroPpal.getPila(1, columna));
			contenedorPpal[1][columna] = new PilaJunta();
	}

	private void inicializarContenedorVacio() {
		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[fila][columna] = new PilaGrafica();
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
	
	private void inicializarTablero(SubtableroPrincipal subtableroPpal)
	{
		for (int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++)
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[fila][columna].agregarCartas(subtableroPpal.getPila(fila, columna));
	}

}
