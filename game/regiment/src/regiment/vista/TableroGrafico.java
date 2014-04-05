package regiment.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.CartaException;
import modelo.PaloDeCarta;
import modelo.PaloDeCartaInglesa;

import regiment.modelo.TableroRegiment;
import regiment.modelo.TableroRegiment.SubtableroPrincipal;
import regiment.modelo.TableroRegiment.SubtableroSecundario;
import regiment.vista.paneles.Dialogos;
import regiment.vista.paneles.PanelDePuntaje;
import vista.UtilVista;

@SuppressWarnings("serial")
public class TableroGrafico extends JPanel {

	private static int ANCHO_CASILLA;
	private static int ALTO_CASILLA;
	
	public final static int MARGEN_CASILLA = 8;
	
	public final static int MARGEN_SUPERIOR = 80;
	public final static int MARGEN_INFERIOR = 50;
	
	private int ALTO_TABLERO_SEC;
	private int ANCHO_TABLERO_SEC;
	private int ANCHO_TABLERO_PPAL;
	private int INICIO_TABLERO_PPAL_Y;
	private int INICIO_TABLERO_SEC_X;
	private int ALTO_TABLERO;
	private int ANCHO_TABLERO;
	
	private TableroRegiment tablero;
	
	private TableroPrincipalGrafico tableroPpal;
	private TableroSecundarioGrafico tableroSec;
	
	private Image fondo;
	
	private PanelDePuntaje panelDePuntaje;
	private int movimientos;
	
	public TableroGrafico(TableroRegiment tablero) {
		super();
		inicializarParametros();
		inicializarGrafica();
		inicializarTablero(tablero);
	}
	
	private void inicializarTablero(TableroRegiment tablero) {
		
		this.tablero = tablero;
		tableroPpal = new TableroPrincipalGrafico(tablero.subtableroPpal);
		tableroSec = new TableroSecundarioGrafico(tablero.subtableroSec);
		movimientos = 0;
	}

	public void moverCarta(CartaRegiment carta) {
		
		PilaGrafica pila = this.getPilaDestinoPorPosicion(carta);
		
		if (pila == null) {
			carta.setLocation(carta.getPosicionAnterior());
			return;
		}
		
		try {
			pila.moverCarta(carta);
			actualizarContadorDeMovimientos();
			
			if (this.tablero.ganoElJuego())
				Dialogos.dialogoGanaste(getParent());
			else if ( this.tablero.perdioElJuego() )
				Dialogos.dialogoPerdiste(getParent());
				
		} catch (CartaException e) {
			carta.setLocation(carta.getPosicionAnterior());
//			e.printStackTrace();
//			System.out.println(e.getMessage());
		} 
	}

	public void moverCartaAPilaSecundaria(CartaRegiment carta) {
		
		int fila = tableroSec.getFilaDelPalo(carta.getCarta().getPaloDeCarta());
		
		PilaGrafica pilaDestinoAs = tableroSec.getPilaGrafica(fila, 0);
		PilaGrafica pilaDestinoK = tableroSec.getPilaGrafica(fila, 1);
		
		boolean As = puedeRecibirCarta(carta, pilaDestinoAs);
		boolean K = puedeRecibirCarta(carta, pilaDestinoK);
		
		try {
			if (As && K) {
				JOptionPane.showMessageDialog(this.getParent(), "Puede ir en cualquiera de los dos mazos.");				
			}
			else if (As)
			{
				pilaDestinoAs.moverCarta(carta);
				actualizarContadorDeMovimientos();
			}
			else if (K)
			{
				pilaDestinoK.moverCarta(carta);
				actualizarContadorDeMovimientos();
			}
			
			if (this.tablero.ganoElJuego())
				Dialogos.dialogoGanaste(getParent());
			else if ( this.tablero.perdioElJuego() )
				Dialogos.dialogoPerdiste(getParent());
			
		} catch (CartaException e) {
			e.printStackTrace();
		}
		
	}

	private boolean puedeRecibirCarta(CartaRegiment carta, PilaGrafica pilaDestinoAs) {
		boolean As;
		try {
			As = pilaDestinoAs.sePuedeMoverCarta(carta); 
		} catch (CartaException eAs) {
			As = false;
		}
		return As;
	}
	
	private PilaGrafica getPilaDestinoPorPosicion(CartaRegiment carta) {
		
		PilaGrafica pila = tableroPpal.getPilaDestinoPorPosicion(carta);
		
		if (pila == null)
			return tableroSec.getPilaDestinoPorPosicion(carta);
		
		return pila;
	}

	private void inicializarParametros() {

		setTamanoCasilla();
		ALTO_TABLERO_SEC = 4 * (2 * TableroGrafico.MARGEN_CASILLA + TableroGrafico.ALTO_CASILLA);
		ANCHO_TABLERO_SEC = 2 * (2 * TableroGrafico.MARGEN_CASILLA + TableroGrafico.ANCHO_CASILLA);
		ANCHO_TABLERO_PPAL = 8 * (2 * TableroGrafico.MARGEN_CASILLA + TableroGrafico.ANCHO_CASILLA);
		INICIO_TABLERO_PPAL_Y = (int) (ALTO_TABLERO_SEC / 2 - ( MARGEN_CASILLA * 3 + ALTO_CASILLA * 1.5 ));
		INICIO_TABLERO_SEC_X = ANCHO_TABLERO_PPAL + MARGEN_CASILLA;
		
		ALTO_TABLERO = ALTO_TABLERO_SEC + MARGEN_SUPERIOR + MARGEN_INFERIOR;
		ANCHO_TABLERO = ANCHO_TABLERO_PPAL + ANCHO_TABLERO_SEC; 
	}
	
