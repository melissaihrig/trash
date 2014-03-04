package regiment.controlador;

import modelo.Baraja;
import modelo.BarajaInglesa;
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
		Baraja baraja = new BarajaInglesa( 2 );
		baraja.mezclar();
		this.tablero = (TableroRegiment) baraja.repartirCartas( new DistribuidorRegiment() );

		mesa.setJuegoNuevo( this.tablero );
	}

}
