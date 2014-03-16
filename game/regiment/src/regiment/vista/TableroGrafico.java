package regiment.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.CartaException;

import regiment.modelo.TableroRegiment;
import regiment.modelo.TableroRegiment.SubtableroPrincipal;
import regiment.modelo.TableroRegiment.SubtableroSecundario;
import vista.UtilVista;

@SuppressWarnings("serial")
public class TableroGrafico extends JPanel {

	static int ANCHO_CASILLA;
	static int ALTO_CASILLA;
	static int MARGEN = 8;
	
	private int ALTO_TABLERO;
	private int ANCHO_TABLERO_PPAL;
	private int INICIO_TABLERO_PPAL_Y;
	private int INICIO_TABLERO_SEC_X;
	
	private TableroPrincipalGrafico tableroPpal;
	private TableroSecundarioGrafico tableroSec;
	
	private Image fondo;
	
	public TableroGrafico(TableroRegiment tablero) {
		super();
		inicializarParametros();
		inicializar(tablero);
	}
	
	public void moverCarta(CartaRegiment carta) {
		
		PilaGrafica pila = this.getPilaDestino(carta);
		
		if (pila == null)
			return;
		
		try {
			pila.moverCarta(carta);
		} catch (CartaException e) {
			carta.setLocation(carta.getPosicionAnterior());
			e.printStackTrace();
		}
	}
	
	private PilaGrafica getPilaDestino(CartaRegiment carta) {
		
		PilaGrafica pila;
		Point puntoMedio = carta.getMedio();

		for(int fila = 0; fila < TableroRegiment.SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++) {
			for(int columna = 0; columna < TableroRegiment.SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++) {

				pila = tableroPpal.getPilaGrafica(fila, columna);

				if (pila.estaDentroDeLaPila(puntoMedio.x, puntoMedio.y)) 
					return pila;
			}
		}
		
		for(int fila = 0; fila < TableroRegiment.SubtableroSecundario.CANTIDAD_DE_FILAS; fila++) {
			for(int columna = 0; columna < TableroRegiment.SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++) {
				
				pila = tableroSec.getPilaGrafica(fila, columna);

				if (pila.estaDentroDeLaPila(puntoMedio.x, puntoMedio.y))
					return pila;
			}
		}
		
		return null;
	}
		
	private void inicializarParametros() {

		setTamanoCasilla();
		ALTO_TABLERO = 4 * (2 * TableroGrafico.MARGEN + TableroGrafico.ALTO_CASILLA);
		ANCHO_TABLERO_PPAL = 8 * (2 * TableroGrafico.MARGEN + TableroGrafico.ANCHO_CASILLA);
		INICIO_TABLERO_PPAL_Y = (int) (ALTO_TABLERO / 2 - ( MARGEN * 3 + ALTO_CASILLA * 1.5 ));
		INICIO_TABLERO_SEC_X = ANCHO_TABLERO_PPAL + MARGEN;
	}
	
	private void inicializar(TableroRegiment tablero) 
	{
		setLayout(null);
		fondo = UtilVista.crearImagenIcono("../../fondo00.png").getImage();

		tableroPpal = new TableroPrincipalGrafico(tablero.subtableroPpal);
		tableroSec = new TableroSecundarioGrafico(tablero.subtableroSec);
	}
	
	private void setTamanoCasilla() {
		
		JLabel fondo = new JLabel();
		fondo.setIcon( UtilVista.crearImagenIcono( UtilVista.PATH_FOLDER + UtilVista.NAME_NOCARTA ) );
		fondo.setSize(fondo.getMaximumSize());
		
		ANCHO_CASILLA = fondo.getWidth();
		ALTO_CASILLA = fondo.getHeight();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0, null);
	}
	
	private class TableroPrincipalGrafico{

		private PilaGrafica contenedorPpal[][];

		public TableroPrincipalGrafico(SubtableroPrincipal subtableroPpal) {

			this.contenedorPpal = new PilaGrafica[SubtableroPrincipal.CANTIDAD_DE_FILAS][SubtableroPrincipal.CANTIDAD_DE_COLUMNAS];
			
			this.inicializarContenedor(subtableroPpal);
			this.inicializarVista();	
		}

		PilaGrafica getPilaGrafica(int x, int y) {
			return contenedorPpal[x][y];
		}
		
		private void inicializarVista() 
		{
			int margenVertical = INICIO_TABLERO_PPAL_Y;
			
			for ( int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++ )
			{
				int margenHorizontal = MARGEN;
				
				for ( int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++ )
				{
					contenedorPpal[fila][columna].agregrarPila(TableroGrafico.this, new Point(margenHorizontal, margenVertical) );
					contenedorPpal[fila][columna].reordenarDibujado();
					margenHorizontal += 2 * MARGEN + ANCHO_CASILLA;
				}
				
				margenVertical += 2 * MARGEN + ALTO_CASILLA;
			}		
		}

		private void inicializarContenedor(SubtableroPrincipal subtableroPpal)
		{
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[0][columna] =  new PilaEscaleraArriba(subtableroPpal.getPila(0, columna));
			
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[1][columna] = new PilaJunta(subtableroPpal.getPila(1, columna));	
			
			for (int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++)
				contenedorPpal[2][columna] = new PilaEscaleraAbajo(subtableroPpal.getPila(2, columna));
		}
	}
	
	private class TableroSecundarioGrafico{

		private PilaGrafica contenedorSec[][];

		public TableroSecundarioGrafico(SubtableroSecundario subtableroSec) {

			this.contenedorSec = new PilaGrafica[SubtableroSecundario.CANTIDAD_DE_FILAS][SubtableroSecundario.CANTIDAD_DE_COLUMNAS];
			this.inicializarContenedor(subtableroSec);
			this.inicializarTableroSec();
		}

		public PilaGrafica getPilaGrafica(int fila, int columna) {
			return contenedorSec[fila][columna];
		}

		private void inicializarContenedor(SubtableroSecundario subtableroSec) {
			for (int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++)
				for (int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++)
					contenedorSec[fila][columna] = new PilaJunta(subtableroSec.getPila(fila, columna));
		}

		private void inicializarTableroSec()
		{
			int margenVertical = MARGEN;
			
			for ( int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++ )
			{
				int margenHorizontal = INICIO_TABLERO_SEC_X;
				
				for ( int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++ )
				{
					contenedorSec[fila][columna].agregrarPila(TableroGrafico.this, new Point(margenHorizontal, margenVertical));
					margenHorizontal += 2 * MARGEN + ANCHO_CASILLA;
				}
				margenVertical += 2 * MARGEN + ALTO_CASILLA;
			}	
		}
	}
}
