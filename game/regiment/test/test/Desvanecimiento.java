package test;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Desvanecimiento extends JPanel {
	
	JLabel etiqueta;
	
	public Desvanecimiento() {
		super();
		this.setLayout(null);
		
		etiqueta = new JLabel("me desvanezco");
		etiqueta.setOpaque(true);
		etiqueta.setBounds(30, 30, 300, 40);
		etiqueta.setVisible(false);
		add(etiqueta);
		
		JButton boton = new JButton("mostrar");
		boton.setBounds(30, 90, 100, 35);
		boton.addMouseListener(new EventoDesvanecer());
		add(boton);
		
	}
	
	public class EventoDesvanecer extends MouseAdapter {
		
		Desvanecedor desvanecedor = null;

		public EventoDesvanecer() {
		
		}
		
		public void mouseClicked(MouseEvent evt) {
			etiqueta.setBackground(new Color(200, 100, 80, 120));
			etiqueta.setForeground(new Color(0, 0, 0, 220));
			etiqueta.setVisible(true);
			if (desvanecedor != null)
				desvanecedor.interrupt();
			
			desvanecedor = new Desvanecedor(Desvanecimiento.this);
			desvanecedor.start();
			
		    if (evt.getClickCount() == 3) {
		        System.out.println ("Se ha producido un triple click");
		      } else if (evt.getClickCount() == 2) {
		    	  System.out.println("Se ha producido un doble click");
		      }
		}
	}
	
	public void transparentar(int cantidad) {
		int alpha = etiqueta.getBackground().getAlpha() - cantidad;
		alpha = (alpha<0)? 0: alpha;
		etiqueta.setBackground(new Color(200, 100, 80, alpha));
		etiqueta.setForeground(new Color(0, 0, 0, alpha));
	}
	
	public int getAlpha() {
		return etiqueta.getBackground().getAlpha();
	}
	
	public void ocultarEtiqueta() {
		etiqueta.setVisible(false);
	}
	
    class Desvanecedor extends Thread {
    	
    	private Desvanecimiento desvanecimiento;
        
    	private Desvanecedor(Desvanecimiento desvanecimiento) {
    		super();
            this.desvanecimiento = desvanecimiento;
        }
    	
        public void run() {
        	
        	int alpha = this.desvanecimiento.getAlpha();
        	try {
		    	Thread.sleep(500);    	
		    	for (int veces = 0; veces < 10; veces++) {
		    		
					Thread.sleep(300);
					this.desvanecimiento.transparentar(alpha/10);
					desvanecimiento.repaint();
		    	}
		    	this.desvanecimiento.ocultarEtiqueta();
		    	
        	} catch (InterruptedException e) {
        	}
        }
    }
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new Desvanecimiento());
		
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
