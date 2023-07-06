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
            //coins page
            SwingUtilities.invokeLater(() -> {
                        CoinsPage coinsPage = new CoinsPage();
                        coinsPage.setSize(550,450);
                        coinsPage.setVisible(true);
                        coinsPage.setLocationRelativeTo(null);
                    }
            );
        }else {
            //temperature page
            SwingUtilities.invokeLater(() -> {
                pageTemperature pTemp = new pageTemperature();
                pTemp.setSize(550, 450);
                pTemp.setVisible(true);
                pTemp.setLocationRelativeTo(null);
            });
        }

    }



}