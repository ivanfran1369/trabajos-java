package ejercicio4;

import java.util.Random; // importamos Random para generar números aleatorios
import java.util.Scanner; // importamos Scanner para leer datos del teclado

public class Main { // clase principal del programa

    static Random azar = new Random(); // generador de números aleatorios que usan todos los métodos

    public static void main(String[] args) { // aquí empieza a correr el programa
        Scanner teclado = new Scanner(System.in); // creamos el lector del teclado

        System.out.print("Ingrese el número de filas (M): "); // pedimos las filas
        int m = teclado.nextInt(); // guardamos las filas
        System.out.print("Ingrese el número de columnas (N): "); // pedimos las columnas
        int n = teclado.nextInt(); // guardamos las columnas

        int[][] a = generarMatriz(m, n); // creamos la matriz A con números aleatorios
        int[][] b = generarMatriz(m, n); // creamos la matriz B del mismo tamaño
        imprimirMatriz("Matriz A", a); // mostramos la matriz A
        imprimirMatriz("Matriz B", b); // mostramos la matriz B

        int opcion; // variable para la opción del menú
        do { // el menú se muestra por lo menos una vez
            System.out.println("\n===== MENÚ ====="); // título del menú
            System.out.println("1. Sumar (A + B)"); // opción sumar
            System.out.println("2. Restar (A - B)"); // opción restar
            System.out.println("3. Multiplicar (A x C)"); // opción multiplicar
            System.out.println("4. Trasponer A"); // opción trasponer
            System.out.println("0. Salir"); // opción salir
            System.out.print("Seleccione una opción: "); // pedimos la opción
            opcion = teclado.nextInt(); // guardamos la opción

            switch (opcion) { // según la opción hacemos la operación
                case 1: // sumar
                    imprimirMatriz("A + B", sumar(a, b)); // sumamos y mostramos el resultado
                    break; // salimos del switch
                case 2: // restar
                    imprimirMatriz("A - B", restar(a, b)); // restamos y mostramos el resultado
                    break; // salimos del switch
                case 3: // multiplicar
                    // para multiplicar, la matriz C debe tener tantas filas como columnas tiene A
                    System.out.print("Ingrese las columnas (P) de la matriz C (" + n + " x P): "); // pedimos las columnas de C
                    int p = teclado.nextInt(); // guardamos las columnas de C
                    int[][] c = generarMatriz(n, p); // creamos la matriz C con números aleatorios
                    imprimirMatriz("Matriz C", c); // mostramos la matriz C
                    imprimirMatriz("A x C", multiplicar(a, c)); // multiplicamos y mostramos el resultado
                    break; // salimos del switch
                case 4: // trasponer
                    imprimirMatriz("Traspuesta de A", trasponer(a)); // trasponemos A y mostramos el resultado
                    break; // salimos del switch
                case 0: // salir
                    System.out.println("Programa finalizado."); // mensaje de salida
                    break; // salimos del switch
                default: // si escribe una opción que no existe
                    System.out.println("Opción no válida."); // avisamos que la opción no es válida
            }
        } while (opcion != 0); // repetimos el menú hasta que elija 0

        teclado.close(); // cerramos el lector
    }

    // método que crea una matriz y la llena con números aleatorios del 1 al 9
    public static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas]; // creamos la matriz vacía
        for (int i = 0; i < filas; i++) { // recorremos las filas
            for (int j = 0; j < columnas; j++) { // recorremos las columnas
                matriz[i][j] = azar.nextInt(9) + 1; // ponemos un número aleatorio del 1 al 9
            }
        }
        return matriz; // devolvemos la matriz llena
    }

    // método que suma dos matrices posición por posición
    public static int[][] sumar(int[][] a, int[][] b) {
        int[][] resultado = new int[a.length][a[0].length]; // matriz para el resultado
        for (int i = 0; i < a.length; i++) { // recorremos las filas
            for (int j = 0; j < a[0].length; j++) { // recorremos las columnas
                resultado[i][j] = a[i][j] + b[i][j]; // sumamos los valores de la misma posición
            }
        }
        return resultado; // devolvemos la suma
    }

    // método que resta dos matrices posición por posición
    public static int[][] restar(int[][] a, int[][] b) {
        int[][] resultado = new int[a.length][a[0].length]; // matriz para el resultado
        for (int i = 0; i < a.length; i++) { // recorremos las filas
            for (int j = 0; j < a[0].length; j++) { // recorremos las columnas
                resultado[i][j] = a[i][j] - b[i][j]; // restamos los valores de la misma posición
            }
        }
        return resultado; // devolvemos la resta
    }

    // método que multiplica A por C, el resultado tiene las filas de A y las columnas de C
    public static int[][] multiplicar(int[][] a, int[][] c) {
        int m = a.length; // filas de A
        int n = a[0].length; // columnas de A, que son iguales a las filas de C
        int p = c[0].length; // columnas de C
        int[][] resultado = new int[m][p]; // matriz para el resultado
        for (int i = 0; i < m; i++) { // recorremos las filas de A
            for (int j = 0; j < p; j++) { // recorremos las columnas de C
                int suma = 0; // aquí acumulamos fila por columna
                for (int k = 0; k < n; k++) { // recorremos la fila de A y la columna de C a la vez
                    suma += a[i][k] * c[k][j]; // multiplicamos y vamos sumando
                }
                resultado[i][j] = suma; // guardamos el resultado en su posición
            }
        }
        return resultado; // devolvemos la multiplicación
    }

    // método que traspone una matriz, las filas pasan a ser columnas
    public static int[][] trasponer(int[][] a) {
        int[][] traspuesta = new int[a[0].length][a.length]; // la traspuesta tiene el tamaño al revés
        for (int i = 0; i < a.length; i++) { // recorremos las filas de A
            for (int j = 0; j < a[0].length; j++) { // recorremos las columnas de A
                traspuesta[j][i] = a[i][j]; // cambiamos fila por columna
            }
        }
        return traspuesta; // devolvemos la traspuesta
    }

    // método que muestra una matriz en forma de tabla
    public static void imprimirMatriz(String titulo, int[][] matriz) {
        System.out.println("\n" + titulo + " (" + matriz.length + " x " + matriz[0].length + "):"); // mostramos el título y el tamaño
        for (int i = 0; i < matriz.length; i++) { // recorremos las filas
            for (int j = 0; j < matriz[i].length; j++) { // recorremos las columnas
                System.out.printf("%5d", matriz[i][j]); // mostramos cada número alineado
            }
            System.out.println(); // bajamos de línea al terminar la fila
        }
    }
}
