package com.models;

public class Pedido {
    private Producto producto;
    private int cantidad;
    private Double montoIndividualCompra;
    private Double montoIndividualVenta;

    public Pedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoIndividualCompra = cantidad * producto.getPrecioCompra();
        this.montoIndividualVenta = cantidad * producto.getPrecioVenta();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMontoIndividualCompra() {
        return montoIndividualCompra;
    }

    public void setMontoIndividualCompra(Double montoIndividualCompra) {
        this.montoIndividualCompra = montoIndividualCompra;
    }

    public Double getMontoIndividualVenta() {
        return montoIndividualVenta;
    }

    public void setMontoIndividualVenta(Double montoIndividualVenta) {
        this.montoIndividualVenta = montoIndividualVenta;
    }
}
