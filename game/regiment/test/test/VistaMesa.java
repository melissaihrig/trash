package test;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaMesa extends JFrame {
	
	public VistaMesa() {
	
		super();
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel lblPpal = new VistaTableroPpal();
		lblPpal.setBackground(Color.PINK);
		GridBagConstraints gbc_lblPpal = new GridBagConstraints();
		gbc_lblPpal.anchor = GridBagConstraints.CENTER;
		gbc_lblPpal.insets = new Insets(0, 0, 0, 5);
		gbc_lblPpal.gridx = 0;
		gbc_lblPpal.gridy = 0;
		panel.add(lblPpal, gbc_lblPpal);
		
		JPanel lblSec = new VistaTableroSec();
		lblSec.setBackground(Color.ORANGE);
		GridBagConstraints gbc_lblSec = new GridBagConstraints();
		gbc_lblSec.anchor = GridBagConstraints.CENTER;
		gbc_lblSec.gridx = 1;
		gbc_lblSec.gridy = 0;
		panel.add(lblSec, gbc_lblSec);
	}

	public static void main(String[] args) {
	
		JFrame frame = new VistaMesa();
		
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
