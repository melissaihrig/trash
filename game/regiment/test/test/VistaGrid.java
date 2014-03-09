package test;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VistaGrid extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaGrid() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("0,0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel lblAsa = new JLabel("asa");
		GridBagConstraints gbc_lblAsa = new GridBagConstraints();
		gbc_lblAsa.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsa.gridx = 1;
		gbc_lblAsa.gridy = 0;
		add(lblAsa, gbc_lblAsa);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JLabel lblAllgoo = new JLabel("Allgoo");
		lblAllgoo.setBounds(50, 62, 70, 15);
		panel.add(lblAllgoo);
		
		JLabel lblOtrooo = new JLabel("otrooo...");
		lblOtrooo.setBounds(12, 127, 70, 15);
		panel.add(lblOtrooo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		JLabel lblNose = new JLabel("nose");
		lblNose.setBounds(95, 73, 35, 15);
		panel_1.add(lblNose);
		
		JLabel label_1 = new JLabel("2,0");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		JLabel lblAsas = new JLabel("asas");
		GridBagConstraints gbc_lblAsas = new GridBagConstraints();
		gbc_lblAsas.gridx = 1;
		gbc_lblAsas.gridy = 2;
		add(lblAsas, gbc_lblAsas);

	}
}
