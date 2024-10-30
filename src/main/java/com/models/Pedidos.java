package com.models;

import com.enums.TipoDeMovimiento;

import java.util.List;

public class Pedidos {
    private List<Pedido> lineasPedidos;
    private TipoDeMovimiento tipoDePedido;
    private Double montoTotal;

    public Pedidos() {
    }

    public Pedidos(List<Pedido> lineasPedidos, TipoDeMovimiento tipoDePedido) {
        this.lineasPedidos = lineasPedidos;
        this.tipoDePedido = tipoDePedido;
       // metodo para calcular montoTotal()
        this.calcularMontoTotal();
    }

    public List<Pedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void setLineasPedidos(List<Pedido> lineasPedidos) {
        this.lineasPedidos = lineasPedidos;
    }

    public TipoDeMovimiento getTipoDePedido() {
        return tipoDePedido;
    }

    public void setTipoDePedido(TipoDeMovimiento tipoDePedido) {
        this.tipoDePedido = tipoDePedido;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public static void mostrarPedido(){
        // escribir para que muestre el pedido desde un formato mensajes
    }

    // metodo para generar una lista de Productos retorna List<LineaPedidoCopia> (hacer aparte necesita Productos inventarios)
    public void cargaPedidos(Productos inventario) {
        Producto productoAComprar;
        int opcion = 1;
        do {
            System.out.println("Seguir Cargando");

            productoAComprar = Producto.cargarProducto(); // pregunta los atriburos sin id del producto
            int indexProducto = inventario.checkearNoExisteProducto(productoAComprar); // busca el prodcuto y devuelve el index o -1
            // metodo para preguntar cantidadad
            int cantidad = 0;
            //fin de metododo preguntar cantidad a comprar
            Pedido lineaPedidoCopia =
                    new Pedido(inventario.getProductos().get(indexProducto), cantidad); // genera linea
            this.lineasPedidos.add(lineaPedidoCopia); // agregar linea a lista de pedidos
        } while (opcion != 0);

        this.calcularMontoTotal(); // se podria hacer adentro del for para ser más eficiente,
        // pero son más lineas y no se reutiliza codigo.
    }

    // fin de metodo para generar lista

        // metodo para calcular montoTotal()
        public void calcularMontoTotal() {
            Double montoTotal = 0.0;
            for (Pedido generic : this.lineasPedidos) {
                if (this.tipoDePedido == TipoDeMovimiento.COMPRA) {
                    montoTotal = montoTotal + generic.getMontoIndividualCompra();
                }
                if (this.tipoDePedido == TipoDeMovimiento.VENTA) {
                    montoTotal = montoTotal + generic.getMontoIndividualVenta();
                }
            }
            this.montoTotal = montoTotal;
        }
}

