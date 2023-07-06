package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TemperatureConversion extends Conversion{

    @Override
    public double cover(double amount, String original_value,String target_value) {

        double result = 0.0;
        String parity = original_value+target_value;

        switch (parity) {
            case "CF":
                result = (amount * 9/5) + 32; // Conversión de Celsius a Fahrenheit
                break;
            case "CK":
                System.out.println("es CK");
                result = amount + 273.15; // Conversión de Celsius a Kelvin
                break;
            case "FC":
                result = (amount - 32) * 5/9; // Conversión de Fahrenheit a Celsius
                break;
            case "FK":
                result = (amount - 32) * 5/9 + 273.15; // Conversión de Fahrenheit a Kelvin
                break;
            case "KC":
                result = amount - 273.15; // Conversión de Kelvin a Celsius
                break;
            case "KF":
                result = (amount - 273.15) * 9/5 + 32; // Conversión de Kelvin a Fahrenheit
                break;
            default:
                result = amount;
        }
        return result;
    }

}
