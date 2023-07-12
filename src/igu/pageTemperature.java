package igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import models.CurrencyConversion;
import models.TemperatureConversion;
import util.RoundNumeric;
import util.isNumeric;

public class pageTemperature extends JFrame {

	private JPanel jPanel;
	private final JLabel lblConversor = new JLabel("Convertidor de temperatura");
	private JTextField inputAmountTemp;
	private JLabel lblNewLabel_1;
	private JComboBox opTargetTemp;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtResposeTemp;


	/**
	 * Create the frame.
	 */
	public pageTemperature() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 492);
		jPanel = new JPanel();
		jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jPanel);
		
		inputAmountTemp = new JTextField();
		inputAmountTemp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel_1 = new JLabel("Ingresar valor:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox opOriginTemp = new JComboBox();
		opOriginTemp.setModel(new DefaultComboBoxModel(new String[] {"C - grados Celsius (°C )", "F - grados Fahrenheit (°F)", "K - grados Kelvin (°K )"}));
		opOriginTemp.setToolTipText("");
		
		opTargetTemp = new JComboBox();
		opTargetTemp.setModel(new DefaultComboBoxModel(new String[] {"C - grados Celsius (°C )", "F - grados Fahrenheit (°F)", "K - grados Kelvin (°K )"}));
		opTargetTemp.setToolTipText("");
		
		lblNewLabel_2 = new JLabel("De unidad:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblNewLabel_3 = new JLabel("a unidad:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		
		JButton btnExitTemp = new JButton("Salir");
		btnExitTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double confirm = JOptionPane.showConfirmDialog(null,
	                        "Desea salir?",
	                        "Menu", JOptionPane.YES_NO_OPTION);
	                if(confirm == 0 ) System.exit(0);
			}
		});
		
		
		
		JButton btnClearTemp = new JButton("Limpiar");
		btnClearTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		           inputAmountTemp.setText("");
	                txtResposeTemp.setText("");

	                opOriginTemp.setSelectedIndex(0);
	                opTargetTemp.setSelectedIndex(0);


				
			}
		});
		
		
		
		JButton btnConvertTemp = new JButton("Convertir");
		btnConvertTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            boolean isNumber = isNumeric.isAllNumber(inputAmountTemp.getText());

                if (isNumber){
                    TemperatureConversion tempConvert = new TemperatureConversion();

                    Double input = RoundNumeric.round(Double.parseDouble(inputAmountTemp.getText()));
                    String tempOrig   = opOriginTemp.getSelectedItem().toString().substring(0,1);
                    String tempTarget =  opTargetTemp.getSelectedItem().toString().substring(0,1);
                    Double result = RoundNumeric.round(tempConvert.cover(input,tempOrig,tempTarget));

                    txtResposeTemp.setText(input+" °"+tempOrig+" = "+result+" °"+tempTarget);

                }else {
                    JOptionPane.showMessageDialog(null,
                            "error! ingresar solamente numeros.",
                            "Menu",JOptionPane.ERROR_MESSAGE,null);
                }
				
  
				
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Resultado");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtResposeTemp = new JTextField();
		txtResposeTemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtResposeTemp.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtResposeTemp.setEditable(false);
		txtResposeTemp.setColumns(10);
		
		GroupLayout gl_jPanel = new GroupLayout(jPanel);
		gl_jPanel.setHorizontalGroup(
			gl_jPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(246)
					.addComponent(lblConversor)
					.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel.createSequentialGroup()
							.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel.createSequentialGroup()
									.addGap(154)
									.addComponent(btnExitTemp)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnClearTemp))
								.addGroup(gl_jPanel.createSequentialGroup()
									.addGap(161, 457, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addGap(79))
						.addGroup(gl_jPanel.createSequentialGroup()
							.addGap(127)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(inputAmountTemp)
								.addComponent(txtResposeTemp)
								.addComponent(opTargetTemp, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(opOriginTemp, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConvertTemp, Alignment.TRAILING))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_jPanel.setVerticalGroup(
			gl_jPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(lblConversor)
					.addGap(41)
					.addGroup(gl_jPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_jPanel.createSequentialGroup()
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(inputAmountTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(opOriginTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(opTargetTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtResposeTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(39)
					.addGroup(gl_jPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConvertTemp)
						.addComponent(btnClearTemp)
						.addComponent(btnExitTemp))
					.addGap(72))
		);
		lblConversor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel.setLayout(gl_jPanel);
	}

}
