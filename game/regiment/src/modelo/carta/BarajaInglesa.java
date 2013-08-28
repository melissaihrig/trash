package modelo.carta;

import java.util.List;

public class BarajaInglesa extends Mazo {

	public BarajaInglesa() 
	{
		this(1);
	}
	
	public BarajaInglesa(int cantidadDeMazos)
	{
		super();
		List<Carta> cartas = super.getCartas();
		
		for (PaloDeCartaInglesa palo : PaloDeCartaInglesa.values()) 
		{
			for (int valor = 1; valor <= 13; valor++ )
			{
				for (int cantidad = 0; cantidad < cantidadDeMazos; cantidad++)
				{
					cartas.add( new Carta(valor, palo) );
				}
				
			}
		}
	}
}
