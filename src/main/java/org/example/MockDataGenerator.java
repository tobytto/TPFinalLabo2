package org.example;

import com.enums.CatProducto;
import com.enums.TipoCuenta;
import com.enums.TipoProveedor;
import com.models.*;
import com.models.funciones.Movimientos;

import java.util.ArrayList;
import java.util.Random;

public class MockDataGenerator {
    private static Random random = new Random();

    public static ArrayList<Persona> generatePersonas(int n) {
        ArrayList<Persona> personas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String nombre = "Persona" + i;
            String apellido = "Apellido" + i;
            String dni = String.valueOf(20000000 + random.nextInt(40000000));
            Domicilio domicilio = new Domicilio("Calle" + i, random.nextInt(1000), random.nextInt(10), 'A');


            Persona persona = (i % 2 == 0) ? new Cliente(nombre, apellido, dni, domicilio) :
                    new Proveedor(nombre, apellido, dni, domicilio);
            persona.setEmail("nn@gmail.com");
            personas.add(persona);
        }
        return personas;
    }

    public static ArrayList<Cuenta> generateCuentas(ArrayList<Persona> personas) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        int id = 1;
        for (Persona persona : personas) {
            Cuenta cuenta = new Cuenta(persona, TipoCuenta.values()[random.nextInt(TipoCuenta.values().length)]);
            cuentas.add(cuenta);
        }
        return cuentas;
    }

    public static ArrayList<Producto> generateProductos(ArrayList<Persona> personas) {
        ArrayList<Producto> productos = new ArrayList<>();
        int id = 0;
        for (Persona persona : personas) {
            if (persona instanceof Proveedor) {
                id++;
                Producto producto = new Producto("Producto" + id, "Marca" + id,
                        CatProducto.values()[random.nextInt(CatProducto.values().length)],
                        random.nextInt(100), 100.0, 20, (Proveedor) persona);
                producto.asignarId();
                productos.add(producto);
            }
        }
        return productos;
    }

    public static Movimientos generateMovimientos(int n) {
        Movimientos movimientos = new Movimientos();
        return movimientos;
    }
}
