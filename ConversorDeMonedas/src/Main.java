import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulación de JSON obtenido de la API
        String jsonResponse = "{\"conversion_rates\":{\"USD\":1,\"ARS\":350.5,\"BRL\":4.98,\"COP\":4500.0}}";

        // Filtrar las tasas de cambio del JSON
        Map<String, Double> tasasCambio = FiltroMonedas.filtrarMonedas(jsonResponse);

        boolean salir = false;

        while (!salir) {
            System.out.println("***************************************************");
            System.out.println("Sea bienvenido al conversor de monedas :)");
            System.out.println("1) Dólar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dólar");
            System.out.println("3) Dólar -> Real Brasileño");
            System.out.println("4) Real Brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso Colombiano");
            System.out.println("6) Peso Colombiano -> Dólar");
            System.out.println("7) Salir");
            System.out.println("***************************************************");
            System.out.print("Elija una opción válida: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> ConversionHandler.realizarConversion("USD", "ARS", tasasCambio, scanner);
                case 2 -> ConversionHandler.realizarConversion("ARS", "USD", tasasCambio, scanner);
                case 3 -> ConversionHandler.realizarConversion("USD", "BRL", tasasCambio, scanner);
                case 4 -> ConversionHandler.realizarConversion("BRL", "USD", tasasCambio, scanner);
                case 5 -> ConversionHandler.realizarConversion("USD", "COP", tasasCambio, scanner);
                case 6 -> ConversionHandler.realizarConversion("COP", "USD", tasasCambio, scanner);
                case 7 -> {
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    salir = true;
                }
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}
