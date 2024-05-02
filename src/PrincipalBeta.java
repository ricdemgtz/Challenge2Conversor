//import java.util.Objects;
//import java.util.Scanner;
//
//public class PrincipalBeta {
//    private static final CurrencyApi currencyApi = new CurrencyApi();
//
//    public static void main(String[] args) {
//        Scanner lectura = new Scanner(System.in);
//        String divisaMain = Constants.DEFAULT_CURRENCY;
//        int opcion = 0;
//
//        while (opcion != 9) {
//            System.out.println(Constants.MENU);
//            opcion = lectura.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    cambiarDivisaPredeterminada(lectura, divisaMain);
//                    break;
//                case 2:
//                    mostrarTasasConversion(divisaMain);
//                    showConversionMenu(lectura, divisaMain);
//                    break;
//                case 3:
//                    mostrarOpcionesPredeterminadas(lectura, divisaMain);
//                    break;
//                case 9:
//                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
//                    break;
//                default:
//                    System.out.println("Opción no válida, seleccione otra\n");
//            }
//        }
//    }
//
//    private static void cambiarDivisaPredeterminada(Scanner lectura, String divisaMain) {
//        System.out.println("Divisa predeterminada: " + divisaMain);
//        System.out.println("Selecciona una de las siguientes divisas: USD,MXN,TRY,ARS,EUR,JPY,CNY Favor de seleccionarlas como se muestra en pantalla");
//        String newCurrency = lectura.next();
//        if (Objects.equals(newCurrency, divisaMain)) {
//            System.out.println("La divisa seleccionada ya era la predeterminada");
//        } else {
//            divisaMain = newCurrency;
//            Constants.updateBaseUrl(newCurrency);
//            currencyApi.mostrarTasasConversion();
//            System.out.println("Divisa predeterminada cambiada a: " + divisaMain);
//        }
//    }
//
//    private static void mostrarTasasConversion(String divisaMain) {
//        System.out.println("Tasas de conversión actualizadas:");
//        currencyApi.mostrarTasasConversion();
//    }
//
//    private static void showConversionMenu(Scanner scanner, String divisaMain) {
//        double amount;
//        int option;
//        do {
//            System.out.println("Opciones de conversión de divisas:");
//            System.out.println(Constants.generateMenuFavorites(divisaMain));
//            System.out.print("Elija una opción válida: ");
//            option = scanner.nextInt();
//
//            switch (option) {
//                case 1:
//                    realizarConversion(scanner, divisaMain, "USD");
//                    break;
//                case 2:
//                    realizarConversion(scanner, "USD", divisaMain);
//                    break;
//                case 3:
//                    realizarConversion(scanner, divisaMain, "EUR");
//                    break;
//                case 4:
//                    realizarConversion(scanner, "EUR", divisaMain);
//                    break;
//                // Agregar más casos aquí para las otras opciones de conversión
//                case 99:
//                    System.out.println("Regresando al menú principal...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
//            }
//        } while (option != 99);
//    }
//
//    private static void realizarConversion(Scanner scanner, String fromCurrency, String toCurrency) {
//        System.out.print("Ingrese la cantidad en " + fromCurrency + ": ");
//        double amount = scanner.nextDouble();
//        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
//        System.out.printf("%.2f %s equivale a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
//    }
//
//    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
//        // Aquí asumimos que el método getCurrencyRate toma dos argumentos
//        // y devuelve la tasa de conversión de fromCurrency a toCurrency
//        double rate = currencyApi.getCurrencyRate(fromCurrency);
//        return amount * rate;
//    }
//    private static void mostrarOpcionesPredeterminadas(Scanner lectura, String divisaMain) {
//        int option;
//        do {
//            System.out.println(Constants.MENU_FAVORITES);
//            option = lectura.nextInt();
//            switch (option) {
//                case 99:
//                    System.out.println("Regresando al menú principal...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
//            }
//        } while (option != 99);
//    }
//}
