package regiment.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import regiment.modelo.TableroRegiment;
import vista.UtilVista;

@SuppressWarnings("serial")
public class Mesa extends JFrame {
	
	private TableroGrafico tablero;
	
	public Mesa(TableroRegiment tablero) 
	{
		super();
		setLayout(new BorderLayout());
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JLabel("Nuevo"));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		this.tablero = new TableroGrafico(tablero);	
		getContentPane().add(this.tablero, BorderLayout.CENTER);

		getContentPane().add(new JLabel("mensajee!!"), BorderLayout.SOUTH);
		
		
//		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();

//		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setLocationRelativeTo(null);
//        this.setSize(fullScreen)
	    this.setSize(900, 600);	  

	    
//	    JButton salir = new JButton("salir");
//	    salir.addMouseListener( new MouseAdapter() {
//	    	
//	    	 public void mousePressed(MouseEvent me) { 
//	             exit(0);
//	           } 
//		});
//	    
//	    this.add(salir);
	}
	


	public void juegoNuevo()
	{
		
	}

	public void setJuegoNuevo(TableroRegiment tablero) 
	{
//		tableroPpal.repartirCartas(tablero);

//		this.repaint();
	}
	

}
