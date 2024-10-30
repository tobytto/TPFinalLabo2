package com.models.funciones;

import java.util.List;

public class Movimientos {
    private List<Movimiento> movimientos;

    public Movimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void add(Movimiento movimiento){
        this.movimientos.add(movimiento);
    }

    public Movimiento buscarMovimiento (int idMovimiento){
        for (Movimiento generic : this.movimientos){
            if(generic.getId()==idMovimiento){return generic;}
        }
        return null;
    }

    public Movimiento invertirMovimiento(Movimiento movimiento)
    {
        return movimiento;
    }


}
