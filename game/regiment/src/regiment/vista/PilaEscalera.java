package regiment.vista;

import regiment.modelo.Pila;

public abstract class PilaEscalera extends PilaGrafica {
	
	protected final int DIST_Y = 20;
	
	public PilaEscalera(Pila pila) {
		super(pila);
		reordenarDibujado();
	}
			
	public void reordenarDibujado() {
		
		int indiceMax = this.getCartas().size();
		int indice;
		
		for (CartaRegiment carta: this.getCartas()) 
		{ 
			indice = indiceMax - carta.getOrden();
			getContenedor().setComponentZOrder(carta, indice);
		}
		
		reposicionar();
	}

	protected abstract void reposicionar();

}
