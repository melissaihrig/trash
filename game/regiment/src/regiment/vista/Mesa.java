package regiment.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class Mesa extends JFrame {
	
	private TableroGrafico tableroGrafico;
	private JPanel menu;
	
	public Mesa(TableroRegiment tablero) 
	{
		super("Regiment");
		setLayout(new BorderLayout());
		
		tableroGrafico = new TableroGrafico(tablero);
		getContentPane().add(tableroGrafico, BorderLayout.CENTER);
		
		menu = new Menu();
		int posX = tableroGrafico.getAncho() - tableroGrafico.getAnchoTableroSecundario() + (tableroGrafico.getAnchoTableroSecundario() - Menu.ANCHO)/2;
		menu.setLocation(posX, TableroGrafico.MARGEN_CASILLA);
		
		tableroGrafico.add(menu);
		
		this.setResizable(false);
//		setUndecorated(true);
//		setShape(new RoundRectangle2D.Double(0, 0, 900, 500, 100, 100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(tableroGrafico.getAncho(), tableroGrafico.getAlto() + 50);
//	    this.setLocationRelativeTo(null);
	    
	}

	public void empezarJuegoNuevo(TableroRegiment tablero) {
		tableroGrafico.empezarJuegoNuevo(tablero);
		tableroGrafico.add(menu);
	}

}
