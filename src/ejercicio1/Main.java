package ejercicio1;

import java.util.Scanner; // importamos Scanner para leer datos del teclado

public class Main { // clase principal del programa

    public static void main(String[] args) { // aquí empieza a correr el programa
        Scanner teclado = new Scanner(System.in); // creamos el lector del teclado

        System.out.print("Ingrese la cantidad de estudiantes (N): "); // pedimos cuántos estudiantes hay
        int n = teclado.nextInt(); // guardamos la cantidad en n
        teclado.nextLine(); // limpiamos la línea para poder leer las cédulas sin problema

        String[] matematica = leerCedulas(teclado, n, "MATEMATICA"); // llenamos el primer vector con las cédulas de matemática
        String[] ingles = leerCedulas(teclado, n, "INGLES"); // llenamos el segundo vector con las cédulas de inglés

        String[] ambas = buscarComunes(matematica, ingles); // formamos el tercer vector con las cédulas que están en los dos

        imprimirVector("Reprobados en MATEMATICA", matematica); // mostramos el primer vector
        imprimirVector("Reprobados en INGLES", ingles); // mostramos el segundo vector
        imprimirVector("Reprobados en AMBAS materias", ambas); // mostramos el tercer vector

        teclado.close(); // cerramos el lector
    }

    // método que pide las cédulas de una materia y las guarda en un vector
    public static String[] leerCedulas(Scanner teclado, int n, String materia) {
        String[] cedulas = new String[n]; // creamos el vector con n espacios
        System.out.println("\n--- Cédulas de reprobados en " + materia + " ---"); // mostramos el título de la materia
        for (int i = 0; i < n; i++) { // repetimos una vez por cada cédula
            System.out.print("Cédula " + (i + 1) + ": "); // pedimos la cédula
            cedulas[i] = teclado.nextLine().trim(); // guardamos la cédula en su posición
        }
        return cedulas; // devolvemos el vector lleno
    }

    // método que compara los dos vectores y devuelve las cédulas que se repiten en ambos
    public static String[] buscarComunes(String[] listaA, String[] listaB) {
        String[] temporal = new String[listaA.length]; // vector de apoyo para ir guardando las coincidencias
        int encontrados = 0; // contador de cédulas que coinciden

        for (int i = 0; i < listaA.length; i++) { // recorremos el primer vector
            boolean estaEnB = existe(listaB, listaB.length, listaA[i]); // revisamos si la cédula está en el segundo vector
            boolean yaAgregada = existe(temporal, encontrados, listaA[i]); // revisamos que no la hayamos guardado antes
            if (estaEnB && !yaAgregada) { // si está en los dos y no está repetida
                temporal[encontrados] = listaA[i]; // la guardamos
                encontrados++; // sumamos uno al contador
            }
        }

        String[] resultado = new String[encontrados]; // creamos el tercer vector del tamaño exacto
        for (int i = 0; i < encontrados; i++) { // recorremos las coincidencias
            resultado[i] = temporal[i]; // las pasamos al tercer vector
        }
        return resultado; // devolvemos el tercer vector
    }

    // método que dice si una cédula ya existe dentro de un vector
    public static boolean existe(String[] arreglo, int cantidad, String valor) {
        for (int i = 0; i < cantidad; i++) { // recorremos las posiciones ocupadas
            if (arreglo[i].equals(valor)) { // comparamos las cédulas con equals
                return true; // si la encontramos devolvemos verdadero
            }
        }
        return false; // si no la encontramos devolvemos falso
    }

    // método que muestra un vector con su título
    public static void imprimirVector(String titulo, String[] vector) {
        System.out.println("\n" + titulo + " (" + vector.length + "):"); // mostramos el título y cuántas cédulas tiene
        if (vector.length == 0) { // si el vector está vacío
            System.out.println("  [Ninguno]"); // avisamos que no hay cédulas
        }
        for (int i = 0; i < vector.length; i++) { // recorremos el vector
            System.out.println("  [" + i + "] " + vector[i]); // mostramos la posición y la cédula
        }
    }
}
