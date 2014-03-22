package regiment.evento;

import java.awt.event.MouseEvent;

import regiment.vista.CartaRegiment;
import regiment.vista.TableroGrafico;

/**
 * Es necesario haber agregado la Carta al Contenedor antes de agregarle este
 * manejador de eventos
 * **/
public class EventoCartaRegiment extends ManejadorDeEventosDeCarta{

	private TableroGrafico contenedor;
	
	public EventoCartaRegiment(CartaRegiment carta) {
		super(carta);
		this.contenedor = (TableroGrafico) carta.getParent();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		contenedor.moverCarta( (CartaRegiment) this.getCarta() );
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
	      
		if (evt.getClickCount() == 2) {
			contenedor.moverCartaAPilaSecundaria( (CartaRegiment) this.getCarta());
		}
	}

}
