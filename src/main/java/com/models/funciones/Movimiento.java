package com.models.funciones;

import com.models.Cuenta;
import com.models.Pedidos;
import com.enums.TipoDeMovimiento;

import java.time.LocalDate;

public class Movimiento {
    private static int idContador=0;
    private int id;
    private LocalDate fecha;
    private Cuenta cuenta;
    private Pedidos productosComercializados;
    private Double montoTotal;
    private Double saldoAnterior;
    private Double saldoModificado;
    private String descripcion;



    public Movimiento() {
    }

    public Movimiento(TipoDeMovimiento tipoDeMovimiento, // compra o venta
                      Cuenta cuenta, // la cuenta donde tiene que impacatar
                      Pedidos productosComercializados, // el pedido
                      String descripcion,
                      LocalDate fecha) {
        this.id = idContador;
        this.idContador++;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.productosComercializados = productosComercializados;
        this.montoTotal = productosComercializados.getMontoTotal();
        this.saldoAnterior = cuenta.getSaldo();
        this.cuenta.setSaldo(this.saldoAnterior+ this.montoTotal);
        this.saldoModificado = cuenta.getSaldo();
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Pedidos getProductosComercializados() {
        return productosComercializados;
    }

    public void setProductosComercializados(Pedidos productosComercializados) {
        this.productosComercializados = productosComercializados;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getSaldoModificado() {
        return saldoModificado;
    }

    public void setSaldoModificado(Double saldoModificado) {
        this.saldoModificado = saldoModificado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}



