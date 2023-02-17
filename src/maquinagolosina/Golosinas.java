package maquinagolosina;

import java.util.Arrays;

public class Golosinas {

    /**
     * Variable de tipo double que contiene la suma del total de compras realizadas por el usuario
     */
    static double total = 0;

    /**
     * Array que guarda el nombre de las golosinas en sus respectivas posiciones
     */
    static String[][] nombresGolosinas = {
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
    };
    /**
     * Array que guarda el precio de cada golosina en sus respectivas posiciones
     */
    static double[][] precio = {
            {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}
    };
    /**
     * Array que contiene la cantidad de golosinas que hay en cada posición
     */
    static int[][] cantidad = new int[4][4];

    /**
     * Array que guarda el nombre de las golosinas vendidas
     */
    static String[] ventas = new String[0];

    /**
     * Función que imprime un menú
     */
    static void muestraMenu() {
        System.out.println("MAQUINA DE GOLOSINAS");
        System.out.println("---------------------\n" +
                "1. Mostrar golosinas\n" +
                "2. Pedir golosinas\n" +
                "3. Rellenar golosinas\n" +
                "4. Apagar máquina\n" +
                "---------------------");
    }

    /**
     * Función que muestra las golosinas con sus nombres, código, y precio
     */
    static void mostrarGolosinas() {
        //Recorre la fila
        System.out.println("MÁQUINA GOLOSINAS");
        for (int fila = 0; fila < nombresGolosinas.length; fila++) {
            // Recorre la columna teniendo en cuenta la longitud de la fila
            for (int col = 0; col < nombresGolosinas[fila].length; col++) {
                // Imprime la tabla mediante tabuladores
                System.out.print(" " + +fila + col + " " + nombresGolosinas[fila][col] +
                        " " + precio[fila][col]);
                // Imprime un espacio
                System.out.println();
            }


        } // Fin de bucle
    }

    /**
     * Función que rellena la matriz con valores por defecto
     * @param num se asignará ese valor a toda la tabla
     * @return devuelve la tabla rellena con ese valor
     */
    static int[][] rellenarMatriz(int num) {
        // Le introducimos valores
        // Primero recorre la fila hasta el valor total de la tabla
        for (int fila = 0; fila < cantidad.length; fila++) {
            // En segundo lugar recorre las columnas de cada fila
            for (int col = 0; col < cantidad[fila].length; col++) {
                // Rellena la posición con los siguientes valores
                cantidad[fila][col] = num;
            }
        } // Fin de bucle

        return cantidad;
    }

    /**
     * Función que comprueba que la función pasada existe
     * @param fila indica la fila del array
     * @param columna indica la columna del array
     * @return devuelve un valor booleano, true en el caso de que exista esa posición
     */
    static boolean validarPos(int fila, int columna) {
        // Variable para saber si comprobar si existe la posición
        boolean existe = true;

        // Comprueba que la posición no está fuera del rango
        if ((fila < 0 || fila > 3) || (columna < 0 || columna > 3)) {
            // Si está fuera del rango es que no existe
            existe = false;
        }
        // Devuelve la variable
        return existe;
    }

    /**
     * Comprueba si hay existencias de cierto artículo
     * @param fila indica la fila del array
     * @param columna indica la columna del array
     * @return devuelve un valor booleano, true en el caso de que exista esa posición
     */
    static boolean hayValorPosicion(int fila, int columna) {
        // Crea variable booleana para saber si hay cantidad de x chuchería
        boolean existe = true;

        // Comprueba si la cantida es menor-igual a 0, eso significa que no hay existencias
        if (cantidad[fila][columna] <= 0) {
            existe = false;
        }
        // Devuelve la variable
        return existe;
    }

    /**
     * Función que añade el valor de la venta a la suma total y el nombre del artículo a la venta
     * @param fila indica la fila del array
     * @param columna indica la columna del array
     */
    static void anyadirVenta(int fila, int columna) {
        // Le añade una posición a la tabla ventas
        ventas = Arrays.copyOf(ventas, ventas.length + 1);
        // Introduce el nombre de la golosina a la tabla ventas
        ventas[ventas.length - 1] = nombresGolosinas[fila][columna];
        // Suma el total de las ventas
        total += precio[fila][columna];
    }

    /**
     * Función que disminuye la cantidad de un artículo
     * @param fila indica la fila del array
     * @param columna indica la columna del array
     * @param cantidad cantidad de artículos que se van a disminuir
     */
    static void disminuirPosicion(int fila, int columna, int cantidad) {
        // A esa posición le sumamos la cantidad pasada por parámetros
        Golosinas.cantidad[fila][columna] -= cantidad;
    }

    /**
     * Función que aumenta la cantidad de un artículo
     * @param fila indica la fila del array
     * @param columna indica la columna del array
     * @param cantidad cantidad de artículos que se van a aumentar
     * @param cantidad cantidad de artículos que se van a aumentar
     */
    static void aumentarPosicion(int fila, int columna, int cantidad) {
        // A esa posición le sumamos la cantidad pasada por parámetros
        Golosinas.cantidad[fila][columna] += cantidad;
    }

    /**
     * Función que imprime el total de las ventas
     */
    static void imprimirVentasTotales() {
        // Imprime los artículos que ha comprado y el precio
        System.out.println(Arrays.toString(ventas));
        System.out.printf("\nEl precio total de la venta es de: %.2f", total);
    }

}
