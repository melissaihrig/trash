package regiment.vista;

import regiment.modelo.Pila;

public class PilaEscalera extends PilaGrafica {
	
	public PilaEscalera(Pila pila) {
		super(pila);
		reordenarDibujado();
	}
	
	public void reordenarDibujado() {
	/* como se dibuja último el primer componente agregado, este queda por encima 
	 * de los demás. Entonces, es necesario darlo vuelta ya que queremos dibujar 
	 * el último componente último*/	
//		int index = this.getComponentCount();
//		for (Component componente: this.getComponents()) 
//		{
//			index--;
//			this.setComponentZOrder(componente, index);
//		}
//		
//		this.setBackground(new Color (120,12,12));
//		this.setSize(220, 200);
	}
}
