import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyInfoFetcher {

    public static void main(String[] args) {
        fetchCurrencyInfo();
    }

    public static void fetchCurrencyInfo() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/0308421a9f5f3f79e731dc31/latest/USD"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                parseCurrencyInfo(responseBody);
            } else {
                System.out.println("Error al obtener los datos de la API. Código de estado: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void parseCurrencyInfo(String responseBody) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CurrencyData currencyData = gson.fromJson(responseBody, CurrencyData.class);

        // Aquí puedes acceder a los datos de la moneda y utilizarlos como desees
        System.out.println("Base: " + currencyData.base);
        System.out.println("Rates:");
        System.out.println(gson.toJson(currencyData.rates));
    }

    static class CurrencyData {
        String base;
        Rates rates;
    }

    static class Rates {
        double USD;
        double EUR;
        double MXN; // Agregar otros campos según la estructura de datos de la respuesta JSON
        double TRY;
        // Agrega los campos que sean necesarios
    }
}
