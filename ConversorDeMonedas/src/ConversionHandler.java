import java.util.Map;
import java.util.Scanner;

public class ConversionHandler {
    public static void realizarConversion(String fromCurrency, String toCurrency, Map<String, Double> tasasCambio, Scanner scanner) {
        System.out.printf("Ingrese el monto en %s: ", fromCurrency);
        double monto = scanner.nextDouble();

        try {
            double resultado = ConversionMonedas.convertir(monto, fromCurrency, toCurrency, tasasCambio);
            System.out.printf("El monto convertido a %s es: %.2f%n", toCurrency, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
