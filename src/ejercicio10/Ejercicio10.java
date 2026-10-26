
import java.util.ArrayList; // Permite crear una lista de pedidos.
import java.util.Scanner; // Permite ingresar datos por teclado.

public class Ejercicio10 { // Define la clase principal.

    static class Pedido { // Define la información de cada pedido.
        String cliente; // Guarda el nombre del cliente.
        String plato; // Guarda el plato solicitado.
        int cantidad; // Guarda la cantidad pedida.
        double precioUnitario; // Guarda el precio por unidad.
        double subtotal; // Guarda el importe antes del descuento.
        double descuento; // Guarda el descuento aplicado.
        double total; // Guarda el total final del pedido.

        Pedido(String cliente, String plato, int cantidad, double precioUnitario) {
            this.cliente = cliente; // Asigna el cliente.
            this.plato = plato; // Asigna el plato.
            this.cantidad = cantidad; // Asigna la cantidad.
            this.precioUnitario = precioUnitario; // Asigna el precio.

            subtotal = cantidad * precioUnitario; // Calcula el subtotal.

            if (subtotal > 50) { // Comprueba si supera los $50.
                descuento = subtotal * 0.10; // Calcula el 10 %.
            } else {
                descuento = 0; // No aplica descuento.
            }

            total = subtotal - descuento; // Calcula el total a pagar.
        }
    }

    public static void main(String[] args) { // Inicia el programa.
        Scanner sc = new Scanner(System.in); // Crea el lector.
        ArrayList<Pedido> pedidos = new ArrayList<>();
        // Crea la lista de pedidos.

        int opcion; // Guarda la opción seleccionada.

        do { // Repite el menú hasta salir.
            System.out.println("\n--- RESTAURANTE ---");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Mostrar todos los pedidos");
            System.out.println("3. Mostrar ingresos totales");
            System.out.println("4. Mostrar pedido de mayor valor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); // Lee la opción.
            sc.nextLine(); // Limpia el salto de línea.

            switch (opcion) { // Evalúa la opción seleccionada.

                case 1:
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine(); // Lee el cliente.

                    System.out.print("Plato solicitado: ");
                    String plato = sc.nextLine(); // Lee el plato.

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt(); // Lee la cantidad.

                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble(); // Lee el precio.

                    if (cantidad <= 0 || precio < 0) {
                        System.out.println("Cantidad o precio no válido.");
                        break; // Evita registrar datos incorrectos.
                    }

                    Pedido nuevo = new Pedido(cliente, plato, cantidad, precio);
                    // Crea el pedido y calcula sus importes.
                    pedidos.add(nuevo); // Guarda el pedido en la lista.

                    System.out.println("Pedido registrado correctamente.");
                    System.out.printf("Subtotal: $%.2f%n", nuevo.subtotal);
                    System.out.printf("Descuento: $%.2f%n", nuevo.descuento);
                    System.out.printf("Total a pagar: $%.2f%n", nuevo.total);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PEDIDOS ---");

                    for (Pedido p : pedidos) {
                        // Recorre todos los pedidos registrados.
                        System.out.println("Cliente: " + p.cliente);
                        System.out.println("Plato: " + p.plato);
                        System.out.println("Cantidad: " + p.cantidad);
                        System.out.printf("Subtotal: $%.2f%n", p.subtotal);
                        System.out.printf("Descuento: $%.2f%n", p.descuento);
                        System.out.printf("Total: $%.2f%n", p.total);
                        System.out.println("----------------------");
                    }
                    break;

                case 3:
                    double ingresos = 0; // Inicializa los ingresos totales.

                    for (Pedido p : pedidos) {
                        ingresos += p.total;
                        // Suma los importes finales de los pedidos.
                    }

                    System.out.printf("Ingresos totales: $%.2f%n", ingresos);
                    break;

                case 4:
                    if (pedidos.isEmpty()) {
                        // Comprueba si no existen pedidos.
                        System.out.println("Todavía no hay pedidos registrados.");
                    } else {
                        Pedido mayor = pedidos.get(0);
                        // Supone que el primer pedido es el de mayor valor.

                        for (Pedido p : pedidos) {
                            if (p.total > mayor.total) {
                                mayor = p; // Actualiza el pedido de mayor valor.
                            }
                        }

                        System.out.println("\n--- PEDIDO DE MAYOR VALOR ---");
                        System.out.println("Cliente: " + mayor.cliente);
                        System.out.println("Plato: " + mayor.plato);
                        System.out.printf("Total: $%.2f%n", mayor.total);
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0); // Continúa hasta elegir salir.

        sc.close(); // Cierra el lector.
    }
}
