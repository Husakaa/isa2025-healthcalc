package healthcalc.gui;

import java.awt.EventQueue;

import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = HealthCalcImpl.getInstance(); // Llamamos a la instancia única (Patrón Singleton)
					Vista1 vista = new Vista1();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
