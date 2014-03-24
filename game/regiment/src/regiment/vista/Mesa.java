package regiment.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class Mesa extends JFrame {
	
	public Mesa(TableroRegiment tablero) 
	{
		super("Regiment");
		setLayout(new BorderLayout());
		
		TableroGrafico tableroGrafico = new TableroGrafico(tablero);	
		getContentPane().add(tableroGrafico, BorderLayout.CENTER);
		
		JPanel menu = new Menu();
		menu.setLocation(tableroGrafico.getMedioHorizontal(Menu.ANCHO), 1);
		
		tableroGrafico.add(menu);

//		setUndecorated(true);
//		setShape(new RoundRectangle2D.Double(0, 0, 900, 500, 100, 100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(tableroGrafico.getAncho(), tableroGrafico.getAlto() + 50);
//	    this.setLocationRelativeTo(null);
	    
	}
	
	public void setTablero(TableroRegiment tablero) {
		
	}

}
