package regiment.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import regiment.modelo.TableroRegiment;


public class Mesa extends JFrame {
	
	private TableroPrincipalGrafico tableroPpal;
	private TableroSecundarioGrafico tableroSec;
	
	public Mesa() 
	{
		super();
		
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		this.addPanelJuego();

		
//		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();

//		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setLocationRelativeTo(null);
//        this.setSize(fullScreen);
	    this.setSize(1000, 700);	  

	    
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
		tableroPpal.repartirCartas(tablero);

		this.repaint();
	}
	
	private void addPanelJuego() 
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		tableroPpal = new TableroPrincipalGrafico();
		tableroPpal.setBackground(Color.PINK);
		GridBagConstraints gbc_lblPpal = new GridBagConstraints();
		gbc_lblPpal.anchor = GridBagConstraints.CENTER;
		gbc_lblPpal.insets = new Insets(0, 0, 0, 5);
		gbc_lblPpal.gridx = 0;
		gbc_lblPpal.gridy = 0;
		panel.add(tableroPpal, gbc_lblPpal);
		
		tableroSec = new TableroSecundarioGrafico();
		tableroSec.setBackground(Color.ORANGE);
		GridBagConstraints gbc_lblSec = new GridBagConstraints();
		gbc_lblSec.anchor = GridBagConstraints.CENTER;
		gbc_lblSec.gridx = 1;
		gbc_lblSec.gridy = 0;
		panel.add(tableroSec, gbc_lblSec);
		
	}
}
