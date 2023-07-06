package igu;

import models.TemperatureConversion;
import util.RoundNumeric;
import util.isNumeric;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pageTemperature extends JFrame{

    private JPanel jpanel;
    private JTextField inputAmountTemp;
    private JComboBox opTargetTemp;
    private JComboBox opOriginTemp;
    private JButton btnClearTemp;
    private JButton btnExitTemp;
    private JTextField txtResposeTemp;
    private JButton btnConvertTemp;


    public pageTemperature(){
        super("Coversor");
        setContentPane(jpanel);
        btnConvertTemp.addActionListener(new ActionListener() {
            @Override
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


        btnExitTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double confirm = JOptionPane.showConfirmDialog(null,
                        "Desea salir?",
                        "Menu", JOptionPane.YES_NO_OPTION);
                if(confirm == 0 ) System.exit(0);
            }
        });


        btnClearTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputAmountTemp.setText("");
                txtResposeTemp.setText("");

                opTargetTemp.setSelectedIndex(0);
                opOriginTemp.setSelectedIndex(0);
            }
        });

    }
}
