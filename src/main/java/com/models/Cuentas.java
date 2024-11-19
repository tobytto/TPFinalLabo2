package com.models;

import com.enums.TipoCuenta;


import java.util.ArrayList;
import java.util.List;

public class Cuentas {
    private List<Cuenta> cuentas;

    public Cuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuentas() {
        cuentas = new ArrayList<>();
        this.cuentas = cuentas;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void add(Cuenta cuenta){
        this.cuentas.add(cuenta);
    }

    public Cuenta buscarCuentaPorId(int idCuenta) {
        for (Cuenta generic : this.cuentas){
            if (generic.getId()== idCuenta){return generic;}
            }
        return null;
    }

    public Cuenta buscarCuentaPorPersonaTipoCuenta(Persona persona, TipoCuenta tipo) {
        for (Cuenta generic : this.cuentas){
            if (generic.getPersona() == persona && generic.getTipoCuenta()== tipo){return generic;}
        }
        return null;
    }

    public int modificarCuentaPorCuenta(Cuenta cuenta){
        int i=0;
        for (Cuenta generic : this.cuentas){
            if (generic.getId()== cuenta.getId()){
                this.cuentas.set(i,cuenta);
                return 0;
            }
            i++;
        }
        return -1;
    }

    public void cargarCuentasNuevaPersona(Persona p){
        ArrayList <Cuenta> cuentasNuevas = Cuenta.cargarCuentasNuevaPersona(p);
        for ( Cuenta generic : cuentasNuevas ){
            this.add(generic);
        }
    }

}
