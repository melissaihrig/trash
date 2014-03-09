package regiment.vista;

import java.awt.Color;
import java.awt.Component;

import regiment.modelo.Pila;

@SuppressWarnings("serial")
public class PilaJunta extends PilaGrafica {

	public PilaJunta() {
		super(null);
	}
	
	public PilaJunta(Pila pila) {
		super(null, pila);
//		reordenarDibujado();
	}
	
	private void reordenarDibujado() {
	/* como se dibuja último el primer componente agregado, este queda por encima 
	 * de los demás. Entonces, es necesario darlo vuelta ya que queremos dibujar 
	 * el último componente último*/	
		int index = this.getComponentCount();
		for (Component componente: this.getComponents()) 
		{
			index--;
			this.setComponentZOrder(componente, index);
		}
		
	}
	
	public void agregarCartas(Pila pila) {
		this.setLayout(null);
		super.agregarCartas(pila);
		reordenarDibujado();
	}

	
	protected void agregarComponente(Component componente) {
		componente.setLocation(0,0);
		this.add(componente);
	}
}
