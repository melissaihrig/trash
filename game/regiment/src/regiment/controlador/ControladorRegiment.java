package regiment.controlador;

import modelo.Baraja;
import modelo.BarajaInglesa;
import regiment.modelo.DistribuidorRegiment;
import regiment.modelo.TableroRegiment;
import regiment.vista.Mesa;

public class ControladorRegiment {

	private Mesa mesa;
	private TableroRegiment tablero;
	
	private static ControladorRegiment controlador = null;
	
	private ControladorRegiment() 
	{
		tablero = this.juegoNuevo();
		mesa = new Mesa(tablero);
		mesa.setVisible(true);
	}
	
	public static ControladorRegiment getInstancia() {
		
		if (controlador == null)
			controlador = new ControladorRegiment();
		
		return controlador;
	}
	
	public TableroRegiment juegoNuevo() 
	{
		Baraja baraja = new BarajaInglesa( 2 );
		baraja.mezclar();
		return (TableroRegiment) baraja.repartirCartas( new DistribuidorRegiment() );
	}

}
