package regiment.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class Mesa extends JFrame {
	
	private TableroGrafico tablero;
	
	public Mesa(TableroRegiment tablero) 
	{
		super();
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JLabel("Nuevo"));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		this.tablero = new TableroGrafico(tablero);
		getContentPane().add(this.tablero, BorderLayout.CENTER);

		
//		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();

//		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setLocationRelativeTo(null);
//        this.setSize(fullScreen);
	    this.setSize(1400, 700);	  

	    
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
