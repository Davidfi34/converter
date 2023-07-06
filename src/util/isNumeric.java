package util;

/**
 * Clase utilitaria para verificar si una cadena representa un número válido.
 */
public class isNumeric {

    /**
     * Verifica si una cadena es un número válido.
     *
     * @param txt la cadena a verificar
     * @return {@code true} si la cadena es un número y válido positivo, {@code false} de lo contrario
     */
    public static boolean isPositiveNumber(String txt) {
        try {
            if (txt != null && txt.matches("\\d+(\\.\\d+)?")) {
                double number = Double.parseDouble(txt);
                return number > 0;
            }
            return false;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    /**
     *
     * @param txt la cadena a verificar
     * @return {@code true} si la cadena es un número válido, {@code false} de lo contrario
     */
    public static boolean isAllNumber(String txt) {
        try {
            if (txt != null && txt.matches("-?\\d+(\\.\\d+)?"))  return true;
            return false;
        } catch (NumberFormatException ex) {
            return false;
        }

    }
}

