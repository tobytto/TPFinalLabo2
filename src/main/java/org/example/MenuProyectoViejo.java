package org.example;

import java.util.Scanner;

public class MenuProyectoViejo {

    public static void menuCuentas() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String archivoClientes = "clientes.dat";
        String archivoCuentas = "cuentas.dat";

        do {
            System.out.println("\n Menu Cuentas:");
            System.out.println(" 1. Alta Cuenta"); // no es necesario se dan de alta cuando creamos clientes
            System.out.println(" 2. Listar Cuentas por Persona");
            System.out.println(" 3. Baja Cuenta");
            System.out.println(" 4. Activar Cuenta");
            System.out.println(" 5. Consultar Cuenta");
            System.out.println(" 6. Listar Todas Las Cuentas del lugar");
            System.out.println(" 0. Volver al Menu Principal");
            System.out.print(" Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" 1. Alta Cuenta");
                    // Lógica para alta de cuenta
                    break;
                case 2:
                    System.out.println(" 2. Listar Cuentas por Cliente");
                    // Lógica para listar cuentas por cliente
                    break;
                case 3:
                    System.out.println(" 3. Baja Cuenta");
                    // Lógica para baja de cuenta
                    break;
                case 4:
                    System.out.println(" 4. Activar Cuenta");
                    // Lógica para activar cuenta
                    break;
                case 5:
                    System.out.println(" 5. Consultar Cuenta");
                    // Lógica para consultar cuenta
                    break;
                case 6:
                    System.out.println(" 6. Listar Todas Las Cuentas del Banco");
                    // Lógica para listar todas las cuentas
                    break;
                case 0:
                    System.out.println("Volviendo al Menu Principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    public static void menuMovimientos() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n Menu Movimientos:");
            System.out.println(" 1. Alta Movimiento"); // Solo para pedidos no ejecutados
            System.out.println(" 2. Baja Movimiento"); // no necesario
            System.out.println(" 3. Modificar Movimiento"); // no necesario
            System.out.println(" 4. Listar Movimientos por Cuenta");
            System.out.println(" 5. Listar Movimientos por Fecha y por Cuenta");
            System.out.println(" 6. Listar Todos los Movimientos");
            System.out.println(" 0. Volver al Menu Principal");
            System.out.print(" Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(" 1. Alta Movimiento");
                    // Lógica para alta de movimiento
                    break;
                case 2:
                    System.out.println(" 2. Baja Movimiento");
                    // Lógica para baja de movimiento
                    break;
                case 3:
                    System.out.println(" 3. Modificar Movimiento");
                    // Lógica para modificar movimiento
                    break;
                case 4:
                    System.out.println(" 4. Listar Movimientos por Cuenta");
                    // Lógica para listar movimientos por cuenta
                    break;
                case 5:
                    System.out.println(" 5. Listar Movimientos por Fecha y por Cuenta");
                    // Lógica para listar movimientos por fecha y cuenta
                    break;
                case 6:
                    System.out.println(" 6. Listar Todos los Movimientos");
                    // Lógica para listar todos los movimientos
                    break;
                case 0:
                    System.out.println("Volviendo al Menu Principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}

