package healthcalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalcImpl;

public class Controlador implements ActionListener {
	
	private HealthCalcImpl modelo;
	private Vista1 vista;
	
	public Controlador(HealthCalcImpl modelo, Vista1 vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Calc")) {
			if (vista.getComboBoxMetric().equals("Ideal Weight")) {
				int height = vista.getUserHeight();
				char gender = vista.getGender();
				
				try {
					double resultado = modelo.idealWeight(height, gender);	
					vista.setResultadoIdealWeight(resultado);
				} catch (Exception error) {
					vista.error(error.getMessage());
				}
				
			} else {
				int height = vista.getUserHeight();
				char gender = vista.getGender();
				int weight = vista.getWeight();
				int age = vista.getAge();
				
				try {
					double resultado = modelo.basalMetabolicRate(weight, height, age, gender);	
					vista.setResultadoTMB(resultado);
				} catch (Exception error) {
					vista.error(error.getMessage());
				}
			}
		
			
			
			
			
			
			
			
			
		}
	}

}
