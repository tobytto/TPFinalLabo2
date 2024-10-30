package com.models;
import com.enums.CatProducto;
import java.util.Objects;
import com.validaciones.Validaciones;

public abstract class Producto implements Comparable<Producto> {
    private int idProd;
    private static int contador=0;
    private String nombreProd;
    private String marcaProd;
    private CatProducto categoriaProd;
    private int Stock;
    private double precioDeCompra;
    private double precioDeVenta;
    private String FechaVen;
    private int porcentajeVenta;

    public Producto() {
    }

    public int getIdProd() {
        return idProd;
    }


    public String getNombreProd() {
        return nombreProd;
    }

    public Producto setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
        return this;
    }

    public String getMarcaProd() {
        return marcaProd;
    }

    public Producto setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd;
        return this;
    }

    public CatProducto getCategoriaProd() {
        return categoriaProd;
    }

    public Producto setCategoriaProd(CatProducto categoriaProd) {
        this.categoriaProd = categoriaProd;
        return this;
    }

    public int getStock() {
        return Stock;
    }

    public Producto setStock(int stock) {
        Stock = stock;
        return this;
    }

    public double getPrecioDeCompra() {
        return precioDeCompra;
    }

    public Producto setPrecioDeCompra(double precio) {
        this.precioDeCompra = precio;
        return this;
    }
    public double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public Producto setPrecioDeVenta(double precio) {
        this.precioDeVenta = precio;
        return this;
    }

    public int getPorcentajeVenta() {
        return porcentajeVenta;
    }

    public Producto setPorcentajeVenta(int porcentajeVenta) {
        this.porcentajeVenta = porcentajeVenta;
        return this;
    }

    public String getFechaVen() {
        return FechaVen;
    }

    public Producto setFechaVen(String fechaVen) {
        if(Validaciones.validarFecha(fechaVen)){
            FechaVen = fechaVen;
        }
        return this;
    }

    public void vender(int cant){
        if(this.Stock>cant){
            this.Stock -= cant;
        }else{
            System.out.println("No hay stock suficiente");
        }
    }

    public void agregar(int cant){
        this.Stock += cant;
    }

    public void updatePrecio(int precioNuevo){
        this.setPrecioDeCompra(precioNuevo);
        this.precioDeVenta = precioDeVenta + (precioDeVenta*this.porcentajeVenta);
    }

   public void updatePorcentaje(int nuevoPorcenaje){
        this.setPorcentajeVenta(nuevoPorcenaje);
   }

   /*-------------------------
   // metodo que pregunta los atributos y crea un producto sin id
    // estp es para cargar despues en produtos pero antes de cargarlo verificar que no exista uno con
    // los mismos atributos asi no se duplica (se necesita un metodo en productos)
    public static Producto cargarProducto(){
        Producto producto=null;
        System.out.println("ingresar atributo1: ");
        producto.setPrecioCompra(1.0);
        return producto;
    }


   // metodo para chequear que los atributos de un producto sin tener encuenta el id no sean iguales
   public boolean mismoProducto(Producto otroProducto){
       if( // no poner el atributo id entre los que compara
               this.getPrecioCompra() == otroProducto.getPrecioCompra()&&
                       this.getPrecioVenta() == otroProducto.getPrecioVenta()
       ){return true;}
       return false;
   }

    // metodo para asignar id, despues de crear el producto y verificar en Productos se aplica este metodo
    // esto evita que se creen productos con los mismos atributos pero distinto id en el inventario
    public void asignarId(){
        this.id = this.contadorId;
        this.contadorId++;
    }

    // probablemente se necesite un metodo para cargar el Proveedor y sea argumento sea Proveedor proveedor;


    // para cambiar los atributos de un producto
    public void modificarProducto(Producto nuevoProducto){
        this.stock = nuevoProducto.stock;
        this.precioCompra = nuevoProducto.precioCompra; // y asi con cada atributo
    }

    // metodo para chequear que un Producto no tenga atributos nulos
    public boolean noNull(){
        if(this.stock != null && this.precioCompra != null){return true;}
        return false;
    }
}

  --------------------------*/



    @Override
    public int compareTo(Producto o) {
        return this.getMarcaProd().compareTo(o.getMarcaProd());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return idProd == producto.idProd && Stock == producto.Stock && Double.compare(precioDeCompra, producto.precioDeCompra) == 0 && Double.compare(precioDeVenta, producto.precioDeVenta) == 0 && porcentajeVenta == producto.porcentajeVenta && Objects.equals(nombreProd, producto.nombreProd) && Objects.equals(marcaProd, producto.marcaProd) && categoriaProd == producto.categoriaProd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreProd, marcaProd, categoriaProd, Stock, precioDeCompra, precioDeVenta, porcentajeVenta);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProd=" + idProd +
                ", nombreProd='" + nombreProd + '\'' +
                ", marcaProd='" + marcaProd + '\'' +
                ", categoriaProd=" + categoriaProd +
                ", Stock=" + Stock +
                ", precioDeCompra=" + precioDeCompra +
                ", precioDeVenta=" + precioDeVenta +
                ", FechaVen='" + FechaVen + '\'' +
                ", porcentajeVenta=" + porcentajeVenta +
                '}';
    }
}
