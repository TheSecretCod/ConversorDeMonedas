import java.util.Map;

public class ConversionMonedas {
    public static double convertir(double monto, String fromCurrency, String toCurrency, Map<String, Double> tasasCambio) {
        if (!tasasCambio.containsKey(fromCurrency) || !tasasCambio.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moneda no válida.");
        }

        double tasaFrom = tasasCambio.get(fromCurrency);
        double tasaTo = tasasCambio.get(toCurrency);

        // Realizamos la conversión
        return (monto / tasaFrom) * tasaTo;
    }
}
