import igu.CoinsPage;
import igu.pageTemperature;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] opciones = {"Conversor de monedas","Conversor de temperatura"};


        Object selection = JOptionPane.showInputDialog(
                null,
                "Seleccione opcion de conversión",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, opciones, 0);

        if (selection == opciones[0]){
     
    		try {
				CoinsPage frame = new CoinsPage();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
  
        }else {
            //temperature pageTemperature
    		try {
				pageTemperature frame = new pageTemperature();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

        }

    }



}