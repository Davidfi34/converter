package igu;

import models.CurrencyConversion;
import org.json.JSONObject;
import util.isNumeric;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CoinsPage extends JFrame{
 private JPanel jpanel1;
    private JTextField inputAmount;
    private JButton btnConvert;
    private JComboBox opOriginal;
    private JComboBox opTarget;
    private JButton btnClear;
    private JButton btnExit;
    private JTextField txtRespose;


    public CoinsPage(){
        super("Coversor");
        setContentPane(jpanel1);


        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isNumber = isNumeric.isPositiveNumber(inputAmount.getText());


                if (isNumber){
                    CurrencyConversion CyConversion = new CurrencyConversion();

                    Double input = Double.parseDouble(inputAmount.getText());
                    String opObj = opOriginal.getSelectedItem().toString().substring(0,3);
                    String opTarg = opTarget.getSelectedItem().toString().substring(0,3);

                    JSONObject result = CyConversion.getData(input, opObj, opTarg);

                    Double caculatedValue =  result.getDouble("conversion_result");
                    //String timeLastUpdate =  String.valueOf(result.getString("time_last_update_utc"));

                    txtRespose.setText(input +" "+ opObj +"  =  "+caculatedValue +" "+ opTarg );
                }else {
                    JOptionPane.showMessageDialog(null,
                            "error! Utiliza un número positivo.",
                            "Menu",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });


        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputAmount.setText("");
                txtRespose.setText("");

                opOriginal.setSelectedIndex(0);
                opTarget.setSelectedIndex(0);


            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double confirm = JOptionPane.showConfirmDialog(null,
                        "Desea salir?",
                        "Menu", JOptionPane.YES_NO_OPTION);
                if(confirm == 0 ) System.exit(0);
            }
        });
    }


}
