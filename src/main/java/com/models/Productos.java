package com.models;

import com.models.funciones.Mensajes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Productos {
    private ArrayList<Producto> productos; // agregue que sea private

    public Productos(ArrayList<Producto> productos) {
        this.productos = productos;
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public Productos() {
        productos = new ArrayList<>(0);
    }

    public void agregarProductos(Producto p) {
        productos.add(p);
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombreProd().equals(nombre)) {
                return p;
            }
        }
        return null;
    }



    public Producto getList(int index) {
        return this.productos.get(index);
    }

    public void eliminarProducto(String nombre) {
        productos.remove(buscarProducto(nombre));
    }

    public void ordenarProductosNombre() {
        Collections.sort(productos);
    }

    public Producto ultimoProductoAgregado() {
        return productos.get(productos.size() - 1); // Devuelve el último producto
    }


    //ordenar productos por fecha
    //Borrar productos por fecha
    //ordenamos por productos y que de stock total

//--------------------------- a partir de aca ver como convinar -------------------

    //buscar si existe producto iguales Sin tener en cuenta el id en productos antes de agregarlo,
// si existe devuelve el index
// si no existe -1
    public int checkearNoExisteProducto(Producto nuevoProducto) {
        int i = 0;
        for (Producto generic : this.productos) {
            if (generic.mismoProducto(nuevoProducto)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // agregar producto nuevo sin id a lista
    // verifca que no esta
    // le agrega id
    // lo agrega

    public void addProducto(Producto producto) {
        if (this.checkearNoExisteProducto(producto) == -1) {
            producto.asignarId(); // asigna id a producto e incrementa el contador
            productos.add(producto); // agrega el producto al inventario
        }
    }

    // le paso un productoConAtributosCambiado
    // busca el index para esa id
    // y modifica el producto si existe (0 estaba y fue modificado)
    // lo agrega si no existe (-1 no estaba y se agrego a la lista) (esto no deberia pasar nunca por
    // la forma que se crean productos)
// busca producto por id
// devuelve -1 si no esta o index si esta
    public int buscarProductoCriterioID(Producto productoBuscado) {
        int i = 0;
        for (Producto generic : this.productos) {
            if (generic.getIdProd() == productoBuscado.getIdProd()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void modificarProductosPorProducto(Producto nuevoProducto) {

        int index = this.buscarProductoCriterioID(nuevoProducto); // busca por id y devuelve index o -1
        this.productos.set(index, nuevoProducto);
    }

    public void actualizarStockPorPedidos(Pedido pedido) {
        for (PedidoLinea generic : pedido.getLineasPedidos()) {
            this.modificarProductosPorProducto(generic.getProducto());
        }
    }


    public int buscarProductoNombre(String nombre) {
        int i = 0;
        for (Producto generic : this.productos) {
            if (generic.getNombreProd().equals(nombre)) {
                if (generic.mostrarProducto() == JOptionPane.YES_OPTION) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public int buscarProductoMarca(String marca) {
        int i = 0;
        for (Producto generic : this.productos) {
            if (generic.getNombreProd().equals(marca)) {
                if (generic.mostrarProducto() == JOptionPane.YES_OPTION) {
                    ;
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public Producto agregarProductoAInventario() {
        Producto producto;
        producto = Producto.cargarProducto();
        if (producto.mostrarProducto() == JOptionPane.YES_OPTION) {
            Mensajes.mensajeOut("Se agrega el producto nuevo al inventario SIN STOCK");
            this.addProducto(producto);
            return this.ultimoProductoAgregado();
        }
    return null;
    }

    public void mostrarProductos(String nombre){
        for(Producto generic : this.productos){
            if(nombre == generic.getNombreProd()){
            System.out.println(generic);}
        }
    }

    public void mostrarProductos(Proveedor proveedor){
        for(Producto generic : this.productos){
            if(proveedor == generic.getProveedor()){
                System.out.println(generic);}
        }
    }

    public void mostrarProductos(){
        for(Producto generic : this.productos){
                System.out.println(generic);
        }
    }




}