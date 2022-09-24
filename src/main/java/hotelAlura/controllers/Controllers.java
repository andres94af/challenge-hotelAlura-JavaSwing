package hotelAlura.controllers;

import javax.swing.JOptionPane;

import hotelAlura.jFrame.FrameNuevoHuesped;
import hotelAlura.jFrame.TablaListaHuespedes;
import hotelAlura.jFrame.TablaListaReservas;

public class Controllers {


	public void verOpciones() {
		String seleccion = JOptionPane.showInputDialog(null, "Seleccione que desea hacer.", "Hotel Alura",
				JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Iniciar una reserva", "Ver reservas", "Ver huespedes", "Cerrar sesion y salir", },
				"Iniciar una reserva").toString();
		switch (seleccion) {
		case "Iniciar una reserva":
			JOptionPane.showMessageDialog(null, "Primero ingresará los datos del huesped", "Hotel Alura",
					JOptionPane.INFORMATION_MESSAGE);
			FrameNuevoHuesped nuevoHuesped = new FrameNuevoHuesped();
			nuevoHuesped.setVisible(true);
			break;
		case "Ver reservas":
			TablaListaReservas reservas = new TablaListaReservas();
			reservas.setVisible(true);
			break;
		case "Ver huespedes":
			TablaListaHuespedes huespedes = new TablaListaHuespedes();
			huespedes.setVisible(true);
			break;
		case "Cerrar sesion y salir":
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere salir?");
			if (JOptionPane.OK_OPTION == resp) {
				System.exit(0);
			}
			break;
		}
	}
}