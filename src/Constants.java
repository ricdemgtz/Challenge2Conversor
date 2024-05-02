import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final boolean MENU_FAVORITES = true;
    public static final String API_KEY = "0308421a9f5f3f79e731dc31"; // Clave de API
    public static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Definir los nombres de las monedas
    public static final String USD = "USD";
    public static final String MXN = "MXN";
    public static final String TRY = "TRY";
    public static final String ARS = "ARS";
    public static final String EUR = "EUR";
    public static final String JPY = "JPY";
    public static final String CNY = "CNY";


    private static String defaultCurrency = "MXN"; // O cualquier valor predeterminado que desees

    // Método para obtener la URL final
    public static String getFinalUrl() {
        return BASE_URL + API_KEY + "/latest/" + defaultCurrency;
    }

    // Método para generar dinámicamente el menú de opciones favoritas
    public static String generateMenuFavorites(String defaultCurrency) {
        StringBuilder menu = new StringBuilder();
        if (MENU_FAVORITES) {
            menu.append("Opciones predeterminadas:\n\n");
            menu.append("1) Dólar => ").append(defaultCurrency).append("\n");
            menu.append("2) ").append(defaultCurrency).append(" => Dólar\n");
            menu.append("3) Lira turca => Dólar\n");
            menu.append("4) Dólar => Lira turca\n");
            menu.append("5) ").append(defaultCurrency).append(" => Lira turca\n");
            menu.append("6) Lira turca => ").append(defaultCurrency).append("\n");
            menu.append("99) Salir\n");
            menu.append("Elija una opción válida:\n");
            menu.append("***********************************************\n");
        }
        return menu.toString();
    }

    // Método para verificar si una divisa es válida
    public static boolean isValidCurrency(String currency) {
        return SUPPORTED_CURRENCIES.containsKey(currency);
    }

    // Lista de divisas admitidas y sus nombres completos (si es necesario)
    private static final Map<String, String> SUPPORTED_CURRENCIES = new HashMap<>();
    static {
        SUPPORTED_CURRENCIES.put(USD, "Dólar estadounidense");
        SUPPORTED_CURRENCIES.put(MXN, "Peso mexicano");
        SUPPORTED_CURRENCIES.put(TRY, "Lira turca");
        SUPPORTED_CURRENCIES.put(ARS, "Peso argentino");
        SUPPORTED_CURRENCIES.put(EUR, "Euro");
        SUPPORTED_CURRENCIES.put(JPY, "Yen japonés");
        SUPPORTED_CURRENCIES.put(CNY, "Yuan chino");
    }
}
