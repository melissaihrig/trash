package regiment.controlador;

import modelo.carta.BarajaInglesa;
import modelo.carta.Mazo;
import regiment.modelo.DistribuidorRegiment;
import regiment.modelo.TableroRegiment;
import regiment.vista.Mesa;

public class ControladorRegiment {

	private Mesa mesa;
	private TableroRegiment tablero;
	
	public ControladorRegiment() 
	{
		mesa = new Mesa();
		
		this.juegoNuevo();
	   
		mesa.setVisible(true);


	}
	
	public void juegoNuevo() 
	{
		Mazo mazo = new BarajaInglesa( 2 );
		mazo.mezclar();
		this.tablero = (TableroRegiment) mazo.repartirCartas( new DistribuidorRegiment() );

		mesa.setJuegoNuevo( this.tablero );
	}

}