	public int getAnchoTableroSecundario() {
		return ANCHO_TABLERO_SEC;
	}

	public int getAltoTableroSecundario() {
		return ALTO_TABLERO_SEC;
	}
	
	public int getAncho() {
		return ANCHO_TABLERO; 
	}

	public int getAlto() {
		return ALTO_TABLERO; 
	}

	private void inicializarGrafica() 
	{
		setLayout(null);
		fondo = UtilVista.crearImagenIcono("../../fondo00.png").getImage();
	}

	public void setPanelPuntaje(PanelDePuntaje panel) {
		panelDePuntaje = panel;
		add(panelDePuntaje);
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

		private PilaGrafica getPilaGrafica(int x, int y) {
			return contenedorPpal[x][y];
		}
		
		private PilaGrafica getPilaDestinoPorPosicion(CartaRegiment carta) {

			PilaGrafica pila;
			Point puntoMedio = carta.getMedio();

			for(int fila = 0; fila < TableroRegiment.SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++) {
				for(int columna = 0; columna < TableroRegiment.SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++) {

					pila = getPilaGrafica(fila, columna);

					if (pila.estaDentroDeLaPila(puntoMedio.x, puntoMedio.y)) 
						return pila;
				}
			}
			
			return null;
		}
		
		private void inicializarVista() 
		{
			int margenVertical = INICIO_TABLERO_PPAL_Y + MARGEN_SUPERIOR;
			
			for ( int fila = 0; fila < SubtableroPrincipal.CANTIDAD_DE_FILAS; fila++ )
			{
				int margenHorizontal = MARGEN_CASILLA;
				
				for ( int columna = 0; columna < SubtableroPrincipal.CANTIDAD_DE_COLUMNAS; columna++ )
				{
					contenedorPpal[fila][columna].agregrarPila(TableroGrafico.this, new Point(margenHorizontal, margenVertical) );
					contenedorPpal[fila][columna].reordenarDibujado();
					margenHorizontal += 2 * MARGEN_CASILLA + ANCHO_CASILLA;
				}
				
				margenVertical += 2 * MARGEN_CASILLA + ALTO_CASILLA;
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

		private PilaGrafica getPilaDestinoPorPosicion(CartaRegiment carta) {
			
			PilaGrafica pila;
			Point puntoMedio = carta.getMedio();
			
			for(int fila = 0; fila < TableroRegiment.SubtableroSecundario.CANTIDAD_DE_FILAS; fila++) {
				for(int columna = 0; columna < TableroRegiment.SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++) {
					
					pila = getPilaGrafica(fila, columna);

					if (pila.estaDentroDeLaPila(puntoMedio.x, puntoMedio.y))
						return pila;
				}
			}
			
			return null;
		}
		
		private int getFilaDelPalo(PaloDeCarta palo) {
		
			for(int fila = 0; fila < TableroRegiment.SubtableroSecundario.CANTIDAD_DE_FILAS; fila++) {
				
				if ( palo == ((PilaJuntaAcumulacion)getPilaGrafica(fila, 0)).getPalo() ) 
					return fila;
			}
			
			return -1;
		}
		
		private PilaGrafica getPilaGrafica(int fila, int columna) {
			return contenedorSec[fila][columna];
		}

		private void inicializarContenedor(SubtableroSecundario subtableroSec) {
			for (int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++)
				for (int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++)
					contenedorSec[fila][columna] = new PilaJuntaAcumulacion(subtableroSec.getPila(fila, columna),PaloDeCartaInglesa.values()[fila]);
		}

		private void inicializarTableroSec()
		{
			int margenVertical = MARGEN_CASILLA + MARGEN_SUPERIOR;
			
			for ( int fila = 0; fila < SubtableroSecundario.CANTIDAD_DE_FILAS; fila++ )
			{
				int margenHorizontal = INICIO_TABLERO_SEC_X;
				
				for ( int columna = 0; columna < SubtableroSecundario.CANTIDAD_DE_COLUMNAS; columna++ )
				{
					contenedorSec[fila][columna].agregrarPila(TableroGrafico.this, new Point(margenHorizontal, margenVertical));
					margenHorizontal += 2 * MARGEN_CASILLA + ANCHO_CASILLA;
				}
				margenVertical += 2 * MARGEN_CASILLA + ALTO_CASILLA;
			}	
		}
	}
	
	public int getMedioHorizontal(int ancho) {
		return ( ANCHO_TABLERO - ancho ) / 2;
	}

	/* borra todos los elementos que se encuentran en el tablero*/
	public void empezarJuegoNuevo(TableroRegiment tablero) {
		borrarPilas();
		inicializarTablero(tablero);
		reiniciarContadorDeMovimientos();
	}

	private void borrarPilas() {
		removeAll();
		revalidate();
		repaint();
	}
	
	private void actualizarContadorDeMovimientos() {
		movimientos++;
		this.panelDePuntaje.actualizarContador(movimientos);
		
	}

	private void reiniciarContadorDeMovimientos() {
		movimientos = 0;
		
		if (this.panelDePuntaje != null ) {
			panelDePuntaje.actualizarContador(movimientos);
			add(panelDePuntaje);
		}
		
	}

}
