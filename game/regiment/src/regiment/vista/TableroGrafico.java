package regiment.vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import regiment.modelo.TableroRegiment;

@SuppressWarnings("serial")
public class TableroGrafico extends JPanel {

//	private TableroPrincipalGrafico tableroPpal;
//	private TableroSecundarioGrafico tableroSec;
	
	public TableroGrafico(TableroRegiment tablero) {
		super();
		inicializar(tablero);
	}
	
	public void dibujar() {
		
	}

	
	private void inicializar(TableroRegiment tablero) 
	{
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		
		setLayout(gbl_panel);
		
		TableroPrincipalGrafico tableroPpal = new TableroPrincipalGrafico(tablero.subtableroPpal);
		tableroPpal.setBackground(Color.PINK);
		GridBagConstraints gbc_lblPpal = new GridBagConstraints();
		gbc_lblPpal.anchor = GridBagConstraints.EAST;
		gbc_lblPpal.insets = new Insets(0, 0, 5, 40);
		gbc_lblPpal.gridx = 0;
		gbc_lblPpal.gridy = 1;
		add(tableroPpal, gbc_lblPpal);
		
		TableroSecundarioGrafico tableroSec = new TableroSecundarioGrafico(tablero.subtableroSec);
		tableroSec.setBackground(Color.ORANGE);
		GridBagConstraints gbc_lblSec = new GridBagConstraints();
		gbc_lblSec.insets = new Insets(0, 40, 5, 0);
		gbc_lblSec.anchor = GridBagConstraints.WEST;
		gbc_lblSec.gridx = 1;
		gbc_lblSec.gridy = 1;
		add(tableroSec, gbc_lblSec);
		
	}
}
