package healthcalc.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;

public class Vista1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHealthCalculator;
	private JTextField textFieldWeight;
	private JTextField textFieldHeight;
	private JTextField textFieldAge;
	
	
	private JComboBox comboBoxMetric;
	private JComboBox comboBoxGender;
	private JButton btnCalc;
	private JLabel lblResult;

	
	public Vista1() {
		
		setTitle("Health Calculator");
		
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.PINK);
		panelNorth.setForeground(Color.BLUE);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Health Calculator");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBackground(Color.PINK);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 15));
		panelNorth.add(lblTitle);

		JPanel panelMid = new JPanel();
		contentPane.add(panelMid, BorderLayout.CENTER);
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JPanel panelWest = new JPanel();
		panelMid.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(4, 2, 0, 1));
		
		JPanel panelWeight = new JPanel();
		panelWest.add(panelWeight);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelWeight.add(lblWeight);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setColumns(10);
		panelWeight.add(textFieldWeight);
		
		JPanel panelHeight = new JPanel();
		panelWest.add(panelHeight);
		panelHeight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelHeight.add(lblHeight);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldHeight.setColumns(10);
		panelHeight.add(textFieldHeight);
		
		JPanel panelGender = new JPanel();
		panelWest.add(panelGender);
		panelGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelGender.add(lblGender);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelGender.add(comboBoxGender);
		comboBoxGender.addItem("Male");
		comboBoxGender.addItem("Female");
		
		JPanel panelAge = new JPanel();
		panelWest.add(panelAge);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelAge.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		panelAge.add(textFieldAge);
		
		JPanel panelEast = new JPanel();
		panelMid.add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panelMetric = new JPanel();
		panelEast.add(panelMetric);
		panelMetric.setLayout(new GridLayout(2, 1, 4, 20));
		
		comboBoxMetric = new JComboBox();
		panelMetric.add(comboBoxMetric);
		comboBoxMetric.addItem("Ideal Weight");
		comboBoxMetric.addItem("Tasal Metabolic Rate");
		
		btnCalc = new JButton("Calc");
		btnCalc.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelMetric.add(btnCalc);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new BorderLayout(0, 0));
		
		JPanel panelResults = new JPanel();
		panelSouth.add(panelResults, BorderLayout.EAST);
		
		lblResult = new JLabel("RESULT:");
		lblResult.setFont(new Font("SansSerif", Font.BOLD, 11));
		panelResults.add(lblResult);
		
		pack();
		setVisible(true);
	}
	
	public int getWeight() {
		try {
			return Integer.parseInt(textFieldWeight.getText());	
		} catch (NumberFormatException e) {
			lblResult.setText("Introduce un numero valido.");
			return -1;
		}
	}
						
	public int getUserHeight() {
		try {
			return Integer.parseInt(textFieldHeight.getText());	
		} catch (NumberFormatException e) {
			lblResult.setText("Introduce un numero valido.");
			return -1;
		}
	}
	
	
	public char getGender() {
		char gender = ' ';
		if (comboBoxGender.getSelectedItem() == "Male") {
				gender = 'M';
		} else {
			gender = 'F';
		}
		return gender;
	}

	public int getAge() {
		try {
			return Integer.parseInt(textFieldAge.getText());	
		} catch (NumberFormatException e) {
			lblResult.setText("Introduce un numero valido.");
			return -1;
		}
		
		
	}
	
	public String getComboBoxMetric() {
		return (String) comboBoxMetric.getSelectedItem();
	}

	public void setResultadoIdealWeight(double resultado) {
		lblResult.setText("El peso ideal es: " + resultado);
	}	
	
	public void setResultadoTMB(double resultado) {
		lblResult.setText("El TMB es: " + resultado);
	}
	
	public void registrarControlador(ActionListener ctrl) {
		btnCalc.addActionListener(ctrl);
		btnCalc.setActionCommand("Calc");
	}
	
	public void error(String msg) {
		lblResult.setText(msg);
	}
	
	

}
