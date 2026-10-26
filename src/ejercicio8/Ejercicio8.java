
import java.util.Scanner; // Permite ingresar datos por teclado.

public class Ejercicio8 { // Define la clase principal.
    public static void main(String[] args) { // Inicia el programa.
        Scanner sc = new Scanner(System.in); // Crea el lector.

        System.out.print("Ingrese la cantidad de trabajadores: ");
        int n = sc.nextInt(); // Lee la cantidad de trabajadores.

        for (int i = 0; i < n; i++) { // Procesa cada trabajador.
            System.out.println("\n--- Trabajador " + (i + 1) + " ---");

            System.out.print("Código del trabajador: ");
            int codigo = sc.nextInt(); // Lee el código.

            System.out.print("Horas de ausencia: ");
            int horas = sc.nextInt(); // Lee las horas de ausencia.

            System.out.print("Pupitres defectuosos: ");
            int defectuosos = sc.nextInt(); // Lee los defectuosos.

            System.out.print("Pupitres producidos: ");
            int producidos = sc.nextInt(); // Lee los producidos.

            boolean c1 = horas <= 3; // Comprueba la primera condición.
            boolean c2 = defectuosos < 300; // Comprueba la segunda.
            boolean c3 = producidos > 10000; // Comprueba la tercera.

            int grado; // Guarda el grado de eficiencia.

            if (c1 && c2 && c3) {
                grado = 20; // Cumple las tres condiciones.
            } else if (c1 && c2) {
                grado = 12; // Cumple solo la primera y segunda.
            } else if (c1 && c3) {
                grado = 13; // Cumple solo la primera y tercera.
            } else if (c2 && c3) {
                grado = 15; // Cumple solo la segunda y tercera.
            } else if (c1) {
                grado = 7; // Cumple únicamente la primera.
            } else if (c2) {
                grado = 8; // Cumple únicamente la segunda.
            } else if (c3) {
                grado = 9; // Cumple únicamente la tercera.
            } else {
                grado = 5; // No cumple ninguna condición.
            }

            System.out.println("\nCódigo: " + codigo);
            System.out.println("Horas de ausencia: " + horas);
            System.out.println("Pupitres defectuosos: " + defectuosos);
            System.out.println("Pupitres producidos: " + producidos);
            System.out.println("Grado de eficiencia: " + grado);
        }

        sc.close(); // Cierra el lector.
    }
}
