package regiment.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PanelDePuntaje extends JPanel {
	
	public final static int TAMANO_LETRA = 14;
	public final static int ANCHO = 150;
	public final static int ALTO = 50;
	
	private JLabel contador;
	
	public PanelDePuntaje() {
		super();
		
		JLabel titulo = new JLabel("Movimientos");
		setLayout(new GridLayout(2, 1, 0, 3));
		
		darFormatoA(titulo);
		add(titulo);
		
		contador = new JLabel("0");
		darFormatoA(contador);
		add(contador);
		
		darFormatoAlPanel();
	}
	
	private void darFormatoAlPanel() {
		this.setSize(ANCHO + 7, ALTO + 7);
		this.setBackground(new Color(0,0,0,0));
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setColor(Tema.MARRON2);
	    g2.setStroke(new BasicStroke(2.0f));
        RoundRectangle2D.Float fondo = new RoundRectangle2D.Float (3, 3, ANCHO, ALTO, 45, 45);
        g2.draw(fondo);
        
        g2.setColor(Tema.MARRON2_100);
        g2.fill(fondo);
	  }
	
	private void darFormatoA(JLabel etiqueta) {
		etiqueta.setFont(new Font (etiqueta.getName(), Font.BOLD, TAMANO_LETRA));
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void actualizarContador(int puntaje) {
		contador.setText(Integer.toString(puntaje));
	}
}
