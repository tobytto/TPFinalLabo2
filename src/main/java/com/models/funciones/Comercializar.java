package com.models.funciones;

import com.models.Cuenta;
import com.models.Cuentas;
import com.enums.TipoDeMovimiento;
import com.models.Pedidos;
import com.models.Productos;
import java.time.LocalDate;

public class Comercializar {


    public static void modificarProductoNuevo(Productos inventario, Cuentas cuentas, Movimientos movimientos, TipoDeMovimiento tipo) {
        Cuenta cuentaAModificar=cuentas.buscarCuentaPorId(1); // metodo para traer la cuenta a modificar de la lista cuentas (la del proveedor y del tipo)
        Pedidos pedido = new Pedidos(); // creo pedido vacio
        pedido.setTipoDePedido(tipo); // declaro que es de tipo Compra
        pedido.cargaPedidos(inventario); // carga lineasdepedido chequeando que sean productos del inventario
        // y calculo monto total del pedido

        String descripcion = "descripcion"; // metodo para ingresar texto

        Movimiento movimiento = new Movimiento(
                tipo,
                cuentaAModificar,
                pedido,
                descripcion,
                LocalDate.now()); // crea un movimiento
        movimientos.add(movimiento); // lo cargo al listado de movimientos

        cuentaAModificar = movimiento.getCuenta(); // trae la cuenta nueva con el nuevo saldo
        // metodo para modificar el stock de cada producto en el inventario
        cuentas.modificarCuentaPorCuenta(cuentaAModificar); // setea el nuevo saldo en el arreglo de cuentas

        // hacer un metodo para modificar el stock con el listado de pedidos
    }

    public static void venta(){
        // hace lo mismo que el anterior solo que cambia el TipoDeMovimiento.COMPRA a VENTA
    }
}
