package ejercicio3;

import java.util.Scanner; // importamos Scanner para leer datos del teclado

public class Main { // clase principal del programa

    public static void main(String[] args) { // aquí empieza a correr el programa
        Scanner teclado = new Scanner(System.in); // creamos el lector del teclado

        System.out.print("Ingrese la cantidad de empleados (N): "); // pedimos cuántos empleados hay
        int n = teclado.nextInt(); // guardamos la cantidad
        teclado.nextLine(); // limpiamos la línea para poder leer los textos sin problema

        String[] codigos = new String[n]; // vector para los códigos
        String[] nombres = new String[n]; // vector para los nombres, cada nombre va en la misma posición que su código

        for (int i = 0; i < n; i++) { // repetimos por cada empleado
            System.out.println("\nEmpleado " + (i + 1)); // mostramos el número de empleado
            System.out.print("  Código: "); // pedimos el código
            codigos[i] = teclado.nextLine().trim(); // guardamos el código
            System.out.print("  Nombre: "); // pedimos el nombre
            nombres[i] = teclado.nextLine().trim(); // guardamos el nombre en la misma posición del código
        }

        System.out.print("\nIngrese el código a buscar: "); // pedimos el código a buscar
        String codigoBuscado = teclado.nextLine().trim(); // guardamos el código

        int posicion = buscarCodigo(codigos, codigoBuscado); // buscamos la posición del código
        if (posicion != -1) { // si encontramos el código
            System.out.println("Empleado encontrado: " + nombres[posicion]); // mostramos el nombre de esa posición
        } else { // si no lo encontramos
            System.out.println("No existe un empleado con el código " + codigoBuscado); // avisamos que no existe
        }

        teclado.close(); // cerramos el lector
    }

    // método que busca un código y devuelve su posición, si no existe devuelve -1
    public static int buscarCodigo(String[] codigos, String buscado) {
        for (int i = 0; i < codigos.length; i++) { // recorremos los códigos
            if (codigos[i].equalsIgnoreCase(buscado)) { // comparamos sin importar mayúsculas o minúsculas
                return i; // devolvemos la posición donde está
            }
        }
        return -1; // si no lo encontramos devolvemos -1
    }
}
