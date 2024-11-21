import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class FiltroMonedas {
    public static Map<String, Double> filtrarMonedas(String jsonResponse) {
        Map<String, Double> tasasCambio = new HashMap<>();
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Extraemos las tasas de cambio del objeto "conversion_rates"
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Iteramos sobre las claves (monedas) y valores (tasas de cambio)
        for (String moneda : conversionRates.keySet()) {
            double tasa = conversionRates.get(moneda).getAsDouble();
            tasasCambio.put(moneda, tasa);
        }

        return tasasCambio;
    }
}
