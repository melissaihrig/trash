package regiment.vista;

import modelo.CartaException;
import modelo.PaloDeCarta;
import modelo.PaloDeCartaInglesa;
import regiment.modelo.Pila;

public class PilaJuntaAcumulacion extends PilaGrafica {

	private PaloDeCartaInglesa palo;
	
	public PilaJuntaAcumulacion(Pila pila, PaloDeCartaInglesa palo) {
		super(pila);
		this.palo = palo;
		this.cambiarPathIcono(palo);
	}
	
	private void cambiarPathIcono(PaloDeCartaInglesa palo) {
		String path = palo.name().toLowerCase().charAt(0) + ".png";
		super.setPath(path);
	}
	
	public PaloDeCarta getPalo() {
		return palo;
	}
	
	void moverCarta(CartaRegiment carta) throws CartaException {
		
		if (carta.getCarta().getPaloDeCarta() != palo)
			throw new CartaException("Movimiento inválido");
		
		super.moverCarta(carta);
		
		
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
