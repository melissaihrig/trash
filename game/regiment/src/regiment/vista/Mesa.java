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
		setLayout(new BorderLayout());
			
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JLabel("Nuevo"));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		this.tablero = new TableroGrafico(tablero);	
		getContentPane().add(this.tablero, BorderLayout.CENTER);

//		setUndecorated(true);
//		setShape(new RoundRectangle2D.Double(0, 0, 900, 500, 100, 100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(this.tablero.getAncho(), this.tablero.getAlto() + 50);
//	    this.setLocationRelativeTo(null);
	    
//	    JButton salir = new JButton("salir");
//	    salir.addMouseListener( new MouseAdapter() {
//	    	
//	    	 public void mousePressed(MouseEvent me) { 
//	             System.exit(0);
//	           } 
//		});
//	    
//	    this.add(salir, BorderLayout.SOUTH);
	}

}
