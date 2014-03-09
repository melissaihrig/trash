package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import regiment.vista.TableroPrincipalGrafico;
import regiment.vista.TableroSecundarioGrafico;

@SuppressWarnings("serial")
public class VistaMesaDistribucion extends JFrame {

	public VistaMesaDistribucion() 
	{
		super();
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(new JLabel("Nuevo"));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(150,44,150));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		
		panel.setLayout(gbl_panel);
		
		TableroPrincipalGrafico tableroPpal = new TableroPrincipalGrafico();
		tableroPpal.setBackground(Color.PINK);
		GridBagConstraints gbc_lblPpal = new GridBagConstraints();
		gbc_lblPpal.anchor = GridBagConstraints.EAST;
		gbc_lblPpal.insets = new Insets(0, 0, 5, 40);
		gbc_lblPpal.gridx = 0;
		gbc_lblPpal.gridy = 1;
		panel.add(tableroPpal, gbc_lblPpal);
		
		TableroSecundarioGrafico tableroSec = new TableroSecundarioGrafico();
		tableroSec.setBackground(Color.ORANGE);
		GridBagConstraints gbc_lblSec = new GridBagConstraints();
		gbc_lblSec.insets = new Insets(0, 40, 5, 0);
		gbc_lblSec.anchor = GridBagConstraints.WEST;
		gbc_lblSec.gridx = 1;
		gbc_lblSec.gridy = 1;
		panel.add(tableroSec, gbc_lblSec);

		getContentPane().add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(1500, 700);	  
	    
	}
	


	public static void main(String[] args) {
	
		JFrame frame = new VistaMesaDistribucion();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
