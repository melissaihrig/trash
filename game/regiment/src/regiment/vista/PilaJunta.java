package regiment.vista;

import regiment.modelo.Pila;

public class PilaJunta extends PilaGrafica {

	public PilaJunta(Pila pila) {
		super(pila);
	}
	
	public void reordenarDibujado() {
	/* como se dibuja último el primer componente agregado, este queda por encima 
	 * de los demás. Entonces, es necesario darlo vuelta ya que queremos dibujar 
	 * el último componente último*/	

		int indice = 0, cantElementos = this.getCartas().size();
		
		for (CartaRegiment carta : this.getCartas()) 
		{
			indice = cantElementos - carta.getOrden();
			getContenedor().setComponentZOrder(carta, indice);
		}
		
	}
}
