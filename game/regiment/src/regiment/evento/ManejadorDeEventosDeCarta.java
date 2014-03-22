package regiment.evento;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import regiment.vista.CartaRegiment;

import vista.carta.CartaGrafica;

public class ManejadorDeEventosDeCarta extends MouseAdapter {

	private CartaGrafica carta;
	private Point posicionInicialDrag;
	
	public ManejadorDeEventosDeCarta(CartaGrafica carta)
	{
		this.carta = carta;
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		Point posicion = carta.getLocation();
		posicion.translate(e.getX(), e.getY());
		posicion.translate(-posicionInicialDrag.x, -posicionInicialDrag.y);
		
		carta.setLocation(posicion.x, posicion.y);
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if (this.getCarta() != ((CartaRegiment)this.getCarta()).getPila().getUltimaCarta())
			return;
		
		posicionInicialDrag = e.getPoint();
		this.carta.getParent().setComponentZOrder(this.carta, 0);
	}
	
	protected CartaGrafica getCarta() {
		return carta;
	}

}
