package com.models.funciones;

import com.models.Persona;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movimientos {
    private List<Movimiento> movimientos;

    public Movimientos() {
        this.movimientos=new ArrayList<>();
    }

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


    public Movimiento buscarMovimiento (LocalDate fechaInic, LocalDate fechaFin){
        for (Movimiento generic : this.movimientos){
            if ((generic.getFecha().isEqual(fechaInic) || generic.getFecha().isAfter(fechaInic))
                    && (generic.getFecha().isEqual(fechaFin) || generic.getFecha().isBefore(fechaFin))) {
                if(generic.mostrarMovimiento() == JOptionPane.YES_OPTION) {return generic;}
            }
        }
        return null;
    }

    public Movimiento buscarMovimiento (Persona persona, LocalDate fechaInic, LocalDate fechaFin){
        if (persona != null) {
            for (Movimiento generic : this.movimientos) {
                if ((generic.getFecha().isEqual(fechaInic) || generic.getFecha().isAfter(fechaInic))
                        && (generic.getFecha().isEqual(fechaFin) || generic.getFecha().isBefore(fechaFin))
                        && persona.equals(generic.getCuenta().getPersona())) {
                    if (generic.mostrarMovimiento() == JOptionPane.YES_OPTION) {
                        return generic;
                    }
                }
            }
        }
        return null;
    }

    public void invertirMovimiento(Movimiento movimientoOriginal)
    {
        this.add(movimientoOriginal.invertirMovimiento());
    }


}
