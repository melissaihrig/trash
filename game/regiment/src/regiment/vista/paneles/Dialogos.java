package regiment.vista.paneles;

import java.awt.Component;

import javax.swing.JOptionPane;

import regiment.controlador.ControladorRegiment;

public class Dialogos {
	
	public static void dialogoPerdiste(Component ventanaPadre) {

		Object[] options = {"Nuevo", "Volver"};
		
		int resultado = JOptionPane.showOptionDialog(ventanaPadre,
				"Perdiste, ¿quieres empezar un juego nuevo o volver al juego actual?",
				"Perdiste",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		
		if (resultado == 0) {
			ControladorRegiment.getInstancia().juegoNuevo();
		}
		
	}

	public static void dialogoGanaste(Component ventanaPadre) {
		
		Object[] options = {"Nuevo", "Volver"};
		
		int resultado = JOptionPane.showOptionDialog(ventanaPadre,
				"Has ganado, ¿quieres empezar un juego nuevo?",
				"Felicitaciones",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);
		
		if (resultado == 0) {
			ControladorRegiment.getInstancia().juegoNuevo();
		}
	}

}
