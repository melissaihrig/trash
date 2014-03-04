package modelo;

import java.util.List;

public class BarajaInglesa extends Baraja {

	public BarajaInglesa() 
	{
		this(1);
	}
	
	public BarajaInglesa(int cantidadDeBarajas)
	{
		super();
		List<Carta> cartas = super.getCartas();
		
		for (PaloDeCartaInglesa palo : PaloDeCartaInglesa.values()) 
		{
			for (int valor = 1; valor <= 13; valor++ )
			{
				for (int cantidad = 0; cantidad < cantidadDeBarajas; cantidad++)
				{
					cartas.add( new Carta(valor, palo) );
				}
				
			}
		}
	}
}
