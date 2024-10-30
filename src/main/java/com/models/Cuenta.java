package com.models;
import com.enums.TipoCuenta;


public class Cuenta {
    private static int idContador=0;
    private int id;
    private Persona persona;
    private int idPersona;
    private Double saldo;
    private TipoCuenta tipoCuenta;
    private Boolean activa;

    public Cuenta(Persona persona, TipoCuenta tipo) {
        this.id = idContador;
        idContador++;
        this.persona = persona;
        this.idPersona = persona.getId();
        this.tipoCuenta = tipo;
        this.saldo=0.0;
    }

    public Cuenta() {
    }

    public int getId() {
        return id;
    }

    public Cuenta setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public Cuenta setIdPersona(int idPersona) {
        this.idPersona = idPersona;
        return this;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cuenta setSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Cuenta setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this;
    }

    public Boolean getActiva() {
        return activa;
    }

    public Cuenta setActiva(Boolean activa) {
        this.activa = activa;
        return this;
    }

    public Persona getPersona() {
        return persona;
    }

    public Cuenta setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }


}
