package ejercicio2;

import java.util.Random; // importamos Random para generar números aleatorios
import java.util.Scanner; // importamos Scanner para leer datos del teclado

public class Main { // clase principal del programa

    public static void main(String[] args) { // aquí empieza a correr el programa
        Scanner teclado = new Scanner(System.in); // creamos el lector del teclado
        Random azar = new Random(); // creamos el generador de números aleatorios

        int[] vector = new int[20]; // creamos el vector de 20 posiciones
        for (int i = 0; i < vector.length; i++) { // recorremos las 20 posiciones
            vector[i] = azar.nextInt(50) + 1; // ponemos un número aleatorio entre 1 y 50
        }
        imprimirVector("Vector original (20 elementos)", vector); // mostramos el vector generado

        // literal a, buscar un número
        System.out.print("\nIngrese el número a buscar: "); // pedimos el número a buscar
        int buscado = teclado.nextInt(); // guardamos el número
        buscarPosiciones(vector, buscado); // buscamos en qué posiciones está

        // literal b, segundo vector con las posiciones impares
        int[] impares = tomarPosicionesImpares(vector); // armamos el segundo vector con las posiciones impares
        imprimirVector("\nSegundo vector (elementos de índices impares)", impares); // mostramos el segundo vector

        // literal c, contar los mayores a 20
        int mayores = contarMayoresA(impares, 20); // contamos cuántos son mayores a 20
        System.out.println("\nElementos mayores a 20 en el segundo vector: " + mayores); // mostramos el resultado

        teclado.close(); // cerramos el lector
    }

    // método que muestra en qué posiciones aparece el número buscado
    public static void buscarPosiciones(int[] vector, int buscado) {
        boolean loEncontre = false; // al inicio todavía no lo hemos encontrado
        for (int i = 0; i < vector.length; i++) { // recorremos todo el vector
            if (vector[i] == buscado) { // si el número de esta posición es el buscado
                System.out.println("El número " + buscado + " está en la posición " + i); // mostramos la posición
                loEncontre = true; // marcamos que sí lo encontramos
            }
        }
        if (!loEncontre) { // si no lo encontramos en ninguna posición
            System.out.println("El número " + buscado + " no se encuentra en el vector."); // avisamos al usuario
        }
    }

    // método que crea un vector nuevo con los valores de las posiciones impares
    public static int[] tomarPosicionesImpares(int[] vector) {
        int[] resultado = new int[vector.length / 2]; // de 20 posiciones la mitad son impares, o sea 10
        int j = 0; // posición donde vamos a guardar en el vector nuevo
        for (int i = 1; i < vector.length; i += 2) { // empezamos en 1 y avanzamos de dos en dos
            resultado[j] = vector[i]; // copiamos el valor de la posición impar
            j++; // pasamos a la siguiente posición del vector nuevo
        }
        return resultado; // devolvemos el vector nuevo
    }

    // método que cuenta cuántos valores son mayores a un límite
    public static int contarMayoresA(int[] vector, int limite) {
        int contador = 0; // empezamos el contador en cero
        for (int i = 0; i < vector.length; i++) { // recorremos el vector
            if (vector[i] > limite) { // si el valor es mayor al límite
                contador++; // sumamos uno al contador
            }
        }
        return contador; // devolvemos el total
    }

    // método que muestra un vector con sus posiciones
    public static void imprimirVector(String titulo, int[] vector) {
        System.out.println(titulo + ":"); // mostramos el título
        for (int i = 0; i < vector.length; i++) { // recorremos el vector
            System.out.print("[" + i + "]=" + vector[i] + "  "); // mostramos la posición y el valor en la misma línea
        }
        System.out.println(); // bajamos de línea al terminar
    }
}
