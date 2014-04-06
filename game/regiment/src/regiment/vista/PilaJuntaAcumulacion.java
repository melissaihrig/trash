package regiment.vista;

import modelo.CartaException;
import modelo.PaloDeCartaInglesa;
import regiment.modelo.Pila;
import regiment.modelo.PilaDeAcumulacionConPalo;

public class PilaJuntaAcumulacion extends PilaGrafica {

	public PilaJuntaAcumulacion(Pila pila) {
		super(pila);
		this.cambiarPathIcono();
	}
	
	private void cambiarPathIcono() {
		String path = this.getPalo().name().toLowerCase().charAt(0) + ".png";
		super.setPath(path);
	}
	
	public PaloDeCartaInglesa getPalo() {
		return ( (PilaDeAcumulacionConPalo) this.getPila() ).getPalo();
	}
	
	void moverCarta(CartaRegiment carta) throws CartaException {
		
		if (carta.getCarta().getPaloDeCarta() != getPalo())
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
	
	protected void agregarCarta( CartaRegiment carta ) {
		
		super.agregarCarta(carta);
		carta.sacarManejadorDeEventos();
	}
}
