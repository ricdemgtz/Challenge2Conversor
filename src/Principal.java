import java.util.Scanner;

public class Principal {
    private static final CurrencyApi currencyApi = new CurrencyApi();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al sistema de conversión de divisas!");

        // Obtener tasas de conversión al inicio del programa
        currencyApi.mostrarTasasConversion();

        if (currencyApi.currencyData == null || currencyApi.currencyData.conversion_rates == null) {
            System.out.println("Error al obtener los datos de conversión. Saliendo del programa.");
            return;
        }


        int option;
        do {
            System.out.println("\n*******************************************");
            System.out.println("Opciones de conversión: ");
            System.out.println("1. Convertir de MXN a USD");
            System.out.println("2. Convertir de USD a MXN");
            System.out.println("3. Convertir de MXN a EUR");
            System.out.println("4. Convertir de EUR a MXN");
            System.out.println("5. Convertir de USD a EUR");
            System.out.println("6. Convertir de EUR a USD");
            System.out.println("7. Convertir de MXN a TRY");
            System.out.println("8. Convertir de TRY a MXN");
            System.out.println("9. Convertir de TRY a USD");
            System.out.println("10. Convertir de USD a TRY");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    convertFromMXNtoUSD(scanner);
                    break;
                case 2:
                    convertFromUSDtoMXN(scanner);
                    break;
                case 3:
                    convertFromMXNtoEUR(scanner);
                    break;
                case 4:
                    convertFromEURtoMXN(scanner);
                    break;
                case 5:
                    convertFromUSDtoEUR(scanner);
                    break;
                case 6:
                    convertFromEURtoUSD(scanner);
                    break;
                case 7:
                    convertFromMXNtoTRY(scanner);
                    break;
                case 8:
                    convertFromTRYtoMXN(scanner);
                    break;
                case 9:
                    convertFromTRYtoUSD(scanner);
                    break;
                case 10:
                    convertFromUSDtoTRY(scanner);
                    break;
                case 11:
                    System.out.println("Saliendo del programa. ¡Gracias por utilizar nuestros servicios!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (option != 11);
    }

    private static void convertFromMXNtoUSD(Scanner scanner) {
        System.out.print("Ingresa la cantidad en MXN: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "MXN", "USD");
        System.out.printf("%.2f MXN equivale a %.2f USD\n", amount, result);
    }

    private static void convertFromUSDtoMXN(Scanner scanner) {
        System.out.print("Ingresa la cantidad en USD: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "USD", "MXN");
        System.out.printf("%.2f USD equivale a %.2f MXN\n", amount, result);
    }
    private static void convertFromMXNtoEUR(Scanner scanner) {
        System.out.print("Ingresa la cantidad en MXN: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "MXN", "EUR");
        System.out.printf("%.2f MXN equivale a %.2f EUR\n", amount, result);
    }

    private static void convertFromEURtoMXN(Scanner scanner) {
        System.out.print("Ingresa la cantidad en EUR: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "EUR", "MXN");
        System.out.printf("%.2f EUR equivale a %.2f MXN\n", amount, result);
    }

    private static void convertFromUSDtoEUR(Scanner scanner) {
        System.out.print("Ingresa la cantidad en USD: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "USD", "EUR");
        System.out.printf("%.2f USD equivale a %.2f EUR\n", amount, result);
    }

    private static void convertFromEURtoUSD(Scanner scanner) {
        System.out.print("Ingresa la cantidad en EUR: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "EUR", "USD");
        System.out.printf("%.2f EUR equivale a %.2f USD\n", amount, result);
    }

    private static void convertFromMXNtoTRY(Scanner scanner) {
        System.out.print("Ingresa la cantidad en MXN: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "MXN", "TRY");
        System.out.printf("%.2f MXN equivale a %.2f TRY\n", amount, result);
    }

    private static void convertFromTRYtoMXN(Scanner scanner) {
        System.out.print("Ingresa la cantidad en TRY: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "TRY", "MXN");
        System.out.printf("%.2f TRY equivale a %.2f MXN\n", amount, result);
    }

    private static void convertFromTRYtoUSD(Scanner scanner) {
        System.out.print("Ingresa la cantidad en TRY: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "TRY", "USD");
        System.out.printf("%.2f TRY equivale a %.2f USD\n", amount, result);
    }

    private static void convertFromUSDtoTRY(Scanner scanner) {
        System.out.print("Ingresa la cantidad en USD: ");
        double amount = scanner.nextDouble();
        double result = currencyApi.convertCurrency(amount, "USD", "TRY");
        System.out.printf("%.2f USD equivale a %.2f TRY\n", amount, result);
    }
}
