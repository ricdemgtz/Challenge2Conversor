import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApi {
    private static final String API_KEY = Constants.API_KEY;
    private static final String BASE_URL = Constants.BASE_URL;
    CurrencyData currencyData;


    public void mostrarTasasConversion() {
        String finalUrl = Constants.getFinalUrl();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(finalUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                currencyData = gson.fromJson(responseBody, CurrencyData.class);

                System.out.println("Tasas de conversión:");
                System.out.println(currencyData.conversion_rates);
            } else {
                System.out.println("Error al obtener los datos de las divisas. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getCurrencyRate(String currency) {
        if (currencyData != null && currencyData.conversion_rates != null) {
            switch (currency) {
                case Constants.USD:
                    return currencyData.conversion_rates.USD;
                case Constants.EUR:
                    return currencyData.conversion_rates.EUR;
                case Constants.TRY:
                    return currencyData.conversion_rates.TRY;
                case Constants.MXN:
                    return currencyData.conversion_rates.MXN;
                default:
                    return 0.0;
            }
        } else {
            return 0.0;
        }
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double fromExchangeRate = getCurrencyRate(fromCurrency);
        double toExchangeRate = getCurrencyRate(toCurrency);

        if (fromExchangeRate != 0 && toExchangeRate != 0) {
            return amount * (toExchangeRate / fromExchangeRate);
        } else {
            return 0.0;
        }
    }


    static class CurrencyData {
        String base_code;
        CurrencyRates conversion_rates;
    }

    static class CurrencyRates {
        double MXN;
        double USD;
        double EUR;
        double TRY;

    }
}
