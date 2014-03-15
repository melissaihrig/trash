package regiment.evento;

import java.awt.event.MouseEvent;

import regiment.vista.CartaRegiment;
import regiment.vista.TableroGrafico;

public class EventoCartaRegiment extends ManejadorDeEventosDeCarta{

	private TableroGrafico contenedor;
	
	public EventoCartaRegiment(CartaRegiment carta, TableroGrafico contenedor) {
		super(carta);
		this.contenedor = contenedor;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		contenedor.moverCarta( (CartaRegiment) this.getCarta(), e.getPoint());
	}


}
