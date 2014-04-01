package test;

import regiment.modelo.TableroDePrueba;
import regiment.modelo.TableroRegiment;
import regiment.vista.paneles.Mesa;

public class VistaRegiment {
	

	public static void main(String[] args) {
	
		TableroDePrueba tableroDePrueba = new TableroDePrueba();
		
		TableroRegiment tablero = tableroDePrueba.getTablero();
		
		Mesa mesa = new Mesa(tablero);
		mesa.setVisible(true);

	}

}
