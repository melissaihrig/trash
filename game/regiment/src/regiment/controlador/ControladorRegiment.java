package regiment.controlador;

import modelo.Baraja;
import modelo.BarajaInglesa;
import regiment.modelo.DistribuidorRegiment;
import regiment.modelo.TableroRegiment;
import regiment.vista.paneles.Mesa;

public class ControladorRegiment {

	private Mesa mesa;
	private TableroRegiment tablero;
	
	private static ControladorRegiment controlador = null;
	
	private ControladorRegiment() 
	{
		tablero = this.generarJuegoNuevo();
		mesa = new Mesa(tablero);
		mesa.setVisible(true);
	}
	
	public static ControladorRegiment getInstancia() {
		
		if (controlador == null)
			controlador = new ControladorRegiment();
		
		return controlador;
	}
	
	public TableroRegiment generarJuegoNuevo() 
	{
		Baraja baraja = new BarajaInglesa( 2 );
		baraja.mezclar();
		return (TableroRegiment) baraja.repartirCartas( new DistribuidorRegiment() );
	}

	public void juegoNuevo() {
		
		tablero = this.generarJuegoNuevo();
		mesa.empezarJuegoNuevo(tablero);
	}
}
