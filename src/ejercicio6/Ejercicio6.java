
import java.util.Scanner; // Permite ingresar datos por teclado.

public class Ejercicio6 { // Define la clase principal.
    public static void main(String[] args) { // Inicia el programa.
        Scanner sc = new Scanner(System.in); // Crea el lector de datos.

        System.out.print("Ingrese el numero de vendedores: ");
        int n = sc.nextInt(); // Lee la cantidad de vendedores.

        System.out.print("Ingrese el numero de años: ");
        int m = sc.nextInt(); // Lee la cantidad de años.

        double[][] ventas = new double[n][m]; // Crea la matriz de ventas.
        double totalEmpresa = 0; // Guarda las ventas de toda la empresa.

        for (int i = 0; i < n; i++) { // Recorre los vendedores.
            for (int j = 0; j < m; j++) { // Recorre los años.
                System.out.print("Ventas del vendedor " + (i + 1)
                        + " en el año " + (j + 1) + ": ");
                ventas[i][j] = sc.nextDouble(); // Guarda cada venta.
            }
        }

        System.out.println("\n--- TOTAL POR VENDEDOR ---");
        for (int i = 0; i < n; i++) { // Procesa cada vendedor.
            double totalVendedor = 0; // Inicializa su total.

            for (int j = 0; j < m; j++) { // Suma sus ventas anuales.
                totalVendedor += ventas[i][j];
            }

            System.out.println("Vendedor " + (i + 1)
                    + ": $" + totalVendedor);
        }

        System.out.println("\n--- TOTAL POR AÑO ---");
        for (int j = 0; j < m; j++) { // Procesa cada año.
            double totalAnual = 0; // Inicializa el total anual.

            for (int i = 0; i < n; i++) { // Suma las ventas del año.
                totalAnual += ventas[i][j];
            }

            System.out.println("Año " + (j + 1)
                    + ": $" + totalAnual);
            totalEmpresa += totalAnual; // Acumula el total empresarial.
        }

        System.out.println("\nTotal de ventas de la empresa: $"
                + totalEmpresa); // Muestra el total general.

        sc.close(); // Cierra el lector.
    }
}
