import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        List<Intercambio> intercambios = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n¡Bienvenido al conversor de monedas!");
        System.out.println("Elija una opcion del menu");
        System.out.println("\n");
        String menu = """
                **************************************************\n
                1 - Conversor de monedas
                9 - Salir de la aplicacion
                \n**************************************************
                """;
        
        while (true) {
            System.out.println(menu);
            var numeroOperacion = teclado.nextInt();

            if (numeroOperacion == 9) {
                break;
            }

            System.out.println("\n**************************************************\n");
            System.out.println("Elija la moneda a convertir, la moneda a ser convertida y la cantidad\n");
            System.out.println("**************************************************\n");

            try {
                String monedaBase = String.valueOf(teclado.next());

                String monedaObjetivo = String.valueOf(teclado.next());

                double cantidadMoneda = Double.valueOf(teclado.next());

                ConsultaMonedas consulta = new ConsultaMonedas();
                Monedas moneda = consulta.buscaConversion(monedaBase, monedaObjetivo, cantidadMoneda);

                Intercambio intercambio = new Intercambio(monedaBase, monedaObjetivo, cantidadMoneda, moneda.conversion_result(), moneda.conversion_rate());
                intercambios.add(intercambio);
                System.out.println(intercambio);
                System.out.println("\n");

            } catch (IllegalArgumentException e) {
                System.out.println("Moneda no encontrada " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Opcion invalida");
            }
        }
        System.out.println("El registro de las transacciones fue: ");
        for (Intercambio i : intercambios) {
            System.out.println(i.toString());
        }
    }
}