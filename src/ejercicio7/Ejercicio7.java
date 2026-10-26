
import java.util.Scanner; // Permite ingresar datos por teclado.

public class Ejercicio7 { // Define la clase principal.
    public static void main(String[] args) { // Inicia el programa.
        Scanner sc = new Scanner(System.in); // Crea el lector de datos.

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = sc.nextInt(); // Lee la cantidad de estudiantes.

        int materias = 8; // Cada estudiante cursa ocho materias.
        int[] codigos = new int[n]; // Guarda los códigos estudiantiles.
        double[][] notas = new double[n][materias]; // Guarda las calificaciones.
        double[] promedios = new double[n]; // Guarda el promedio de cada estudiante.

        for (int i = 0; i < n; i++) { // Recorre todos los estudiantes.
            System.out.print("Código del estudiante " + (i + 1) + ": ");
            codigos[i] = sc.nextInt(); // Guarda el código.
            
            double suma = 0; // Acumula las notas del estudiante.

            for (int j = 0; j < materias; j++) { // Recorre las ocho materias.
                System.out.print("Nota de la materia " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble(); // Guarda la nota.
                suma += notas[i][j]; // Suma la nota ingresada.
            }

            promedios[i] = suma / materias; // Calcula el promedio.
        }

        System.out.println("\n--- PROMEDIO POR ESTUDIANTE ---");
        int mejor = 0; // Guarda la posición del mejor promedio.

        for (int i = 0; i < n; i++) { // Recorre los estudiantes.
            System.out.printf("Código %d: %.2f%n",
                    codigos[i], promedios[i]); // Muestra el promedio.

            if (promedios[i] > promedios[mejor]) {
                mejor = i; // Actualiza el estudiante con mayor promedio.
            }
        }

        System.out.println("\n--- PROMEDIO POR MATERIA ---");
        for (int j = 0; j < materias; j++) { // Recorre las materias.
            double sumaMateria = 0; // Acumula las notas de la materia.
            int aprobados = 0; // Cuenta los estudiantes aprobados.
            int reprobados = 0; // Cuenta los estudiantes reprobados.

            for (int i = 0; i < n; i++) { // Recorre los estudiantes.
                sumaMateria += notas[i][j]; // Suma la nota de la materia.

                if (notas[i][j] >= 7 && notas[i][j] <= 10) {
                    aprobados++; // Cuenta una nota aprobada.
                } else if (notas[i][j] < 7) {
                    reprobados++; // Cuenta una nota reprobada.
                }
            }

            double promedioMateria = sumaMateria / n; // Calcula el promedio.
            System.out.printf("Materia %d - Promedio: %.2f%n",
                    j + 1, promedioMateria);
            System.out.println("Aprobados: " + aprobados);
            System.out.println("Reprobados: " + reprobados);
        }

        System.out.println("\n--- MEJOR ESTUDIANTE ---");
        System.out.println("Código: " + codigos[mejor]);
        System.out.printf("Promedio: %.2f%n", promedios[mejor]);

        sc.close(); // Cierra el lector.
    }
}
 