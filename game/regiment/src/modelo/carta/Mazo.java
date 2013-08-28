package modelo.carta;

import java.util.LinkedList;
import java.util.List;


public abstract class Mazo {

	private List<Carta> cartas;
	
	public Mazo()
	{
		this.cartas = new LinkedList<>();
	}
	
	public void mezclar() 
	{
		int numeroCarta, cantidadDeCartas = this.getCantidadDeCartas();
		List<Carta> mazoMezclado = new LinkedList<>();
		
		while (cantidadDeCartas != 0)
		{
			numeroCarta = (int) Math.floor( Math.random() * cantidadDeCartas );
			mazoMezclado.add( this.cartas.get( numeroCarta ) );
			this.cartas.remove(numeroCarta);
			cantidadDeCartas = this.getCantidadDeCartas();		
		}
		
		this.cartas = mazoMezclado;
	}
	
	public Tablero repartirCartas( DistribuidorDeCartas distribuidor )
	{
		return distribuidor.ejecutarLogica( this );
	}
	
	public Carta getCartaDeArriba() {
		return this.cartas.remove(0);
	}
	
	/**
	 * 
	 * @param cartaABuscar 
	 * @return la cantidad de veces que se encuentra esa carta en el mazo.
	 */
	public int tieneLaCarta( Carta cartaABuscar )
	{
		int cantidad = 0;
		
		for (Carta carta : this.cartas) 
		{
			if (carta.equals(cartaABuscar))
				cantidad++;
		}
		
		return cantidad;
	}
	
	protected List<Carta> getCartas() {
		return cartas;
	}
	
	public int getCantidadDeCartas() {
		return cartas.size();
	}
	
	@Override
	public String toString() 
	{
		String mazo = "";
		
		for (Carta carta : this.cartas) 
			mazo += carta.toString() + "\n";
		
		return mazo;
	}
}
