package ejercicio5;

import java.util.Locale; // importamos Locale para escribir los decimales con punto
import java.util.Scanner; // importamos Scanner para leer datos del teclado

public class Main { // clase principal del programa

    public static void main(String[] args) { // aquí empieza a correr el programa
        Scanner teclado = new Scanner(System.in); // creamos el lector del teclado
        teclado.useLocale(Locale.US); // los precios se escriben con punto, por ejemplo 2.50

        System.out.print("Ingrese la cantidad de artículos (N): "); // pedimos cuántos artículos hay
        int n = teclado.nextInt(); // guardamos los artículos, serán las filas
        System.out.print("Ingrese la cantidad de sucursales (M): "); // pedimos cuántas sucursales hay
        int m = teclado.nextInt(); // guardamos las sucursales, serán las columnas

        double[][] precios = new double[n][m]; // tabla de precios de cada artículo en cada sucursal
        int[][] cantidades = new int[n][m]; // tabla de cantidades vendidas de cada artículo en cada sucursal

        System.out.println("\n--- TABLA DE PRECIOS ---"); // título de la tabla de precios
        for (int i = 0; i < n; i++) { // recorremos los artículos
            for (int j = 0; j < m; j++) { // recorremos las sucursales
                System.out.print("Precio del artículo " + (i + 1) + " en sucursal " + (j + 1) + ": "); // pedimos el precio
                precios[i][j] = teclado.nextDouble(); // guardamos el precio
            }
        }

        System.out.println("\n--- TABLA DE CANTIDADES VENDIDAS ---"); // título de la tabla de cantidades
        for (int i = 0; i < n; i++) { // recorremos los artículos
            for (int j = 0; j < m; j++) { // recorremos las sucursales
                System.out.print("Cantidad vendida del artículo " + (i + 1) + " en sucursal " + (j + 1) + ": "); // pedimos la cantidad
                cantidades[i][j] = teclado.nextInt(); // guardamos la cantidad
            }
        }

        double[][] ventas = calcularVentas(precios, cantidades); // calculamos el dinero de cada venta

        System.out.println("\n--- TOTAL DE VENTAS POR ARTÍCULO ---"); // título del primer resultado
        double[] porArticulo = sumarFilas(ventas); // sumamos cada fila para tener el total de cada artículo
        for (int i = 0; i < n; i++) { // recorremos los artículos
            System.out.printf("Artículo %d: $%.2f%n", (i + 1), porArticulo[i]); // mostramos el total con dos decimales
        }

        System.out.println("\n--- TOTAL DE VENTAS POR SUCURSAL ---"); // título del segundo resultado
        double[] porSucursal = sumarColumnas(ventas); // sumamos cada columna para tener el total de cada sucursal
        for (int j = 0; j < m; j++) { // recorremos las sucursales
            System.out.printf("Sucursal %d: $%.2f%n", (j + 1), porSucursal[j]); // mostramos el total con dos decimales
        }

        teclado.close(); // cerramos el lector
    }

    // método que multiplica el precio por la cantidad en cada posición
    public static double[][] calcularVentas(double[][] precios, int[][] cantidades) {
        double[][] ventas = new double[precios.length][precios[0].length]; // tabla para las ventas
        for (int i = 0; i < precios.length; i++) { // recorremos los artículos
            for (int j = 0; j < precios[0].length; j++) { // recorremos las sucursales
                ventas[i][j] = precios[i][j] * cantidades[i][j]; // venta es precio por cantidad
            }
        }
        return ventas; // devolvemos la tabla de ventas
    }

    // método que suma cada fila de la tabla
    public static double[] sumarFilas(double[][] tabla) {
        double[] totales = new double[tabla.length]; // un total por cada fila
        for (int i = 0; i < tabla.length; i++) { // recorremos las filas
            for (int j = 0; j < tabla[i].length; j++) { // recorremos las columnas de esa fila
                totales[i] += tabla[i][j]; // vamos sumando al total de la fila
            }
        }
        return totales; // devolvemos los totales
    }

    // método que suma cada columna de la tabla
    public static double[] sumarColumnas(double[][] tabla) {
        double[] totales = new double[tabla[0].length]; // un total por cada columna
        for (int j = 0; j < tabla[0].length; j++) { // recorremos las columnas
            for (int i = 0; i < tabla.length; i++) { // recorremos las filas de esa columna
                totales[j] += tabla[i][j]; // vamos sumando al total de la columna
            }
        }
        return totales; // devolvemos los totales
    }
}
