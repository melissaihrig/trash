package vista;

import javax.swing.ImageIcon;
import java.net.URL;

public class UtilVista {
	
	static public String PATH_FOLDER = "../../cartas-inglesas/";
	static public String NAME_NOCARTA = "vacio.png";


	static public ImageIcon crearImagenIcono(Object objeto, String path) 
	{
		URL imgURL = UtilVista.class.getClass().getResource( path );
		
		if (imgURL != null) 
			return new ImageIcon(imgURL);
		else
			System.err.println("No se encontró el archivo: " + path);
		
		return null;
	}
}
