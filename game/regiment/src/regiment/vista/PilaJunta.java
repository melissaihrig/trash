package regiment.vista;

import regiment.modelo.Pila;
import vista.carta.CartaGrafica;

public class PilaJunta extends PilaGrafica {

	public PilaJunta(Pila pila) {
		super(pila);
	}
	
	public void reordenarDibujado() {
	/* como se dibuja último el primer componente agregado, este queda por encima 
	 * de los demás. Entonces, es necesario darlo vuelta ya que queremos dibujar 
	 * el último componente último*/	
		int index = this.getCartas().size();
		
		for (CartaGrafica carta : this.getCartas()) 
		{
			index--;
			this.getContenedor().setComponentZOrder(carta, index);
		}
		
	}
}
