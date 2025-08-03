import java.util.Scanner;

public class MenuDeUsuario {
    public void iniciarMenu() {
        Scanner lectura = new Scanner(System.in);

        System.out.println("Bienvenido al conversor de monedas");
        String menu = """
                Elige la opción de conversión que deseas:
                1. Pesos Mexicanos (MXN) a Dolares Estadounidenses (USD)
                2. Pesos Mexicanos (MXN) a Euros (EUR)
                3. Pesos Mexicanos (MXN) a Yenes (JPY)
                4. Pesos Mexicanos (MXN) a Libras Esterlinas (GBP)
                9. Salir del programa.
                """;

        int eleccion = 0;
        while (eleccion != 9) {
            System.out.println(menu);
            eleccion = Integer.parseInt(lectura.nextLine());

            switch (eleccion) {
                    case 1:
                    System.out.println("=== Elegiste conversión de Pesos Mexicanos a Dólares ===");

                    // Se obtienen los datos de la API
                    ConversorAPI conversor1 = new ConversorAPI();
                    ObtenerDatos datos1 = conversor1.obtenerDatos("MXN");

                    // Se extrae la tasa específica de USD
                    Double tasaUSD = datos1.conversion_rates().get("USD");

                    // Se validaa que la tasa existe
                    if (tasaUSD != null) {
                        // Se solicita la cantidad al usuario
                        System.out.println("Ingresa la cantidad de pesos mexicanos que deseas convertir:");
                        double cantidadPesos = Double.parseDouble(lectura.nextLine());

                        // Se realiza el cálculo
                        double resultadoUSD = cantidadPesos * tasaUSD;

                        // Se muestra el resultado formateado
                        System.out.println("La conversión de: " + cantidadPesos + " MXN = " + "equivale a: " + resultadoUSD + " USD");
                        System.out.println("===================================");

                    } else {
                        System.out.println("Error: No se pudo obtener la tasa de cambio");
                    }
                    break;

                case 2:
                    // Convertir MXN a EUR
                    System.out.println("=== Elegiste conversión de Pesos Mexicanos a Euros ===");

                    ConversorAPI conversor2 = new ConversorAPI();
                    ObtenerDatos datos2 = conversor2.obtenerDatos("MXN");

                    Double tasaEUR = datos2.conversion_rates().get("EUR");

                    if (tasaEUR != null) {
                        System.out.println("Ingresa la cantidad de pesos mexicanos que deseas convertir:");
                        double cantidadPesos = Double.parseDouble(lectura.nextLine());

                        double resultadoEUR = cantidadPesos * tasaEUR;

                        System.out.println("La conversión de: " + cantidadPesos + " MXN = " + "equivale a: " + resultadoEUR + " EUR");
                    }
                    break;

                case 3:
                    System.out.println("=== Elegiste conversión de Pesos Mexicanos a Yenes ===");

                    ConversorAPI conversor3 = new ConversorAPI();
                    ObtenerDatos datos3 = conversor3.obtenerDatos("MXN");

                    Double tasaJPY = datos3.conversion_rates().get("JPY");

                    if (tasaJPY != null) {
                        System.out.println("Ingresa la cantidad de pesos mexicanos que deseas convertir:");
                        double cantidadPesos = Double.parseDouble(lectura.nextLine());

                        double resultadoJPY = cantidadPesos * tasaJPY;

                        System.out.println("La conversión de: " + cantidadPesos + " MXN = " + "equivale a: " + resultadoJPY + " JPY");
                        System.out.println("===================================");

                    } else {
                        System.out.println("Error: No se pudo obtener la tasa de cambio");
                    }
                    break;
                case 4:
                    System.out.println("=== Elegiste conversión de Pesos Mexicanos a Libras Esterlinas ===");
                    ConversorAPI conversor4 = new ConversorAPI();
                    ObtenerDatos datos4 = conversor4.obtenerDatos("MXN");
                    Double tasaGBP = datos4.conversion_rates().get("GBP");

                    if (tasaGBP != null){
                        System.out.println("Ingresa la cantidad de pesos mexicanos que deseas convertir:");
                        double cantidadPesos = Double.parseDouble(lectura.nextLine());
                        double resultadpGBP = cantidadPesos * tasaGBP;

                        System.out.println("La conversión de: " + cantidadPesos + " MXN = " + "equivale a: " + resultadpGBP + " GBP");
                        System.out.println("===================================");

                    }
                    break;
                case 9:
                    System.out.println("¡Gracias por usar el conversor!, ¡Te veremos pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor elige una opción del 1 al 4 o 9 para salir.");
                    break;
            }
        }
    }
}