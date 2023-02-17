package maquinagolosina;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Variable que guarda la opción introducida por el usuario
        int opc;

        // Variables para especificar la posición de la máquina que elige el usuario
        int fila, col;

        // Indica la cantidad de chuches que se quieren introducir
        int cantidad;

        // Variable que guarda la contraseña
        String contraseña;

        // Variable que contiene los intentos posibles de contraseña
        int intentosCont = 3;

        // Escáner para leer datos
        Scanner key = new Scanner(System.in);

        // Rellena de con el valor predeterminado 5 la tabla cantidad
        Golosinas.rellenarMatriz(5);

        do {

            // Pide una opción al usuario
            Golosinas.muestraMenu();
            opc = key.nextInt();

            // Menú para elegir la opción
            switch (opc) {
                case 1 -> {
                    // Muestra las golosinas
                    Golosinas.mostrarGolosinas();
                    // Deja espacio en blanco para poder visualizar las golosinas y sigue cuando presione tecla
                    System.out.println("Pulse un botón para volver al menú: ");
                    key.next();
                }
                case 2 -> {
                    do {
                        // Pedir la posición
                        System.out.println("Deme el código de la chuche separado: ");
                        fila = key.nextInt();
                        col = key.nextInt();
                        // Comprueba si la posición existe en caso de que si sale del bucle
                        if (!Golosinas.validarPos(fila, col)) {
                            System.out.println("El código no existe");
                        }
                    } while (!Golosinas.validarPos(fila, col));

                    // Comprueba si hay existencias
                    if (Golosinas.hayValorPosicion(fila, col)) {
                        // Si hay golosina aumenta ventas
                        Golosinas.anyadirVenta(fila, col);
                        // Disminuye la cantidad de existencias de ese artículo
                        Golosinas.disminuirPosicion(fila, col, 1);
                        // Indica que golosina ha pedido
                        System.out.println("Has pedido la golosina " + Golosinas.nombresGolosinas[fila][col]);
                        // Avisa de que vuelve al menú
                        System.out.println("Pulse una tecla para volver al menú");
                        key.next();

                    } else {
                        // En caso de que no hayan existencias se especifica
                        System.out.println("Sin existencias de ese artículo");
                        // Avisa de que vuelve al menú
                        System.out.println("Pulse una tecla para volver al menú");
                        key.next();
                    }

                }
                case 3 -> {
                    intentosCont = 3;
                    do {
                        // Pide contraseña
                        System.out.println("Deme la contraseña: ");
                        contraseña = key.next();

                        // Comprueba que la contraseña es incorrecta
                        if (!contraseña.equals("Maquina2023")) {
                            System.out.println("Contraseña errónea");
                            intentosCont--;
                        }

                        if (intentosCont == 0) {
                            System.out.println("No hay mas intentos vuelta al menú");
                            key.next();
                        }

                    } while (intentosCont != 0 && !contraseña.equals("Maquina2023"));


                    if (contraseña.equals("Maquina2023")) {
                        do {

                            // Pedir la posición
                            System.out.println("Deme el código de la chuche separado: ");
                            fila = key.nextInt();
                            col = key.nextInt();
                            // Comprueba si la posición existe en caso de que si sale del bucle
                            if (!Golosinas.validarPos(fila, col)) {
                                System.out.println("El código no existe");
                            } else {
                                // Aumenta la posición
                                System.out.println("Cuanta cantidad del artículo quiere introducir");
                                cantidad = key.nextInt();
                                // Aumenta la cantidad del artículo
                                Golosinas.aumentarPosicion(fila, col, cantidad);
                                System.out.println("Has metido " + cantidad + " artículos de la golosina " + Golosinas.nombresGolosinas[fila][col]);
                                // Avisa de que vuelve al menú
                                System.out.println("Pulse una tecla para volver al menú");
                                key.next();
                            }
                        } while (!Golosinas.validarPos(fila, col));

                    }

                }
                case 4 -> {
                    // Por último imprime las ventas
                    Golosinas.imprimirVentasTotales();
                }

            } // Fin de switch

        } while (opc != 4);


        // Cierra escáner
        key.close();
    }
}
