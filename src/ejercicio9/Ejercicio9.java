
import java.util.ArrayList; // Permite crear una lista.
import java.util.Scanner; // Permite ingresar datos por teclado.

public class Ejercicio9 { // Define la clase principal.

    static class Medicamento { // Define los datos de cada medicamento.
        String nombre; // Guarda el nombre.
        int stock; // Guarda las unidades disponibles.
        int stockMinimo; // Guarda el stock mínimo.
        double precio; // Guarda el precio por unidad.

        Medicamento(String nombre, int stock, int stockMinimo, double precio) {
            this.nombre = nombre; // Asigna el nombre.
            this.stock = stock; // Asigna el stock actual.
            this.stockMinimo = stockMinimo; // Asigna el mínimo.
            this.precio = precio; // Asigna el precio.
        }
    }

    public static void main(String[] args) { // Inicia el programa.
        Scanner sc = new Scanner(System.in); // Crea el lector.
        ArrayList<Medicamento> lista = new ArrayList<>();
        // Crea la lista de medicamentos.

        int opcion; // Guarda la opción del menú.

        do { // Repite el menú hasta seleccionar salir.
            System.out.println("\n--- INVENTARIO DE FARMACIA ---");
            System.out.println("1. Registrar medicamento");
            System.out.println("2. Mostrar medicamentos con stock bajo");
            System.out.println("3. Calcular valor del inventario");
            System.out.println("4. Registrar venta");
            System.out.println("5. Mostrar reporte general");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); // Lee la opción.
            sc.nextLine(); // Limpia el salto de línea.

            switch (opcion) { // Evalúa la opción seleccionada.

                case 1:
                    System.out.print("Nombre del medicamento: ");
                    String nombre = sc.nextLine(); // Lee el nombre.

                    System.out.print("Stock actual: ");
                    int stock = sc.nextInt(); // Lee las unidades.

                    System.out.print("Stock mínimo: ");
                    int minimo = sc.nextInt(); // Lee el mínimo.

                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble(); // Lee el precio.

                    if (stock < 0 || minimo < 0 || precio < 0) {
                        System.out.println("Los valores no pueden ser negativos.");
                        break; // Evita registrar datos inválidos.
                    }

                    lista.add(new Medicamento(nombre, stock, minimo, precio));
                    // Agrega el medicamento a la lista.
                    System.out.println("Medicamento registrado.");
                    break;

                case 2:
                    System.out.println("\n--- STOCK BAJO ---");
                    for (Medicamento med : lista) {
                        // Recorre todos los medicamentos.
                        if (med.stock < med.stockMinimo) {
                            System.out.println(med.nombre
                                    + " - Stock: " + med.stock
                                    + " - Mínimo: " + med.stockMinimo);
                        }
                    }
                    break;

                case 3:
                    double valorTotal = 0; // Inicializa el valor total.
                    for (Medicamento med : lista) {
                        valorTotal += med.stock * med.precio;
                        // Suma el valor de cada medicamento.
                    }
                    System.out.printf("Valor total del inventario: $%.2f%n",
                            valorTotal);
                    break;

                case 4:
                    System.out.print("Nombre del medicamento vendido: ");
                    String buscado = sc.nextLine(); // Lee el nombre.

                    System.out.print("Cantidad vendida: ");
                    int cantidad = sc.nextInt(); // Lee la cantidad.

                    boolean encontrado = false; // Indica si existe.

                    for (Medicamento med : lista) {
                        if (med.nombre.equalsIgnoreCase(buscado)) {
                            encontrado = true; // Encuentra el medicamento.

                            if (cantidad <= 0) {
                                System.out.println("Cantidad no válida.");
                            } else if (cantidad > med.stock) {
                                System.out.println("Stock insuficiente.");
                            } else {
                                med.stock -= cantidad;
                                // Descuenta las unidades vendidas.
                                System.out.println("Venta registrada.");
                                System.out.println("Stock restante: " + med.stock);
                            }
                            break; // Termina la búsqueda.
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Medicamento no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- REPORTE GENERAL ---");
                    for (Medicamento med : lista) {
                        System.out.println("Medicamento: " + med.nombre);
                        System.out.println("Stock: " + med.stock);
                        System.out.println("Stock mínimo: " + med.stockMinimo);
                        System.out.printf("Precio: $%.2f%n", med.precio);
                        System.out.printf("Valor: $%.2f%n",
                                med.stock * med.precio);
                        System.out.println("----------------------");
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0); // Repite mientras no se elija salir.

        sc.close(); // Cierra el lector.
    }
}
