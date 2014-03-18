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
		contenedor.moverCarta( (CartaRegiment) this.getCarta() );
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
	      
		if (evt.getClickCount() == 2) {
			contenedor.moverCartaAPilaSecundaria( (CartaRegiment) this.getCarta());
	    	  System.out.println("Se ha producido un doble click");
	      }
	}

}
