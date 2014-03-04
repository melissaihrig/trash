package regiment.modelo;

import modelo.Baraja;
import modelo.BarajaInglesa;
import modelo.Tablero;

public class Regiment {

	public static void main(String[] args) {

		Baraja mazo = new BarajaInglesa(2);
		mazo.mezclar();
		Tablero tablero = mazo.repartirCartas(new DistribuidorRegiment());
		System.out.print(tablero);
	}

}
