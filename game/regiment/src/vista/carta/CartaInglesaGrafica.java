package vista.carta;

import vista.UtilVista;
import modelo.Carta;

public class CartaInglesaGrafica extends CartaGrafica {
	
	public CartaInglesaGrafica( Carta carta )
	{
		super(carta);
		
		this.setImagenCarta( this.generarPath() );
		super.setSize(super.getMaximumSize());
		
	}

	private String generarPath()
	{
		String path = UtilVista.PATH_FOLDER;
		char letraPalo = super.getCarta().getPaloDeCarta().toString().toLowerCase().charAt(0);
		 
		path += letraPalo;
		path += Integer.toString( super.getCarta().getValor() );
		path += ".png";
		
		return path;
	}
}
