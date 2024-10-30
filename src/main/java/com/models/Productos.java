package com.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Productos {
    ArrayList<Producto> productos;

    public Productos() {
        productos = new ArrayList<>(0);
    }

    public void agregarProductos(Producto p){
        productos.add(p);
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (Objects.equals(p.getNombreProd(),nombre)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(String nombre){
        productos.remove(buscarProducto(nombre));
    }

    public void ordenarProductosNombre(){
        Collections.sort(productos);
    }



    //ordenar productos por fecha
    //Borrar productos por fecha
    //ordenamos por productos y que de stock total


    /*-------------------------
    //buscar si existe producto iguales Sin tener en cuenta el id en productos antes de agregarlo,
// si existe devuelve el index
// si no existe -1
    public int checkearNoExisteProducto(Producto nuevoProducto){
        int i=0;
        for(Producto generic : this.productos){
            if(generic.mismoProducto(nuevoProducto)){return i;}
            i++;
        }
        return -1;
    }

    // agregar producto nuevo sin id a lista
        // verifca que no esta
        // le agrega id
        // lo agrega
private void addProducto(Producto producto){
        if(this.checkearNoExisteProducto(producto)!=-1){
            producto.asignarId(); // asigna id a producto e incrementa el contador
            productos.add(producto); // agrega el producto al inventario
        };
}

// le paso un productoConAtributosCambiado
    // chequea que tenga todos los atributos -1 (no esta completo)
        // busca y modifica el producto si existe (0 estaba y fue modificado)
        // lo agrega si no existe (-1 no estaba y se agrego a la lista) (esto no deberia pasar nunca por
                                                                        // la forma que se crean productos)
    public int modificarProductosPorProducto(Producto nuevoProducto){
        if(nuevoProducto.noNull()) {
            int index = this.buscarProducto(nuevoProducto);
            if (index != -1) {
                this.productos.set(index, nuevoProducto);
                return 0;
            }
            if (index == 1) {
                this.productos.add(nuevoProducto);
                return 1;
            }
        }
        return -1;
    }

    // busca producto por id
        // devuelve -1 si no esta o index si esta
    public int buscarProducto(Producto productoBuscado){
        int i=0;
        for(Producto generic : this.productos){
            if(generic.getId() == productoBuscado.getId()){return i;}
            i++;
        }
        return -1;
    }

     ------------------------*/

}

