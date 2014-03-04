package modelo;

public class Carta {

	private int valor;
	private PaloDeCarta palo;
	
	public Carta(int valor, PaloDeCarta palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	@Override
	public boolean equals( Object object )
	{
		Carta carta = (Carta) object;
		
		if (carta.getValor() == this.valor && carta.getPaloDeCarta() == this.palo )
			return true;
		
		return false;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public PaloDeCarta getPaloDeCarta() {
		return this.palo;
	}
	
	public boolean esDelMismoPaloQue( Carta carta ) {
		return this.getPaloDeCarta() == carta.getPaloDeCarta();
	}

	@Override
	public String toString() {
		return "[" + valor + "; " + palo + "]";
	}

}
