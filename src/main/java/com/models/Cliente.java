package com.models;

import com.enums.TipoCliente;
import com.enums.TipoPersona;
import com.enums.TipoProveedor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona {
    //public Productos productosCliente; no tiene sentido

    public Cliente(String nombre, String apellido, String dni, Domicilio domicilio) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDomicilio(domicilio);
        this.setActive(true);
        this.setTipoPersona(TipoPersona.CLIENTE);
    }

    public Cliente() {
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + this.getId() + ", nombre=" + this.getNombre() +
                ", apellido=" + this.getApellido()
                + ", dni=" + this.getDni() + ", domicilio=" + this.getDomicilio() + ", tipoPersona=" +
                this.getTipoPersona() + ", email=" + this.getEmail() + ", active=" + this.getActive()+ "]";
    }


    public Cliente crearCliente() {
        Cliente generic = new Cliente();
        Domicilio domicilio;
        generic.setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        generic.setApellido(JOptionPane.showInputDialog("Ingrese el apellido:"));
        generic.setDni(JOptionPane.showInputDialog("Ingrese el DNI:"));
        generic.setEmail(JOptionPane.showInputDialog("Ingrese el email:"));

        // Cargar y establecer el domicilio usando JOptionPane
        domicilio = Domicilio.cargarDomicilio();
        generic.setDomicilio(domicilio);

        // Establecer el estado activo
        generic.setActive(true);
        return generic;
    }

    public int mostrarCliente() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                this.getApellido() + "\n" +
                        this.getNombre() + "\n" +
                        this.getActive() + "\n" +
                        this.getDni() + "\n" +
                        this.getTipoPersona() + "\n"
                , "Es correcta esta persona?", JOptionPane.YES_NO_OPTION);
        return respuesta;
    }


    @Override
    public Persona crearPersona() {

        Cliente generic = new Cliente();
        Domicilio domicilio = new Domicilio();
        generic.setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        generic.setApellido(JOptionPane.showInputDialog("Ingrese el apellido:"));
        generic.setDni(JOptionPane.showInputDialog("Ingrese el DNI:"));
        generic.setEmail(JOptionPane.showInputDialog("Ingrese el email:"));

        // Cargar y establecer el domicilio usando JOptionPane
        domicilio = Domicilio.cargarDomicilio();
        generic.setDomicilio(domicilio);

        // Establecer el estado activo
        generic.setActive(true);
        return generic;
    }



    public static Cliente modificarCliente (Cliente c){
    // cliente encontrado (no null)
    Cliente clienteGenerica = new Cliente();
    int modificarMas = JOptionPane.YES_OPTION;
                while(modificarMas ==JOptionPane.YES_OPTION) {
        String[] opciones = {"Nombre", "Apellido", "Email", "Domicilio"};
        String atributo = (String) JOptionPane.showInputDialog(null, "Seleccione el atributo a modificar:",
                "Modificar Cliente", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (atributo != null) {
            switch (atributo) {
                case "Nombre" -> {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                    clienteGenerica.setNombre(nuevoNombre);
                }
                case "Apellido" -> {
                    String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido:");
                    clienteGenerica.setApellido(nuevoApellido);
                }
                case "Email" -> {
                    String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email:");
                    clienteGenerica.setEmail(nuevoEmail);
                }
                case "Domicilio" -> {
                    JOptionPane.showMessageDialog(null, "Ingrese el nuevo domicilio");
                    clienteGenerica.setDomicilio(Domicilio.cargarDomicilio());
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
        modificarMas = JOptionPane.showConfirmDialog(null, "¿Quiere modificar más datos?", "Modificar Cliente", JOptionPane.YES_NO_OPTION);
    }

    return clienteGenerica;
}



}
